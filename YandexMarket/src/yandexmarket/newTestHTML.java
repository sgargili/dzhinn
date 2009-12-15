/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import DAO.FactoryDAO;
import HttpClient.http;
import Pojo.Rivals;
import Pojo.Rivalsdata;
import Pojo.RivalsdataId;
import Proxy.IpChange;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.ccil.cowan.tagsoup.Parser;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author Admin4DB2
 */
public class newTestHTML {

    private static Parser theParser = null;
    private static String theOutputEncoding = "UTF-8";

    public static void main(String[] arg) throws FileNotFoundException, UnsupportedEncodingException, IOException, SAXException, XmlPullParserException, SQLException {
        FactoryDAO fc = FactoryDAO.getInstance();
        Rivalsdata rivalData;
        Rivals rival = null;
        RivalsdataId rId;
        String src = "C:\\PSLS3E-01H00XRU.htm";
        String dst = "C:\\new.xhtml";
        OutputStream os = new FileOutputStream(dst);
        XMLReader r = new Parser();
        theParser = new Parser();
        r = theParser;
        Writer w;
        w = new OutputStreamWriter(os, theOutputEncoding);
        ContentHandler h = new XMLWriter(w);
        r.setContentHandler(h);


//  r.setProperty();
        http ht = new http();
        File fl;
        File flN = new File(src);
        IpChange ip = new IpChange();
        Pattern p = Pattern.compile("PSLS3E-01H00XRU");
        Matcher m;
        while (true) {
            //fl = ht.DownloadContentAsFile("http://market.yandex.ru/search.xml?text=iphone&nopreciser=1");
            m = p.matcher(FileUtils.readFileToString(flN, theOutputEncoding));
            if (m.find()) {
                break;
            }
            ip.setChange();
            System.out.println("????? Ip...");
        }
        //File fltest = new File(src);
        r.parse(flN.toURI().toString());

        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = new File(dst);
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), theOutputEncoding));
        boolean bool = false, bool2 = false, bool3 = false, bool4 = false, bool5 = false;
        Double rivalPrice = 0.0;
        String rivalDelivery = "";
        String rivalDescription = "";
        String rivalLink = "";
        String rivalName = "";
        int eventType = xpp.getEventType();
        int i = 0;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG &&
                    xpp.getName().equals("span") &&
                    xpp.getAttributeCount() == 1 &&
                    (xpp.getAttributeValue(0).equals("b-prices__num"))) {
                bool = true;
            }
            if (eventType == XmlPullParser.START_TAG &&
                    xpp.getName().equals("a") &&
                    xpp.getAttributeCount() > 1 &&
                    (xpp.getAttributeValue(1).equals("b-offers__name shop-link"))) {
                bool2 = true;
                rivalLink = xpp.getAttributeValue(3);
            }
            if (eventType == XmlPullParser.START_TAG &&
                    xpp.getName().equals("a") &&
                    xpp.getAttributeCount() > 1 &&
                    (xpp.getAttributeValue(1).equals("shop-link black"))) {
                bool3 = true;
            }
            if (eventType == XmlPullParser.START_TAG &&
                    xpp.getName().equals("div") &&
                    xpp.getAttributeCount() == 1 &&
                    (xpp.getAttributeValue(0).equals("b-offers__delivery"))) {
                bool4 = true;
            }
            if (eventType == XmlPullParser.START_TAG &&
                    xpp.getName().equals("b") && bool4) {
                bool5 = true;
            }
            if (eventType == XmlPullParser.TEXT && bool) {
                System.out.print(" - ");
                System.out.print(xpp.getText().replaceAll("\\s", ""));
                rivalPrice = Double.parseDouble(xpp.getText().replaceAll("[^\\d]", ""));
                FileUtils.writeStringToFile(new File("C://posm.txt"), xpp.getText());
            }
            if (eventType == XmlPullParser.TEXT && bool2) {
                System.out.print(xpp.getText());
                rivalDescription += xpp.getText();
            }
            if (eventType == XmlPullParser.TEXT && bool3) {
                rivalName = xpp.getText();
                System.out.print(" - " + xpp.getText());
            }
//            if (eventType == XmlPullParser.TEXT && bool4 && i == 1) {
            if (eventType == XmlPullParser.TEXT && bool5) {
                System.out.print(" - " + xpp.getText());
                rivalDelivery = xpp.getText();
                System.out.println(" - " + rivalLink);
            }

            if (eventType == XmlPullParser.END_TAG && (bool)) {
                bool = false;
            }
            if (eventType == XmlPullParser.END_TAG && (bool2) && xpp.getName().equals("a")) {
                bool2 = false;
            }
            if (eventType == XmlPullParser.END_TAG && (bool3) && xpp.getName().equals("a")) {
                bool3 = false;
            }
            if (eventType == XmlPullParser.END_TAG && (bool5) && xpp.getName().equals("b")) {
                bool5 = false;
            }
            if (eventType == XmlPullParser.END_TAG && (bool4) && xpp.getName().equals("span")) {
                if (i++ == 2) {
                    bool4 = false;
                    i = 0;
                    if (fc.getRivalsDAO().isRivalsPresent(rivalName)) {
                        rId = new RivalsdataId(fc.getRivalsDAO().getIdByRivals(rivalName), fc.getArticlesDAO().getIdByArticle("PSLS3E-01H00XRU"));
                    } else {
                        rival = new Rivals(rivalName);
                        fc.getRivalsDAO().addRivals(rival);
                        rId = new RivalsdataId(fc.getRivalsDAO().getIdByRivals(rivalName), fc.getArticlesDAO().getIdByArticle("PSLS3E-01H00XRU"));
                    }
                    rivalData = new Rivalsdata();
                    rivalData.setId(rId);
                    rivalData.setRivalDelivery(rivalDelivery);
                    rivalData.setRivalDescription(rivalDescription);
                    rivalData.setRivalLink(rivalLink);
                    rivalData.setRivalPrice(rivalPrice);
                    fc.getRivalsDataDAO().addRivalsdata(rivalData);
                    rivalDescription = "";
                }
            }
            eventType = xpp.next();
        }







    }
}
