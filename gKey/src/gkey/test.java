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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import pojo.art;

/**
 *
 * @author APopov
 */
public class test {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        long start = System.currentTimeMillis();
        Set codes = new TreeSet();
        Set descs = new TreeSet();
        String code, desc;
        art artic;
        List articles = new ArrayList();
        CsvReader reader = new CsvReader("C://input.csv", ';', Charset.forName("UTF-8"));
        reader.readHeaders();
        while (reader.readRecord()) {
            artic = new art(reader.get(0).trim(), reader.get(1).trim(), "0");
            articles.add(artic);
        }
        for (Iterator it = articles.iterator(); it.hasNext();) {
            artic = (art) it.next();
            //if (!artic.getCode().equals("")) {
            //codes.add(artic.getCode());
            descs.add(artic.getDescr());
            //artic = new art(code, code, "1");
            //articles.add(artic);
            //}
        }
        int i = 0;
        for (Iterator it = articles.iterator(); it.hasNext();) {
            artic = (art) it.next();
            if (!artic.getCode().equals("") && descs.contains(artic.getCode())) {
                artic.setSovp("1");
            }
            articles.set(i++, artic);
        }
        CsvWriter writer = new CsvWriter("C://ouput.csv", ',', Charset.forName("UTF-8"));
        String[] mass = new String[3];
        for (Iterator it = articles.iterator(); it.hasNext();) {
            artic = (art) it.next();

            mass[0] = artic.getCode();
            mass[1] = artic.getDescr();
            mass[2] = artic.getSovp();
            writer.writeRecord(mass);
            writer.flush();
        }
        writer.close();
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start);
    }
}
