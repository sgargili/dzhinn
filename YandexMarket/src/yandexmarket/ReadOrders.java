/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import DAO.FactoryDAO;
import Pojo.Articles;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
        Articles art;
        FactoryDAO fd = FactoryDAO.getInstance();
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = new File("C:\\orders.xml");
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG &&
                    xpp.getName().equals("o") &&
                    !xpp.getAttributeValue(5).equals("")) {
                if (fd.getArticlesDAO().isArticlePresent(xpp.getAttributeValue(1))) {
                    continue;
                }
                art = new Articles();
                art.setArticle(xpp.getAttributeValue(1));
                art.setDescription(xpp.getAttributeValue(4));
                fd.getArticlesDAO().addArticles(art);
            }
            eventType = xpp.next();
        }
    }
}
