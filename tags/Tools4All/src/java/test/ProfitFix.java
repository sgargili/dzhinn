package test;

import csv.CsvReader;
import csv.CsvWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 *
 * @author APopov
 */
public class ProfitFix {

    public static void main(String[] arg) throws FileNotFoundException, IOException {
        CsvWriter writer = new CsvWriter("/root/TempFolderawd.csv", ',', Charset.forName("UTF-8"));
        CsvReader reader = new CsvReader("/root/TempFolderarticles.csv", ',', Charset.forName("UTF-8"));
        String[] mass = new String[9];
        reader.readHeaders();
        int i = 1;
//        Pattern p;
//        Matcher m;
        String ss1 = "", ss2 = "";
        while (reader.readRecord()) {
            //  p = Pattern.compile("(.{" + reader.get(3).trim().length() / 2 + "}+){2}");
            //m = p.matcher(reader.get(3));
            ss1 = reader.get(3).trim().substring(0, reader.get(3).trim().length() / 2);
            ss2 = reader.get(3).trim().substring(reader.get(3).trim().length() / 2);
            if (ss1.equals(ss2) && reader.get(1).trim().equals("MICROSOFT")) {
                mass[0] = reader.get(0).trim();
                mass[1] = reader.get(1).trim();
                mass[2] = reader.get(2).trim();
                mass[3] = ss1;
                mass[4] = ss1;
                mass[5] = reader.get(5).trim();
                mass[6] = reader.get(6).trim();
                mass[7] = reader.get(7).trim();
                mass[8] = reader.get(8).trim();
                writer.writeRecord(mass);
                writer.flush();
            }
            //writer.close();
        }
    }
}
