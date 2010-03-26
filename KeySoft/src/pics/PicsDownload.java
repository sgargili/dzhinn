/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pics;

import csv.CsvReader;
import dao.FactoryDAO;
import http.Http;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import pojo.Soft;

/**
 *
 * @author APopov
 */
public class PicsDownload {

    public static void main(String[] arg) throws FileNotFoundException, IOException {
        Map temp = new HashMap();
        Set need = new TreeSet();
        Soft soft;
        try {
            List lst = FactoryDAO.getInstance().getSoftDAO().getAllNonEmptySofts();
            for (Iterator it = lst.iterator(); it.hasNext();) {
                soft = (Soft) it.next();
                temp.put(soft.getKeyArticle(), soft.getPicUrl());
            }
        } catch (Exception ex) {
        }

        CsvReader reader = new CsvReader("C://need.csv", ';', Charset.forName("Windows-1251"));
        while (reader.readRecord()) {
            need.add(reader.get(0).trim());
        }

        System.out.println(need.size());
        Http ht = new Http();
        //IpChange ip = new IpChange();
        int k = 0;
        int iter = 0;
        String tempStr;
        String picURL;
        for (Iterator it = need.iterator(); it.hasNext();) {
            tempStr = (String) it.next();
            picURL = (String) temp.get(Integer.parseInt(tempStr));
            System.out.println(iter++ + " - " + tempStr + " - ya kartinka skachivaetsya...");
            ht.DownloadBinaryFile(picURL, true, tempStr);
        }
    }
}
