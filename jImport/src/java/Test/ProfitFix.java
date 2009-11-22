package Test;

import CSV.CsvReader;
import CSV.CsvWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author APopov
 */
public class ProfitFix {

    public static void main(String[] arg) throws FileNotFoundException, IOException {
        CsvWriter writer = new CsvWriter("C://awd.csv", ';', Charset.forName("UTF-8"));
        CsvReader reader = new CsvReader("c://articles.csv", ',', Charset.forName("UTF-8"));
        String[] mass = new String[4];
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
                mass[0] = reader.get(1).trim();
                mass[1] = reader.get(2).trim();
                mass[2] = reader.get(3).trim();
                mass[3] = ss1;
                writer.writeRecord(mass);
                writer.flush();
            }
            //writer.close();
        }
    }
}
