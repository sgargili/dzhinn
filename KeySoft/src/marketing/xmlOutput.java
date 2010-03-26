/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package marketing;

import com.thoughtworks.xstream.XStream;
import csv.CsvReader;
import dao.FactoryDAO;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.io.FileUtils;
import pojo.Soft;

/**
 *
 * @author Apopov
 */
public class xmlOutput {

    public static void main(String[] args) throws SQLException, IOException {

        List data = FactoryDAO.getInstance().getSoftDAO().getAllNonEmptySofts();
        Soft soft;
        //System.out.println(data.size());

        Set need = new TreeSet();
        CsvReader reader = new CsvReader("C://need.csv", ';', Charset.forName("Windows-1251"));
        while (reader.readRecord()) {
            need.add(reader.get(0).trim());
        }

        List outData = new ArrayList();

        Iterator it = data.iterator();

        //String temp;

        while (it.hasNext()) {
            soft = (Soft) it.next();
            if (need.contains(soft.getKeyArticle() + "")) {
                outData.add(soft);
            }
        }
        System.out.println(outData.size());
        XStream xstream = new XStream();
        xstream.alias("item", Soft.class);
        xstream.alias("list", List.class);
        xstream.registerConverter(new xmlConvertor());
        OutputStream out = FileUtils.openOutputStream(new File("C://keyMarketing.xml"));
        xstream.toXML(outData, out);
        out.flush();
        out.close();
    }
}

  