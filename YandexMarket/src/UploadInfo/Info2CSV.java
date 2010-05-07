/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UploadInfo;

import CSV.CsvWriter;
import DAO.FactoryDAO;
import Pojo.KeyUploadInfo;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ilyahoo
 */
public class Info2CSV {

    public static void main(String[] args) throws SQLException, IOException{
        FactoryDAO fd = FactoryDAO.getInstance();
        CsvWriter wrtr = new CsvWriter("/home/ilyahoo/NetBeansProjects/KeyInfo1251.csv", ',', Charset.forName("WINDOWS-1251"));
        List<KeyUploadInfo> keys = (List<KeyUploadInfo>) fd.getUIKeysDAO().getAllKeys();

        String[] kInf;

        for (Iterator iter = keys.iterator(); iter.hasNext();) {
            KeyUploadInfo ks = (KeyUploadInfo) iter.next();
            kInf= new String[4];
            kInf[0]=ks.getUplKeyart();
            kInf[1]=ks.getUplPt();
            kInf[2]=ks.getUplVendor();
            kInf[3]=ks.getUplFulln();

            wrtr.writeRecord(kInf);
            System.out.println(ks.getId()+") zapisano...");
            wrtr.flush();
        }
    }
}
