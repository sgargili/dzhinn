/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package en;

import csv.CsvReader;
import csv.CsvWriter;
import factories.FactoryCSV;

/**
 *
 * @author Apopov
 */
public class NewClass {

    public static void main(String[] args) {
        CsvReader reader = FactoryCSV.getInstance().getCsvReader("C://test4spring.csv", "ж1111");
        try {
            reader.readHeaders();
            while (reader.readRecord()) {
                System.out.println(reader.get(0));
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        CsvWriter csvWriter = FactoryCSV.getInstance().getCsvWriter("C://testNewNew.csv", "жЖ");
        String[] array = new String[3];
        array[0] = "Привет!1";
        array[1] = "Привет!2";
        array[2] = "Привет!3";
        try {
            csvWriter.writeRecord(array);
        } catch (Exception ex) {
        } finally{
        //csvWriter.close();
        }
        array = new String[3];
        array[0] = "Привет!21";
        array[1] = "Привет!22";
        array[2] = "Привет!23";
        try {
            csvWriter.writeRecord(array);
        } catch (Exception ex) {
        } finally{
        csvWriter.close();
        }
    }
}
