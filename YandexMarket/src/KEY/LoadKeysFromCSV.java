/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KEY;


import CSV.CsvReader;
import DAO.FactoryDAO;
import Pojo.KeyFromXml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;

/**
 *
 * @author ilyahoo
 */
public class LoadKeysFromCSV {

    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
        String keyart, pt, vend;
        FactoryDAO fd = FactoryDAO.getInstance();
        KeyFromXml keys;

        CsvReader rdr = new CsvReader("/home/ilyahoo/NetBeansProjects/KeyUpload/Keys2DB.csv", ',', Charset.forName("Windows-1251"));

        while (rdr.readRecord()) {
            keyart = rdr.get(0).trim();
            pt = rdr.get(1).trim();
            vend = rdr.get(2).trim();
            System.out.println("Добавлено: " + keyart + ", " + pt + ", " + vend);

            keys = new KeyFromXml();
            keys.setKeyart(keyart);
            keys.setPt(pt);
            keys.setVendor(vend); 

            fd.getKeysDAO().addKeys(keys);
        }
        rdr.close();
    }
}
