/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KEY;

import DAO.FactoryDAO;
import Pojo.KeyFromXml;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.ccil.cowan.tagsoup.Parser;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author ilyahoo
 */
public class fromXML2DB {

    private static String theOutputEncoding = "UTF-8";

    public static void main(String[] args) throws SQLException, XmlPullParserException {
        FactoryDAO fd = FactoryDAO.getInstance();
        List<KeyFromXml> ks = (List<KeyFromXml>) fd.getKeysDAO().getAllKeys();
        String dst = "/home/ilyahoo/NetBeansProjects/Temp/new.xhtml";
        OutputStream os = null;
        XMLReader r;
        Writer w = null;
        ContentHandler h;
        File fl;
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = new File(dst);
        KeyFromXml kdata;

        String fulln = "",
                atrs = "",
                tempAtr = "";
        boolean fn = false,
                cardBool = false,
                grBool = false,
                atrBool = false,
                atrvBool = false,
                difCardBool = false,
                difCardBool2 = false,
                itemBool = false;
        ;

        for (Iterator i = ks.iterator(); i.hasNext();) {
            KeyFromXml key = (KeyFromXml) i.next();

            fl = new File("/home/ilyahoo/NetBeansProjects/KeyUpload/XMLs/" + key.getKeyart() + ".xml");
            System.out.println("*******************************************");

            try {
                os = new FileOutputStream(dst);
                r = new Parser();
                w = new OutputStreamWriter(os, theOutputEncoding);
                h = new XMLWriter(w);

                r.setContentHandler(h);
                r.parse(fl.toURI().toString());
                xml = new File(dst);
                xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));

                int eventType = xpp.getEventType();
                kdata = new KeyFromXml();
                kdata.setId(key.getId());
                kdata.setKeyart(key.getKeyart());
                kdata.setVendor(key.getVendor());
                kdata.setPt(key.getPt());
                System.out.println(key.getId() + ") <" + key.getKeyart() + ">");
                cardBool = false;
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    //cardBool = false;

                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("good_axapta_name")) {
                        fn = true;
                    }

                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("param_name")) {
                        difCardBool = true;
                    }

                    if (eventType == XmlPullParser.TEXT && fn) {
                        fn = false;
                        fulln = xpp.getText();
                        //System.out.println(">"+fulln);
                    }

                    
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("section") && cardBool) {
                        atrs += "||" + xpp.getAttributeValue(0) + "|";
                        //System.out.println(xpp.getAttributeValue(0));
                    }

                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("section") && xpp.getAttributeCount() == 2 && xpp.getAttributeValue(0).equals("Спецификация")) {
                        cardBool = true;
                        atrs="";
                    }
                    if (eventType == XmlPullParser.TEXT && difCardBool && xpp.getText().equals("Особенности")) {
                        difCardBool = false;
                        difCardBool2 = true;
                        atrs += "||Main|";
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("param_name") && cardBool && !atrBool) {
                        atrBool = true;
                    }
                    if (eventType == XmlPullParser.TEXT && cardBool && atrBool) {
                        tempAtr += xpp.getText().trim();
                        //System.out.println("atribut "+tempAtr);
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("param_value") && cardBool && atrBool) {
                        atrvBool = true;
                        atrBool = false;
                    }
                    if (eventType == XmlPullParser.TEXT && xpp.getText().trim().length() > 2 && cardBool && atrvBool) {
                        tempAtr += " -- " + xpp.getText().trim() + ";;";
                        //System.out.println("znachen "+xpp.getText().trim());
                        atrs += tempAtr;
                        tempAtr = "";
                        atrvBool = false;
                        //atrBool = false;
                    }
                    if (eventType == XmlPullParser.TEXT && xpp.getText().trim().length() < 2 && cardBool && atrvBool) {
                        atrvBool = false;
                        tempAtr = "";
                    }

                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("item") && difCardBool2) {
                        itemBool = true;
                    }

                    if (eventType == XmlPullParser.TEXT && itemBool && difCardBool2) {
                        if (xpp.getText().trim().split(":").length == 2) {
                            atrs += xpp.getText().trim().split(":")[0] + " -- ";
                            atrs += xpp.getText().trim().split(":")[1] + ";;";
                        }
                        itemBool = false;
                    }

                    eventType = xpp.next();
                }
                System.out.println(atrs);
                kdata.setFullname(fulln);
                kdata.setAttr(atrs);
                atrs = "";
                fd.getKeysDAO().addKeys(kdata);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
