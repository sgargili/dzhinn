/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KEY;

import CSV.CsvWriter;
import DAO.FactoryDAO;
import Pojo.KeyFromXml;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ilyahoo
 */
public class KeyFromBase2CSV {

    public static void main(String[] args) throws SQLException, IOException {

        FactoryDAO fd = FactoryDAO.getInstance();
        List<KeyFromXml> keys = (List<KeyFromXml>) fd.getKeysDAO().getAllKeys();
        CsvWriter wrtr = new CsvWriter("/home/ilyahoo/NetBeansProjects/1/KeyProdsUpload.csv", ',', Charset.forName("UTF-8"));
        String[] ms;
        String[] grps, atrbs, atrbs2;
        String[] at_val;
        String tempDes;

        for (Iterator iter = keys.iterator(); iter.hasNext();) {
            KeyFromXml ks = (KeyFromXml) iter.next();
            ms = new String[8];
            if (ks.getAttr() != null) {
                System.out.println("*****************************************");
                System.out.println(ks.getId() + ") <" + ks.getKeyart() + ">");
                tempDes = ks.getAttr().replaceAll("\\|\\|[а-яА-Я_0-9\\s\\,a-zA-Z\\-\\.\\/]+\\|\\|\\|([а-яА-Я_0-9\\s\\,a-zA-Z\\-\\.\\/]+)\\|", "\\|\\|$1\\|");
                tempDes = tempDes.replaceAll("\\|\\|[а-яА-Я_0-9\\s\\,a-zA-Z\\-\\.\\/]+\\|\\|\\|([а-яА-Я_0-9\\s\\,a-zA-Z\\-\\.\\/]+)\\|", "\\|\\|$1\\|");
                System.out.println("posle zameny: " + tempDes);
                grps = tempDes.split("\\|\\|");
                tempDes = "";
                System.out.println("Y продyкта " + (grps.length - 1) + " грyпп");
                for (int i1 = 0; i1 < grps.length; i1++) {
                    atrbs = grps[i1].split("\\|");
                    //System.out.println("esli est grupps, to 2. ?: "+atrbs.length);
                    if (atrbs.length > 1) {
                        ms[0] = ks.getFullname();
                        ms[1] = ks.getVendor();
                        ms[2] = "KEY_" + ks.getKeyart();
                        ms[3] = ks.getPt();
                        ms[4] = null;
                        ms[5] = atrbs[0];
                        System.out.println("Грyппа: " + ms[5]);
                        atrbs2 = atrbs[1].split(";;");
                        System.out.println("Y продyкта в этой грyппе " + atrbs2.length + " атрибyтов");
                        for (int i2 = 0; i2 < atrbs2.length; i2++) {
                            at_val = atrbs2[i2].split(" -- ");
                            if (at_val.length > 1) {
                                ms[6] = at_val[0];
                                ms[7] = at_val[1];
                                try {
                                    wrtr.writeRecord(ms);
                                    wrtr.flush();
//                            System.out.println("Атрибyты записаны в выходной файл...");
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                        }
                    } else {
                        if (atrbs[0].length() > 2) {
                            ms[0] = ks.getFullname();
                            ms[1] = ks.getVendor();
                            ms[2] = "KEY_" + ks.getKeyart();
                            ms[3] = ks.getPt();
                            ms[4] = null;
                            ms[5] = "Main";
                            System.out.println("Грyппа: " + ms[5]);
                            atrbs2 = atrbs[0].split(";;");
                            System.out.println("Y продyкта в этой грyппе " + atrbs2.length + " атрибyтов");
                            for (int i2 = 0; i2 < atrbs2.length; i2++) {
                                at_val = atrbs2[i2].split(" -- ");
                                if (at_val.length > 1) {
                                    ms[6] = at_val[0];
                                    ms[7] = at_val[1];
                                    try {
                                        wrtr.writeRecord(ms);
                                        wrtr.flush();
//                            System.out.println("Атрибyты записаны в выходной файл...");
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        wrtr.close();
    }
}
