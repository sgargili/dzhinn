/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

import org.xmlpull.v1.XmlPullParserException;
import tor.IpChange;
import dao.FactoryDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.ccil.cowan.tagsoup.Parser;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import pojo.Matching;

/**
 *
 * @author APopov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws XmlPullParserException {
        String src = "C://key.html";
        String dst = "C://new.xhtml";
        OutputStream os = null;
        XMLReader r;
        Writer w = null;
        ContentHandler h;
//        Http ht = new Http();
        File fl = new File(src);
        //File flN = new File(src);
        IpChange ip = new IpChange();
        Pattern p = Pattern.compile("(Ограничение\\sдоступа)|(404 - Not Found)");
        Matcher m;
        String tempString = "";
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = new File(dst);
        int pageCount = 1;
        String[] stringContent;
        FactoryDAO fd = FactoryDAO.getInstance();
        //List<Articles> articles = (List<Articles>) fd.getArticlesDAO().getAllArticles();
        // int i = 1;
        Matching mtch;
        try {
            os = new FileOutputStream(dst);
            r = new Parser();
            w = new OutputStreamWriter(os, "WINDOWS-1251");
            h = new XMLWriter(w);
            r.setContentHandler(h);
            r.parse(fl.toURI().toString());
            //w.close();
            xml = new File(dst);
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
            boolean bool = false, pageBool = false;
            int eventType = xpp.getEventType();
            p = Pattern.compile("Код.*теля:(.*)");
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG &&
                        xpp.getName().equals("div") &&
                        xpp.getAttributeCount() == 1 &&
                        (xpp.getAttributeValue(0).equals("white-space: nowrap;height:20px;vertical-align:middle;"))) {
                    bool = true;
                }
//                if (pageCount == 1 && eventType == XmlPullParser.START_TAG &&
//                        xpp.getName().equals("p") &&
//                        xpp.getAttributeCount() == 1 &&
//                        (xpp.getAttributeValue(0).equals("search-stat"))) {
//                    pageBool = true;
//                }
                if (eventType == XmlPullParser.TEXT && bool) {
//                    m = p.matcher(xpp.getText());
//                    if (m.find()) {
//                        code = m.group(1).trim().replaceAll(" ", "");
//                        codes.add(code);
//                    }
                    tempString = xpp.getText();
                    System.out.println(xpp.getText()); 
                }
//                if (eventType == XmlPullParser.TEXT && pageBool) {
//                    p = Pattern.compile("—\\s(\\d+)");
//                    m = p.matcher(xpp.getText());
//                    if (m.find()) {
//                        try {
//                            pageCount = Integer.parseInt(m.group(1));
//                        } catch (Exception ex) {
//                            System.out.println(ex);
//                        }
//                    }
//                }
                // System.out.println(xpp.getText());

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && (bool)) {
                    if (FactoryDAO.getInstance().getMatchingDAO().getMatchingIdByArticle("12548") == 0) {
                        mtch = new Matching();
                        mtch.setKeyarticle("12548");
                        mtch.setVendorarticle(tempString);
                        FactoryDAO.getInstance().getMatchingDAO().addMatching(mtch);
                    }
                    bool = false;
                }
//                if (eventType == XmlPullParser.END_TAG && (pageBool)) {
//                    pageBool = false;
//                }

                eventType = xpp.next();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//                xml.delete();
        try {
            os.close();
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
