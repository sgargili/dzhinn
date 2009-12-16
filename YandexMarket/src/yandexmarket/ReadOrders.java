/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import CSV.CsvWriter;
import DAO.FactoryDAO;
import HttpClient.http;
import Pojo.Articles;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import org.apache.commons.io.FileUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author Admin4DB2
 */
public class ReadOrders {

    public static void main(String[] args) throws XmlPullParserException, UnsupportedEncodingException, IOException, SQLException {
        long start = System.currentTimeMillis();
        File orders = new File("orders.csv");
        CsvWriter writer = new CsvWriter(orders.getAbsolutePath(), ',', Charset.forName("UTF-8"));
        String[] mass = new String[2];
        Articles art;
        FactoryDAO fd = FactoryDAO.getInstance();
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = new File("temp");
        int tempInt = 0;
//        http ht = new http();
//        File xml = ht.DownloadContentAsFile("http://213.53.57.20/CatExp/orders.exml", false);
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG
                    && xpp.getName().equals("o")
                    && !xpp.getAttributeValue(4).equals("")
                    && xpp.getAttributeValue(5).equals("")) {
//                if (fd.getArticlesDAO().isArticlePresent(xpp.getAttributeValue(1))) {
//                    continue;
//                }
                try {
                    tempInt = Integer.parseInt(xpp.getAttributeValue(1).trim());
                } catch (NumberFormatException ex) {
                    eventType = xpp.next();
                    continue;
                }
                mass[0] = xpp.getAttributeValue(1);
                mass[1] = xpp.getAttributeValue(4);
                writer.writeRecord(mass);
                writer.flush();
//                art = new Articles();
//                art.setArticle(xpp.getAttributeValue(1));
//                art.setDescription(xpp.getAttributeValue(4));
//                fd.getArticlesDAO().addArticles(art);
            }
            eventType = xpp.next();
        }
        long end = System.currentTimeMillis();
        fd.getArticlesDAO().fillArticles(orders.getPath());
        System.out.println((end - start) / 1000);
    }
}
