/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import HttpClient.http;
import Proxy.IpChange;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
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
 * @author APopov
 */
public class TestRegion {

    private static Parser theParser = null;
    private static String theOutputEncoding = "UTF-8";

    public static void main(String[] arg) throws FileNotFoundException, UnsupportedEncodingException, IOException, SAXException, XmlPullParserException, SQLException {
        String src = "C:\\http.htm";
        String dst = "C:\\new.xhtml";
        OutputStream os;
        os = FileUtils.openOutputStream(new File(dst));
        XMLReader r = new Parser();
        theParser = new Parser();
        r = theParser;
        Writer w;
        w = new OutputStreamWriter(os, theOutputEncoding);
        ContentHandler h = new XMLWriter(w);
        r.setContentHandler(h);

        http ht = new http();
        File fl;
        File flN = new File(src);
        IpChange ip = new IpChange();
        Pattern p = Pattern.compile("Apple");
        Matcher m;
        while (true) {
            ht.setCookie("http://tune.yandex.ru/region/save2.xml?fretpath=http://market.yandex.ru&domain=yandex.ru&retpath=http://market.yandex.ru&region_id=213", true);
            fl = ht.DownloadContentAsFile("http://market.yandex.ru/search.xml?text=iphone&nopreciser=1", true);
            m = p.matcher(FileUtils.readFileToString(fl, theOutputEncoding));
            //System.out.println(FileUtils.readFileToString(flN, theOutputEncoding));
            if (m.find()) {
                System.out.println("Вышел из цикла...");
                break;
            }
            ip.setChange();
            System.out.println("Сменился Ip...");
        }
        //File fltest = new File(src);
        r.parse(fl.toURI().toString());

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = new File(dst);
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "WINDOWS-1251"));
        boolean bool = false;
        int eventType = xpp.getEventType();
        Set<String> codes = new TreeSet<String>();
        p = Pattern.compile(":\\s(.*)");
        String code;
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG &&
                    xpp.getName().equals("div") &&
                    xpp.getAttributeCount() == 1 &&
                    (xpp.getAttributeValue(0).equals("region"))) {
                bool = true;
            }
            if (eventType == XmlPullParser.TEXT && bool) {
                //System.out.println(xpp.getText());
                m = p.matcher(xpp.getText());
                if (m.find()) {
                    code = m.group(1);
                    codes.add(code);
                }
                // System.out.println(xpp.getText());
            }

            if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && bool) {
                bool = false;
            }

            eventType = xpp.next();
        }


        for (Iterator iter = codes.iterator(); iter.hasNext();) {
            code = (String) iter.next();
            System.out.println(code.trim());
        }




    }
}
