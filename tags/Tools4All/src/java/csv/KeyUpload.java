/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author APopov
 */
public class KeyUpload {

    public static void main(String[] arg) throws FileNotFoundException, IOException {
        long time = -System.currentTimeMillis();
        Map matchMap = new HashMap();
        CsvReader reader = new CsvReader("C://Match.csv", ';', Charset.forName("WINDOWS-1251"));
        CsvWriter csvw = new CsvWriter("C://After.csv", ',', Charset.forName("Windows-1251"));
        String[] mass = new String[2];
        while (reader.readRecord()) {
            matchMap.put(reader.get(0), reader.get(1));
        }
        reader = new CsvReader("C://Opis.csv", ';', Charset.forName("WINDOWS-1251"));
        while (reader.readRecord()) {
            mass[0] = (String) matchMap.get(reader.get(0));
            mass[1] = reader.get(1);
            csvw.writeRecord(mass);
        }
        reader.close();
        csvw.close();
        time += System.currentTimeMillis();
        System.out.println(time);

//        for (int row = 0; row < rows; row++) {
//            for (int column = 0; column < columns; column++) {
//                temp[column] = sheet.getCell(column, row).getContents();
//            }
//            csvw.writeRecord(temp);
//        }
//        csvw.close();

    }
}
