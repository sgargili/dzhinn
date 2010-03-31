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

        Download dl = new DownloadImpl();
        Map map = new HashMap();
//        String[] map;
//        map=new String[3];
        Headphones map1=new Headphones();
        String article, description,vend;
        int i = 1;
        try {
            CsvReader reader = new CsvReader("C://1/1.csv", ';', Charset.forName("Windows-1251"));
            while (reader.readRecord()) {
                map1.setVendor(reader.get(1).trim());
                map1.setPicUrl(reader.get(3).trim());
                map.put(reader.get(0).trim(), map1);
//                map[0]=reader.get(0).trim();
//                map[1]=reader.get(1).trim();
//                map[2]=reader.get(2).trim();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Iterator it1 = map.keySet().iterator();
        while (it1.hasNext()) {
            article = (String) it1.next();
            map1=(Headphones) map.get(article);
            description = map1.getPicUrl();
            vend=map1.getVendor();
            System.out.println(i++ + " - " + article + " - " + vend+" "+description);
            dl.loadContentFromPleer(article, description, vend);
        }
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
        String[] mass = new String[7];
        CsvWriter writer = new CsvWriter("C://SoftAll.csv", ',', Charset.forName("WINDOWS-1251"));
        Iterator it = list.iterator();
        String[] atr;//массив со строками-атрибутами
        int ar_it = 0;//пробегает по элементам atr
        while (it.hasNext()) {
            hd = (Headphones) it.next();
            atr = hd.getAttributes().split(";");
            while (ar_it < atr.length) {
                mass[0] = hd.getFullName() + "";
                mass[1]= hd.getPicUrl()+"";

//            mass[1] = (String) fake.get(soft.getKeyArticle() + "");
//            mass[2] = soft.getFullName().replaceAll("\n", "").replaceAll("\t", "");
//            mass[3] = soft.getAttributes().replaceAll("\n", "").replaceAll("\t", "");
//            mass[4] = soft.getDescriptions().replaceAll("\n", "").replaceAll("\t", "");
//            mass[5] = soft.getBenefits().replaceAll("\n", "").replaceAll("\t", "");
//            mass[6] = soft.getSystemRequirements().replaceAll("\n", "".replaceAll("\t", ""));
                try {
                    writer.writeRecord(mass);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                writer.flush();
            }
        }
        writer.close();
    }
}
