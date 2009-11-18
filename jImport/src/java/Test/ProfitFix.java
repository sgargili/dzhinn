/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
        while (reader.readRecord()) {
            Pattern p = Pattern.compile("(.{60,100}){2}");
            Matcher m = p.matcher(reader.get(3));
            if (m.find() && reader.get(1).trim().equals("MICROSOFT")) {
                mass[0] = reader.get(1).trim();
                mass[1] = reader.get(2).trim();
                mass[2] = reader.get(3).trim();
                mass[3] = m.group(1);
//                System.out.println(m.group(1));
//                System.out.println(i++ + " " + reader.get(1).trim() + " " + reader.get(2).trim() + " " + reader.get(3).trim());
                writer.writeRecord(mass);
                writer.flush();
            }
            //writer.close();
        }
    }
}
