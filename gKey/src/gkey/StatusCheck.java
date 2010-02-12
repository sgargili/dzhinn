/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

import csv.CsvReader;
import csv.CsvWriter;
import http.Http;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import pojo.KeyStatus;

/**
 *
 * @author APopov
 */
public class StatusCheck {

    public static void main(String[] arg) throws FileNotFoundException, IOException, XmlPullParserException {

        Http http = new Http();

        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();

        XmlPullParser xpp = factory.newPullParser();
        XmlPullParser xpp2 = factory.newPullParser();
        int eventType, eventType2;

        int i = 0;

        CsvReader reader = new CsvReader("C://Key.csv", ';', Charset.forName("Windows-1251"));

        KeyStatus key;
        List<KeyStatus> keyList = new ArrayList();

        String valXml, profXml;

        while (reader.readRecord()) {
            key = new KeyStatus();
            key.setArticle(reader.get(0));
            keyList.add(key);
        }
        for (Iterator it = keyList.iterator(); it.hasNext();) {
            try {
                key = (KeyStatus) it.next();
                System.out.println(i + " -> " + key.getArticle());
                valXml = http.DownloadContentAsString("http://213.53.57.39/cfInfoWS/cfcode.exml?article=" + key.getArticle(), "UTF-8", false);
                xpp.setInput(new ByteArrayInputStream(valXml.getBytes("UTF-8")), "UTF-8");
                eventType = xpp.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("article")) {
                        key.setArticleId(xpp.getAttributeValue(0));
                        key.setStatus(xpp.getAttributeValue(6));
                        key.setProductType(xpp.getAttributeValue(9));
                        key.setFullName(xpp.getAttributeValue(4));
                        key.setCard("0");

                        profXml = http.DownloadContentAsString("http://213.53.57.39/shopInfoWSwar/product.exml?product=" + key.getArticleId(), "UTF-8", false);
                        xpp2.setInput(new ByteArrayInputStream(profXml.getBytes("UTF-8")), "UTF-8");
                        eventType2 = xpp2.getEventType();
                        while (eventType2 != XmlPullParser.END_DOCUMENT) {
                            if (eventType2 == XmlPullParser.START_TAG && xpp2.getName().equals("attr")) {
                                key.setCard("1");
                            }
                            eventType2 = xpp2.next();
                        }

                        keyList.set(i++, key);
                    }
                    eventType = xpp.next();
                }
                Thread.sleep(300);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        CsvWriter writer = new CsvWriter("C://ouputAll.csv", ',', Charset.forName("UTF-8"));
        String[] mass = new String[6];
        for (Iterator it = keyList.iterator(); it.hasNext();) {
            key = (KeyStatus) it.next();
            mass[0] = key.getArticle();
            mass[1] = key.getArticleId();
            mass[2] = key.getFullName();
            mass[3] = key.getProductType();
            mass[4] = key.getStatus();
            mass[5] = key.getCard();
            writer.writeRecord(mass);
            writer.flush();
        }
        writer.close();
    }
}
