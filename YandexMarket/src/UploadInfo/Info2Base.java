/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UploadInfo;

import CSV.CsvReader;
import DAO.FactoryDAO;
import Pojo.KeyUploadInfo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;

/**
 *
 * @author ilyahoo
 */
public class Info2Base {

    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
        String keyart, pt, vend, uplka, uplpt, uplvend, fn, uplfn;
        FactoryDAO fd = FactoryDAO.getInstance();
        KeyUploadInfo keys;

        CsvReader rdr = new CsvReader("/home/ilyahoo/NetBeansProjects/KeyUpload/Keys2DB9000.csv", ',', Charset.forName("Windows-1251"));

        while (rdr.readRecord()) {
            uplka = rdr.get(0).trim();
            keyart = rdr.get(1).trim();
            pt = rdr.get(2).trim();
            vend = rdr.get(3).trim();
            fn = rdr.get(4).trim();
            uplpt = rdr.get(5).trim();
            uplvend = rdr.get(6).trim();
            uplfn = rdr.get(7).trim();
            System.out.println("Добавлено: " + uplka + ", " + keyart + ", " + pt + ", " + vend + ", " + fn);

            keys = new KeyUploadInfo();
            keys.setUplKeyart(uplka);
            keys.setKeyart(keyart);
            keys.setPt(pt);
            keys.setVendor(vend);
            keys.setFulln(fn);

            fd.getUIKeysDAO().addKeys(keys);
        }
        rdr.close();
    }
}
