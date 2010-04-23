/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import CSV.CsvWriter;
import DAO.FactoryDAO;
import Pojo.Newarticles;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ilyahoo
 */
public class FromBase2CSV {

    public static void main(String[] args) throws SQLException, IOException {

        FactoryDAO fd = FactoryDAO.getInstance();
        List<Newarticles> articles = (List<Newarticles>) fd.getnewArticlesDAO().getAllArticles();
        CsvWriter wrtr = new CsvWriter("/home/ilyahoo/NetBeansProjects/1/YMProdsUpload.csv", ',', Charset.forName("UTF-8"));
        String[] ms;
        String[] grps, atrbs, atrbs2;
        String[] at_val;

        for (Iterator iter = articles.iterator(); iter.hasNext();) {
            Newarticles art = (Newarticles) iter.next();
            ms = new String[8];
            if (art.getAttr() != null) {
                System.out.println("*****************************************");
                System.out.println(art.getId() + ") <" + art.getKeyart() + ">");
                grps = art.getAttr().split("\\|\\|");
                System.out.println("Y продyкта " + (grps.length - 1) + " грyпп");
                for (int i1 = 1; i1 < grps.length; i1++) {
                    atrbs = grps[i1].split("\\|");
                    if (atrbs.length > 1) {
                        ms[0] = art.getLongdescr();
                        ms[1] = art.getVendor();
                        ms[2] = art.getKeyart();
                        ms[3] = art.getPt();
                        ms[4] = art.getPicurl();
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
                    }
                }
            }
        }
        wrtr.close();
    }
}
