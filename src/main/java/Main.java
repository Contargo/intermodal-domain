import Model.Attribute;
import Model.Entry;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;

import java.nio.charset.Charset;

import java.util.ArrayList;
import java.util.List;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File(
                "/home/duerlich/Contargo/din-spec-91073-parser/src/main/resources/DINSPEC91073_N0052_Rohdaten-Liste.csv");

        CSVParser parser = CSVParser.parse(file, Charset.defaultCharset(), CSVFormat.RFC4180);

        List<Entry> entries = new ArrayList<Entry>();
        Entry last = null;

        for (CSVRecord csvRecord : parser) {
            if (last == null) {
                last = new Entry(csvRecord.get(0).replace(" ", ""), csvRecord.get(1).replace(" ", ""),
                        csvRecord.get(2));
            } else if (csvRecord.get(0).startsWith(last.getNameEnglish() + ".")) {
                last.addAttribute(new Attribute(csvRecord.get(0), csvRecord.get(1), csvRecord.get(2)));
            } else if (csvRecord.get(0).startsWith("_")) {
            } else {
                entries.add(last);
                last = new Entry(csvRecord.get(0), csvRecord.get(1), csvRecord.get(2));
            }
        }

        int a = 1;
    }
}
