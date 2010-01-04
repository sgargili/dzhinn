/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

import csv.CsvWriter;
import dao.FactoryDAO;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pojo.Keydata;
import pojo.Keywarranty;

/**
 *
 * @author APopov
 */
public class OutputData {

    public static void main(String[] args) throws SQLException, IOException {

        List warranty = FactoryDAO.getInstance().getKeyWarrantyDAO().getKeyWarranty();
        Keydata kd;
        Keywarranty kw;
        //Set warData = new HashSet();
        Map warMap = new HashMap();
        for (Iterator it = warranty.iterator(); it.hasNext();) {
            kw = (Keywarranty) it.next();
            //warData.add(kw.getKeyarticle());
            warMap.put(kw.getKeyarticle(), kw.getKeywarranty());
        }

        String newArt = "10004";
        CsvWriter csv = null;
        for (int r = 0; r < 25; r++) {
            List data = FactoryDAO.getInstance().getKeyDataDAO().getAllKeydata((25000 + 1) * r, 25000);
            csv = new CsvWriter("/home/admin/keyData/keyData" + r + ".csv", ',', Charset.forName("WINDOWS-1251"));
            String[] strMas = new String[8];
            System.out.println(data.size());
            int i = 1;
            for (Iterator it = data.iterator(); it.hasNext();) {
                kd = (Keydata) it.next();
                System.out.println(r + " - " + i++ + " " + kd.getArticle());
                if (!newArt.equals(kd.getArticle())) {
                    if (warMap.containsKey(kd.getArticle())) {
                        strMas[0] = kd.getFullName();
                        if (kd.getManufacturer() == null || kd.getManufacturer().replaceAll("(\\n)|(\\r)(\\r\\n)|(\\n\\r)", "").equals("")) {
                            strMas[1] = "NoName";
                        } else {
                            strMas[1] = kd.getManufacturer().replaceAll("(\\n)|(\\r)(\\r\\n)|(\\n\\r)", "");
                        }
                        strMas[2] = kd.getArticle();
                        strMas[3] = kd.getProductType();
                        strMas[4] = kd.getPictureUrl();
                        strMas[5] = "Гарантия";
                        strMas[6] = "Срок гарантии";
                        strMas[7] = (String) warMap.get(kd.getArticle());
                        csv.writeRecord(strMas);
                    }
                }
                strMas[0] = kd.getFullName();
                if (kd.getManufacturer() == null || kd.getManufacturer().replaceAll("(\\n)|(\\r)(\\r\\n)|(\\n\\r)", "").equals("")) {
                    strMas[1] = "NoName";
                } else {
                    strMas[1] = kd.getManufacturer().replaceAll("(\\n)|(\\r)(\\r\\n)|(\\n\\r)", "");
                }
                strMas[2] = kd.getArticle();
                strMas[3] = kd.getProductType();
                strMas[4] = kd.getPictureUrl();
                strMas[5] = kd.getGroupe();
                strMas[6] = kd.getAttribute();
                strMas[7] = kd.getAttributeValue().replaceAll("(\\n)|(\\r)(\\r\\n)|(\\n\\r)", "");
                csv.writeRecord(strMas);
                newArt = kd.getArticle();
            }
            csv.close();
        }
    }
}

