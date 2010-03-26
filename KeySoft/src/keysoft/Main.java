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
//        String article, description;
//        int i = 1;
//        try {
//            CsvReader reader = new CsvReader("C://FakeArticles.csv", ';', Charset.forName("Windows-1251"));
//            while (reader.readRecord()) {
//                map.put(reader.get(0).trim(), reader.get(1).trim());
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        Iterator it = map.keySet().iterator();
//        while (it.hasNext()) {
//            article = (String) it.next();
//            description = (String) map.get(article);
//            System.out.println(i++ + " - " + article + " - " + description);
//            dl.loadContentFromCdDiski(article, dl.askGoogle(description));
//        }
        Download dl = new DownloadImpl();
        dl.loadContentFromCdVSeti("989898", "http://www.cdvseti.ru/id14664.html");
//        Map fake = new HashMap();
//        try {
//            CsvReader reader = new CsvReader("C://FakeArticles.csv", ';', Charset.forName("Windows-1251"));
//            while (reader.readRecord()) {
//                fake.put(reader.get(0).trim(), reader.get(1).trim());
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        List list = FactoryDAO.getInstance().getSoftDAO().getAllNonEmptySofts();
//        Soft soft;
//        String[] mass = new String[7];
//        CsvWriter writer = new CsvWriter("C://SoftAll.csv", ',', Charset.forName("WINDOWS-1251"));
//        Iterator it = list.iterator();
//        while (it.hasNext()) {
//            soft = (Soft) it.next();
//            mass[0] = soft.getKeyArticle() + "";
//            mass[1] = (String) fake.get(soft.getKeyArticle() + "");
//            mass[2] = soft.getFullName().replaceAll("\n", "").replaceAll("\t", "");
//            mass[3] = soft.getAttributes().replaceAll("\n", "").replaceAll("\t", "");
//            mass[4] = soft.getDescriptions().replaceAll("\n", "").replaceAll("\t", "");
//            mass[5] = soft.getBenefits().replaceAll("\n", "").replaceAll("\t", "");
//            mass[6] = soft.getSystemRequirements().replaceAll("\n", "".replaceAll("\t", ""));
//            try {
//                writer.writeRecord(mass);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//            writer.flush();
//        }
//        writer.close();
    }
}
