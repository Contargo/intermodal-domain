package parse;

import model.Attribute;
import model.Entry;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

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

    private List<String> DOUBLE_FORMATS = Arrays.asList("[kg]", "[m]", "[t]", "[Fuß]", "kg", "Fuß", "m");
    private List<String> BOOLEAN_FORMATS = Arrays.asList("{ja; nein}", "ja / nein");

    public List<Entry> entries = new ArrayList<Entry>();

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
                        lastEntry.addAttribute(new Attribute(csvRecord.get(0), csvRecord.get(1), csvRecord.get(2)));
                    } else if (csvRecord.get(0).startsWith("_")) {
                        addEntry(lastEntry, isSubEntry);
                        lastEntry = new Entry(csvRecord.get(0).substring(1).replace(" ", ""),
                                csvRecord.get(1).replace(" ", ""), csvRecord.get(2));
                        isSubEntry = true;
                    } else {
                        addEntry(lastEntry, isSubEntry);
                        isSubEntry = false;
                        lastEntry = new Entry(csvRecord.get(0), csvRecord.get(1), csvRecord.get(2));
                    }
                }
            }

            addEntry(lastEntry, isSubEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }

        entries.forEach(this::createFile);

        return entries;
    }


    private void addEntry(Entry entry, boolean isSubEntry) {

        if (isSubEntry) {
            entries.get(entries.size() - 1).addSubEntry(entry);
        } else {
            entries.add(entry);
        }
    }


    public void createFile(Entry entry) {

        try {
            File tmp = new File(String.format("out/%s.java", entry.getNameEnglish()));
            tmp.getParentFile().mkdirs();

            tmp.createNewFile();

            FileWriter fileWriter = new FileWriter(tmp);
            fileWriter.write(createFileContent(entry));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String createFileContent(Entry entry) {

        String content = String.format("public class %s {\n\n", entry.getNameEnglish());

        for (Attribute attribute : entry.getAttributes()) {
            String type = tryToGetType(attribute.getType());

            if (type.equals("Object")) {
                content += String.format("// TODO - type: %s\n", attribute.getType());
            }

            content += String.format("private %s %s;\n\n", type, attribute.getNameEnglish());
        }

        content += "}";

        return content;
    }


    private String tryToGetType(String type) {

        if (DOUBLE_FORMATS.contains(type)) {
            return "double";
        } else if (BOOLEAN_FORMATS.contains(type)) {
            return "boolean";
        } else if (type.equals("String")) {
            return "String";
        } else {
            return "Object";
        }
    }
}
