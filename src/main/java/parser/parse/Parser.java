package parser.parse;

import com.sun.deploy.util.StringUtils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import parser.model.Attribute;
import parser.model.Entry;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.charset.Charset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Parser {

    Hashtable<String, String> shortForms = new Hashtable<String, String>() {

        {
            put("LoadingUnit", "LU");
            put("SwapBody", "SB");
            put("MeansOfTransportationStatus", "MoT");
        }
    };

    private List<String> DOUBLE_FORMATS = Arrays.asList("[kg]", "[m]", "[t]", "[Fuß]", "kg", "Fuß", "m", "t", "[TEU]",
            "TEU");
    private List<String> BOOLEAN_FORMATS = Arrays.asList("{ja; nein}", "ja / nein");

    private List<String> CALCULATED_TYPES = Arrays.asList("String", "boolean", "int", "double");

    private List<Entry> entries = new ArrayList<Entry>();

    private String getAttributesString(List<Attribute> attributes) {

        String attributeString = "";

        for (Attribute attribute : attributes) {
            String type = tryToGetType(attribute.getType());

            if (!CALCULATED_TYPES.contains(type)) {
                attributeString += String.format("// TODO - type: %s\n", attribute.getType());
            }

            attributeString += String.format("private %s %s;\n\n", type, formatAttribute(attribute.getNameEnglish()));
        }

        return attributeString;
    }


    private File createFile(String name, String directory) {

        File file = null;

        try {
            if (directory.isEmpty()) {
                file = new File(String.format("src/main/java/api/%s.java", name));
            } else {
                file = new File(String.format("src/main/java/api/%s/%s.java", directory, name));
            }

            file.getParentFile().mkdirs();

            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }


    public List<Entry> parse() {

        File file = new File("src/main/resources/csv/DINSPEC91073_N0052_Rohdaten-Liste.csv");

        CSVParser parser = null;

        try {
            parser = CSVParser.parse(file, Charset.defaultCharset(), CSVFormat.RFC4180);

            Entry lastEntry = null;
            boolean isSubEntry = false;

            for (CSVRecord csvRecord : parser) {
                if (!csvRecord.get(0).isEmpty()) {
                    if (lastEntry == null) {
                        lastEntry = new Entry(csvRecord.get(0).replace(" ", ""), csvRecord.get(1).replace(" ", ""),
                                csvRecord.get(2));
                    } else if (csvRecord.get(0).startsWith(lastEntry.getNameEnglish())
                            || (shortForms.get(lastEntry.getNameEnglish()) != null
                                && csvRecord.get(0).startsWith(shortForms.get(lastEntry.getNameEnglish())))) {
                        int i = csvRecord.get(0).indexOf(".");
                        lastEntry.addAttribute(new Attribute(csvRecord.get(0).substring(i + 1), csvRecord.get(1),
                                csvRecord.get(2)));
                    } else if (csvRecord.get(0).startsWith("_")) {
                        addEntry(lastEntry, isSubEntry);
                        lastEntry = new Entry(csvRecord.get(0).substring(1).replace(" ", ""),
                                csvRecord.get(1).replace(" ", ""), csvRecord.get(2));
                        isSubEntry = true;
                    } else if (!lastEntry.getDirectory().isEmpty()
                            && StringUtils.splitString(csvRecord.get(0), ".").length >= 3
                            && csvRecord.get(0)
                            .substring(csvRecord.get(0).indexOf(".") + 1, csvRecord.get(0).length())
                            .startsWith(lastEntry.getNameEnglish())) {
                        int i = csvRecord.get(0).indexOf(".");
                        String record = csvRecord.get(0).substring(i + 1, csvRecord.get(0).length());
                        lastEntry.addAttribute(new Attribute(record.substring(record.indexOf(".") + 1),
                                csvRecord.get(1), csvRecord.get(2)));
                    } else {
                        addEntry(lastEntry, isSubEntry);
                        isSubEntry = false;

                        if (csvRecord.get(0).contains(".")) {
                            int indexForSplit = csvRecord.get(0).indexOf(".");

                            String className = csvRecord.get(0)
                                    .substring(indexForSplit + 1, csvRecord.get(0).length());
                            lastEntry = new Entry(className, csvRecord.get(1), csvRecord.get(2));

                            String directoryName = csvRecord.get(0).substring(0, indexForSplit).toLowerCase();
                            lastEntry.setDirectory(directoryName);
                        } else {
                            lastEntry = new Entry(csvRecord.get(0), csvRecord.get(1), csvRecord.get(2));
                        }
                    }
                }
            }

            addEntry(lastEntry, isSubEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }

        entries.forEach(entry -> {
            createClass(entry);

            if (!entry.getSubEntries().isEmpty()) {
                createSubClasses(entry);
            }
        });

        return entries;
    }


    private void addEntry(Entry entry, boolean isSubEntry) {

        if (isSubEntry) {
            entries.get(entries.size() - 1).addSubEntry(entry);
        } else {
            entries.add(entry);
        }
    }


    private void createClass(Entry entry) {

        try {
            File file = createFile(entry.getNameEnglish(), entry.getDirectory());

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(createFileContent(entry));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String createFileContent(Entry entry) {

        String content;

        if (entry.getSubEntries().isEmpty()) {
            content = String.format("public class %s {\n\n", entry.getNameEnglish());
        } else {
            content = String.format("public abstract class %s {\n\n", entry.getNameEnglish());
        }

        content += getAttributesString(entry.getAttributes());

        content += "}";

        return content;
    }


    private void createSubClasses(Entry entry) {

        entry.getSubEntries().stream().forEach(se -> {
            File file = createFile(se.getNameEnglish(), entry.getDirectory());

            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(createFileContentForSubClass(se, entry.getNameEnglish()));
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    private String createFileContentForSubClass(Entry entry, String inheritedClass) {

        String content = String.format("public class %s extends %s {\n\n", entry.getNameEnglish(), inheritedClass);
        content += getAttributesString(entry.getAttributes());
        content += "}";

        return content;
    }


    private String formatAttribute(String attribute) {

        String formattedAttribute = Character.toLowerCase(attribute.charAt(0)) + attribute.substring(1);
        formattedAttribute = formattedAttribute.replaceAll("[^a-zA-Z0-9-]+", "");

        String[] attributeParts = formattedAttribute.split("-");

        if (attributeParts.length > 1) {
            formattedAttribute = attributeParts[0];

            for (int i = 1; i < attributeParts.length; i++) {
                formattedAttribute += Character.toUpperCase(attributeParts[i].charAt(0))
                    + attributeParts[i].substring(1);
            }
        }

        return formattedAttribute;
    }


    private String tryToGetType(String type) {

        if (DOUBLE_FORMATS.contains(type)) {
            return "double";
        } else if (BOOLEAN_FORMATS.contains(type)) {
            return "boolean";
        } else if (type.equals("String")) {
            return "String";
        } else if (type.equals("#")) {
            return "int";
        } else if (type.contains("@")) {
            String typeTemp = type.substring(type.indexOf("@") + 1);

            if (typeTemp.indexOf(" ") > 0) {
                return typeTemp.substring(0, typeTemp.indexOf(" "));
            } else {
                return typeTemp;
            }
        } else if (type.contains("yyyy-mm-dd")) {
            return "Date";
        } else {
            return "Object";
        }
    }
}
