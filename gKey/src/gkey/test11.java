/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

import csv.CsvReader;
import csv.CsvWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import pojo.art;

/**
 *
 * @author APopov
 */
public class test11 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        long start = System.currentTimeMillis();
//        Set codes = new TreeSet();
//        Set descs = new TreeSet();
//        Map matching = new HashMap();
//        String code, desc;
//        art artic;
//        List articles = new ArrayList();
        CsvWriter writer = new CsvWriter("C://dataAfter.csv", ',', Charset.forName("WINDOWS-1251"));
        String[] mass = new String[5];
        CsvReader reader = new CsvReader("C:/data.csv", ';', Charset.forName("WINDOWS-1251"));
        reader.readHeaders();
        while (reader.readRecord()) {
            mass[0] = reader.get(0).trim();
            mass[1] = "KEY_" + reader.get(1).trim();
            mass[2] = reader.get(2).trim().toUpperCase();
            mass[3] = reader.get(3).trim();
            mass[4] = reader.get(4).trim();
//            mass[5] = reader.get(5).trim();
//            mass[6] = reader.get(6).trim();
            writer.writeRecord(mass);
            writer.flush();
        }
        writer.close();
//        reader = new CsvReader("C://match.csv", ';', Charset.forName("UTF-8"));
//        reader.readHeaders();
//        while (reader.readRecord()) {
//            matching.put(reader.get(0).trim(), reader.get(1).trim());
//        }

//        for (Iterator it = articles.iterator(); it.hasNext();) {
//            artic = (art) it.next();
//            //if (!artic.getCode().equals("")) {
//            //codes.add(artic.getCode());
//            descs.add(artic.getDescr());
//            //artic = new art(code, code, "1");
//            //articles.add(artic);
//            //}
//        }
//        int i = 0;
//        for (Iterator it = articles.iterator(); it.hasNext();) {
//            artic = (art) it.next();
//            if (!artic.getCode().equals("") && matching.containsKey(artic.getCode())) {
//                artic.setSovp((String) matching.get(artic.getCode()));
//            }
//            articles.set(i++, artic);
//        }
//        CsvWriter writer = new CsvWriter("C://ouputSoft.csv", ',', Charset.forName("UTF-8"));
//        String[] mass = new String[3];
//        for (Iterator it = articles.iterator(); it.hasNext();) {
//            artic = (art) it.next();
//
//            mass[0] = artic.getCode();
//            mass[1] = artic.getDescr();
//            mass[2] = artic.getSovp();
//            writer.writeRecord(mass);
//            writer.flush();
//        }
//        writer.close();
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start);
    }
}
