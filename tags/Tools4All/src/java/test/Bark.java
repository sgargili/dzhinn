/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import csv.CsvReader;
import factories.FactoryDAO4Grabli;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import pojo.Attribute;
import pojo.Groupe;
import pojo.ProductType;

/**
 *
 * @author APopov
 */
public class Bark {

    public static void main(String args[]) throws FileNotFoundException, IOException {
        FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
//        Groupe gp = fd.getGroupeDAO().getGroupeById(61);
//        //System.out.println(gp.getGroupeName());
//        Attribute atr;
//        Iterator it = gp.getAttributes().iterator();
//        while (it.hasNext()) {
//            atr = (Attribute) it.next();
//            System.out.println(gp.getGroupeName() + " - " + atr.getAttributeName());
//        }
        Groupe gp;
        Attribute atr;
        CsvReader reader = new CsvReader("c://ga.csv", ';', Charset.forName("WINDOWS-1251"));
        int i = 1;
        while (reader.readRecord()) {
            i++;
            atr = fd.getAttributeDAO().getAttributeByName(reader.get(1));
            gp = fd.getGroupeDAO().getGroupeByName(reader.get(0));
            //System.out.println(reader.get(0));
            try {
                gp.getAttributes().add(atr);
                fd.getGroupeDAO().addGroupe(gp);
                System.out.println(i + " - " + gp.getGroupeName());
            } catch (Exception ex) {
                System.out.print(i + " ");
                ex.printStackTrace();
            }
        }

//        Attribute atr1 = fd.getAttributeDAO().getAttributeById(266);
//        Attribute atr2 = fd.getAttributeDAO().getAttributeById(267);
//        Attribute atr3 = fd.getAttributeDAO().getAttributeById(268);
//        ProductType pt = fd.getProductTypeDAO().getProductTypeById(8);
//        Groupe gp1 = fd.getGroupeDAO().getGroupeById(61);
//        gp1.getAttributes().add(atr1);
//        gp1.getAttributes().add(atr2);
//        gp1.getAttributes().add(atr3);
//        gp1.getProductTypes().add(pt);
//        fd.getGroupeDAO().addGroupe(gp1);
    }
}






