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
import java.util.Iterator;
import java.util.List;
import pojo.Keydata;
import pojo.Keywarranty;

/**
 *
 * @author APopov
 */
public class OutputData {

    public static void main(String[] args) throws SQLException, IOException {
        List data = FactoryDAO.getInstance().getKeyDataDAO().getAllKeydata();
        //List warranty = FactoryDAO.getInstance().getKeyWarrantyDAO().getKeyWarranty();
        Keydata kd;
        Keywarranty kw;
//        boolean newArtBool = true;
//        String warTemp = "";
        String newArt = "10004";
        CsvWriter csv = new CsvWriter("C://keyData.csv", ',', Charset.forName("WINDOWS-1251"));
        String[] strMas = new String[8];
        System.out.println(data.size());
        int i = 1;
        for (Iterator it = data.iterator(); it.hasNext();) {
            kd = (Keydata) it.next();
            System.out.println(i++ + " " + kd.getArticle());
            if (!newArt.equals(kd.getArticle())) {
                if (FactoryDAO.getInstance().getKeyWarrantyDAO().isWarrantyPresent(kd.getArticle())) {
                    strMas[0] = kd.getFullName();
                    strMas[1] = kd.getManufacturer();
                    strMas[2] = kd.getArticle();
                    strMas[3] = kd.getProductType();
                    strMas[4] = kd.getPictureUrl();
                    strMas[5] = "Гарантия";
                    strMas[6] = "Срок гарантии";
                    strMas[7] = FactoryDAO.getInstance().getKeyWarrantyDAO().getWarrantyByArticle(kd.getArticle());
                    csv.writeRecord(strMas);
                }
            }
            strMas[0] = kd.getFullName();
            strMas[1] = kd.getManufacturer();
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
