/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package keysoft;

import csv.CsvReader;
import csv.CsvWriter;
import dao.FactoryDAO;
import interfaces.Download;
import interfaces.impl.DownloadImpl;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Headphones;
import pojo.Soft;

/**
 *
 * @author APopov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Download dl = new DownloadImpl();
//        Map map = new HashMap();
//
//        Headphones map1;
//
//        String article, description, vend;
//        int i = 1;
//        try {
//            CsvReader reader = new CsvReader("C://1/1.csv", ';', Charset.forName("Windows-1251"));
//            while (reader.readRecord()) {
//                map1 = new Headphones();
//                map1.setVendor(reader.get(1).trim());
//                map1.setPicUrl(reader.get(3).trim());
//                map.put(reader.get(0).trim(), map1);
//
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        Iterator it1 = map.keySet().iterator();
//        while (it1.hasNext()) {
//            article = (String) it1.next();
//            map1 = (Headphones) map.get(article);
//            description = map1.getPicUrl();
//            vend = map1.getVendor();
//            System.out.println(i++ + " - " + article + " - " + vend + " " + description);
//            dl.loadContentFromPleer(article, description, vend);
//        }
        //**************************************до этого идет код по считыванию контента со страниц
//        Download dl = new DownloadImpl();
//        dl.loadContentFromPleer("989898", "http://pleer.ru/_16537.html");
//        Map fake = new HashMap();
//        try {
//            CsvReader reader = new CsvReader("C://FakeArticles.csv", ';', Charset.forName("Windows-1251"));
//            while (reader.readRecord()) {
//                fake.put(reader.get(0).trim(), reader.get(1).trim());
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }


        List list = FactoryDAO.getInstance().getHeadphonesDAO().getAllHeadphones();
        Headphones hd;
        String[] mass = new String[8];
        String[] atr_val = new String[2];
        CsvWriter writer = new CsvWriter("C://1/HeadphonesUpload.csv", ',', Charset.forName("WINDOWS-1251"));
        Iterator it = list.iterator();
        String[] atr;//массив со строками-атрибутами
        int ar_it = 0;//пробегает по элементам atr
        Boolean wrt = false;
        int ctr = 0;
        while (it.hasNext()) {
            hd = (Headphones) it.next();
            ctr++;
            System.out.println("*********************************************");
            System.out.print(ctr + ") ");
            atr = hd.getAttributes().split(";");//в atr хранятся полученные строки путем разделения строки со списком атрибутов разделителем ;
            System.out.println("получается, что всего " + atr.length + " атрибутов у данного продукта");

            while (ar_it < atr.length) {

                mass[0] = hd.getFullName() + "";
                mass[1] = hd.getVendor() + "";
                mass[2] = hd.getKeyArticle() + "";
                mass[3] = "Headphones";
                mass[4] = hd.getPicUrl() + "";
                mass[5] = "Main";

                atr_val[0] = "";
                atr_val[1] = "";
                //******пытаемся разделить атрибут и его значение
                if (!atr[ar_it].equals("")) {
                    System.out.println("Строка " + atr[ar_it]);
                    if (atr[ar_it].contains(": ")) {
                        atr_val = atr[ar_it].split(":");
                        System.out.println("разделилась\":\"");
//                    wrt = true;
                    } else {
                        if (atr[ar_it].contains("-")) {
                            atr_val = atr[ar_it].split("-");
                            System.out.println("разделилась\"-\"");
//                        wrt = true;
                        }
                    }
                }
//                if (atr[ar_it].matches(" ")){
//                atr_val=atr[ar_it].split(" ");
//                }
                if (!atr_val[0].equals(null) && !atr_val[1].equals(null)&&!atr_val[0].equals(" ")) {
                    System.out.println("Атрибут: " + atr_val[0]);
                    System.out.println("значение: " + atr_val[1]);
                    mass[6] = atr_val[0];
                    mass[7] = atr_val[1];
                    wrt = true;
                }
//                mass[6]="Атрибут";
//                mass[7]=atr[ar_it];
                ar_it++;

//            mass[1] = (String) fake.get(soft.getKeyArticle() + "");
//            mass[2] = soft.getFullName().replaceAll("\n", "").replaceAll("\t", "");
//            mass[3] = soft.getAttributes().replaceAll("\n", "").replaceAll("\t", "");
//            mass[4] = soft.getDescriptions().replaceAll("\n", "").replaceAll("\t", "");
//            mass[5] = soft.getBenefits().replaceAll("\n", "").replaceAll("\t", "");
//            mass[6] = soft.getSystemRequirements().replaceAll("\n", "".replaceAll("\t", ""));
                try {
                    if (wrt == true) {
                        writer.writeRecord(mass);
                        System.out.println("Записано для продукта номер " + ctr);
                    }


                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                writer.flush();
            }
            ar_it = 0;
        }
        writer.close();
    }
}
