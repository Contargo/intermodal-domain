package parse;

import model.Attribute;
import model.Entry;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;

import java.nio.charset.Charset;

import java.util.ArrayList;
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

        return entries;
    }


    private void addEntry(Entry entry, boolean isSubEntry) {

        if (isSubEntry) {
            entries.get(entries.size() - 1).addSubEntry(entry);
        } else {
            entries.add(entry);
        }
    }
}
