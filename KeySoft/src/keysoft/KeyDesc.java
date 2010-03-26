/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package keysoft;

import csv.CsvReader;
import csv.CsvWriter;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author APopov
 */
public class KeyDesc {

    public static void main(String[] args) {
        Pattern p0 = Pattern.compile("BOX");
        Pattern p = Pattern.compile("jewel");

        Pattern p2 = Pattern.compile("CD");
        Pattern p3 = Pattern.compile("DVD");
        Matcher m;
        try {
            CsvWriter writer = new CsvWriter("C://KeyFakeOut.csv", ',', Charset.forName("Windows-1251"));
            String[] mass = new String[6];
            try {
                CsvReader reader = new CsvReader("C://KeyFake.csv", ';', Charset.forName("Windows-1251"));
                while (reader.readRecord()) {
                    mass[0] = reader.get(0).trim();
                    mass[1] = reader.get(1).trim();
                    mass[2] = reader.get(2).trim();
                    mass[3] = reader.get(3).trim();
                    mass[4] = "";
                    mass[5] = "";
                    m = p.matcher(reader.get(3).trim());
                    if (m.find()) {
                        mass[4] = "Jewel Case";
                    } else {
                        m = p0.matcher(reader.get(3).trim());
                        if (m.find()) {
                            mass[4] = "Box";
                        }
                    }
                    m = p2.matcher(reader.get(3).trim());
                    if (m.find()) {
                        mass[5] = "CD";
                    } else {
                        m = p3.matcher(reader.get(3).trim());
                        if (m.find()) {
                            mass[5] = "DVD";
                        }
                    }
                    writer.writeRecord(mass);
                    writer.flush();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
