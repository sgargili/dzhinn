package csv;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: PAV
 * Date: 10.11.2010
 * Time: 23:20:35
 * To change this template use File | Settings | File Templates.
 */
public class Ira {
    public static void main(String[] args) {
        Map<String, String> f1 = new HashMap();
        Map<String, String> f2 = new HashMap();
        CsvReader csvReaderF1 = FactoryCsv.getInstance().getCsvReader("C://123/f1.csv", ";", "UTF-8");
        CsvReader csvReaderF2 = FactoryCsv.getInstance().getCsvReader("C://123/f2.csv", ";", "UTF-8");
        try {
            while (csvReaderF1.readRecord()) {
                f1.put(csvReaderF1.get(0).trim(), "");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            while (csvReaderF2.readRecord()) {
                f2.put(csvReaderF2.get(0).trim(), csvReaderF2.get(1).trim());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Set<String> f1Set = f1.keySet();
        Set<String> f2Set = f2.keySet();

        for (String article1 : f1Set) {
            for (String article2 : f2Set) {
                if (article1.equals(article2)) {
                    f1.put(article1, f2.get(article2));
                    break;
                }
            }

        }

        CsvWriter cswWriter = FactoryCsv.getInstance().getCsvWriter("C://123Out.csv", ",", "UTF-8");

        String[] mass = new String[2];

        for (String article1 : f1Set) {
            mass[0] = article1;
            mass[1] = f1.get(article1);
            try {
                cswWriter.writeRecord(mass);
            } catch (IOException e) {
            }

        }
        cswWriter.close();
        System.out.println("");

    }
}
