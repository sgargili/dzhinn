/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tempfile;

import csv.CsvReader;
import csv.CsvWriter;
import factories.FactoryDAO4Grabli;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import pojo.Groupe;
import pojo.ProductType;

/**
 *
 * @author Apopov
 */
public class UploadGroupe {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        CsvReader reader = new CsvReader("c://groupes.csv", ',', Charset.forName("UTF-8"));
        Map atrs = new HashMap();
        Map grps = new HashMap();
        String[] vals = new String[2];
        List out = new ArrayList();
//        FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
//        Groupe gp;
//        ProductType pt = null;
//        String temp = "@@@@@@||||";
//        int i = 0;
        while (reader.readRecord()) {
//            try {
//                pt = fd.getProductTypeDAO().getProductTypeByName(reader.get(0).trim());
//                gp = fd.getGroupeDAO().getGroupeByName(reader.get(1).trim());
//                gp.getProductTypes().add(pt);
//                fd.getGroupeDAO().addGroupe(gp);
//            } catch (Exception ex) {
//            }
//            System.out.println(i++);
            grps.put(reader.get(1).trim(), reader.get(0).trim());

        }
        reader.close();
        System.out.println(grps.size());
        reader = new CsvReader("c://atr.csv", ',', Charset.forName("UTF-8"));
        while (reader.readRecord()) {
//            try {
//                pt = fd.getProductTypeDAO().getProductTypeByName(reader.get(0).trim());
//                gp = fd.getGroupeDAO().getGroupeByName(reader.get(1).trim());
//                gp.getProductTypes().add(pt);
//                fd.getGroupeDAO().addGroupe(gp);
//            } catch (Exception ex) {
//            }
//            System.out.println(i++);
            atrs.put(reader.get(1).trim(), reader.get(0).trim());

        }
        reader.close();
        System.out.println(atrs.size());
        //System.out.println(atrs.get("Alcoholic Beverage"));
        CsvWriter writer = new CsvWriter("c://1/gr2atrOut.csv", ',', Charset.forName("UTF-8"));
        //String[] mass = new String[7];
//        Iterator it = ods.iterator();
//        try {
//            while (it.hasNext()) {
//                od = (OutputData) it.next();
//                mass[0] = od.getArticle();
//                mass[1] = od.getGroupe();
//                mass[2] = od.getAttribute();
//                mass[3] = od.getValue();
//                mass[4] = od.getUnit();
//                mass[5] = "";
//                mass[6] = "";
//                if (od.getAvailable() == 1) {
//                    writer.writeRecord(mass);
//                }
//            }
//            writer.close();
//        } catch (Exception ex) {
//        }
        reader = new CsvReader("c://gp2atr.csv", ';', Charset.forName("UTF-8"));
        while (reader.readRecord()) {
            try {
                vals[1] = (String) atrs.get(reader.get(1).trim());
                vals[0] = (String) grps.get(reader.get(0).trim());
                //System.out.println(reader.get(0).trim());
                writer.writeRecord(vals);
                writer.flush();
            } catch (Exception ex) {
                System.out.println(ex);
            }

//            try {
//                pt = fd.getProductTypeDAO().getProductTypeByName(reader.get(0).trim());
//                gp = fd.getGroupeDAO().getGroupeByName(reader.get(1).trim());
//                gp.getProductTypes().add(pt);
//                fd.getGroupeDAO().addGroupe(gp);
//            } catch (Exception ex) {
//            }
//            System.out.println(i++);
            //pts.put(reader.get(1).trim(), reader.get(0).trim());


        }
        reader.close();
         writer.close();
        //System.out.println(pts.size());

    }
}
