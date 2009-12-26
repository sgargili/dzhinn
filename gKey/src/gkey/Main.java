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
import pojo.Keydata;
import pojo.Keymarketing;
import pojo.Keyprice;
import pojo.Matching;

/**
 *
 * @author APopov
 */
public class Main {

    final static String FULL_NAME1 = "margin-top: 10px; font: bold 18px Helvetica,arial;";
    final static String FULL_NAME2 = "white-space: nowrap;height:20px;vertical-align:middle;";
    final static String WARRANTY = "margin-top: 15px;";
    final static String MANUFACTURER = "width: 100px; height: 40px; border: 1px solid #aaa;";
    final static String PRICE = "color: brown; font: normal 18px Helvetica,arial;";
    final static String MARKETING = "text-align:justify;";
    final static String PIC = "border: solid 1px #aaa; float: left; margin-right: 10px; ";
    final static String DESCRIPTION = "table2";
    final static String TD_HEAD = "head_row21";
    final static String TD_BODY_ATR = "row223";
    final static String TD_BODY_VALUE = "row121";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws XmlPullParserException {
        String src = "C://key.html";
        String dst = "C://new.xhtml";
        String fullName = "",
                warranty = "",
                manufacturer = "",
                price = "",
                marketing = "",
                pic = "",
                description = "",
                group = "",
                attribute = "",
                value = "";
        boolean fullNameBool = false,
                warBool = false,
                priceBool = false,
                marBool = false,
                groupBool = false,
                atrBool = false,
                valueBool = false,
                descBool = false;
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
        Keydata kd;
        Keyprice kp;
        Keymarketing km;
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
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("div")
                        && xpp.getAttributeCount() == 1
                        && (xpp.getAttributeValue(0).equals(FULL_NAME1) || xpp.getAttributeValue(0).equals(FULL_NAME2))) {
                    fullNameBool = true;
                }
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("div")
                        && xpp.getAttributeCount() == 1
                        && (xpp.getAttributeValue(0).equals(WARRANTY))) {
                    warBool = true;
                }
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("img")
                        && xpp.getAttributeCount() == 4
                        && (xpp.getAttributeValue(3).equals(MANUFACTURER))) {
                    manufacturer = xpp.getAttributeValue(2);
                }
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("span")
                        && xpp.getAttributeCount() == 1
                        && (xpp.getAttributeValue(0).equals(PRICE))) {
                    priceBool = true;
                }
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("img")
                        && xpp.getAttributeCount() == 3
                        && (xpp.getAttributeValue(2).equals(PIC))) {
                    pic = xpp.getAttributeValue(0);
                }
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("div")
                        && xpp.getAttributeCount() == 1
                        && (xpp.getAttributeValue(0).equals(MARKETING))) {
                    marBool = true;
                }
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("table")
                        && xpp.getAttributeCount() == 3
                        && (xpp.getAttributeValue(0).equals(DESCRIPTION))) {
                    descBool = true;
                    //System.out.println(xpp.getAttributeType(1));
                }
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("td")
                        && xpp.getAttributeCount() == 3
                        && (xpp.getAttributeValue(2).equals(TD_HEAD))
                        && descBool) {
//                    System.out.println(xpp.getAttributeValue(0));
//                    System.out.println(xpp.getAttributeName(0));
//                    System.out.println(xpp.getAttributeValue(1));
//                    System.out.println(xpp.getAttributeName(1));
//                    System.out.println(xpp.getAttributeValue(2));
//                    System.out.println(xpp.getAttributeName(2));
                    groupBool = true;
                }
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("td")
                        && xpp.getAttributeCount() == 4
                        && (xpp.getAttributeValue(2).equals(TD_BODY_ATR))
                        && descBool) {
//                    System.out.println(xpp.getAttributeValue(0));
//                    System.out.println(xpp.getAttributeName(0));
//                    System.out.println(xpp.getAttributeValue(1));
//                    System.out.println(xpp.getAttributeName(1));
//                    System.out.println(xpp.getAttributeValue(2));
//                    System.out.println(xpp.getAttributeName(2));
//                    System.out.println(xpp.getAttributeValue(3));
//                    System.out.println(xpp.getAttributeName(3));
                    atrBool = true;
                }
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("td")
                        && xpp.getAttributeCount() == 5
                        && (xpp.getAttributeValue(2).equals(TD_BODY_VALUE)) //                        && atrBool
                        ) {
//                    System.out.println(xpp.getAttributeValue(0));
//                    System.out.println(xpp.getAttributeName(0));
//                    System.out.println(xpp.getAttributeValue(1));
//                    System.out.println(xpp.getAttributeName(1));
//                    System.out.println(xpp.getAttributeValue(2));
//                    System.out.println(xpp.getAttributeName(2));
//                    System.out.println(xpp.getAttributeValue(3));
//                    System.out.println(xpp.getAttributeName(3));
                    valueBool = true;
                }
                if (eventType == XmlPullParser.TEXT && fullNameBool) {
                    fullName += xpp.getText();
                }
                if (eventType == XmlPullParser.TEXT && warBool) {
                    warranty += xpp.getText();
                }
                if (eventType == XmlPullParser.TEXT && priceBool) {
                    price += xpp.getText();
                }
                if (eventType == XmlPullParser.TEXT && marBool) {
                    marketing += xpp.getText();
                }
                if (eventType == XmlPullParser.TEXT && groupBool) {
                    group = xpp.getText();
                    // System.out.println(group);
                }
                if (eventType == XmlPullParser.TEXT && atrBool) {
                    attribute = xpp.getText();
                    //System.out.println(attribute);
                }
                if (eventType == XmlPullParser.TEXT && valueBool) {
                    value += xpp.getText();
                    // System.out.println(value);
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && (fullNameBool)) {
                    fullNameBool = false;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && (warBool)) {
                    warBool = false;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("span") && (priceBool)) {
                    kp = new Keyprice();
                    kp.setKeyarticle("28739");
                    kp.setKeyprice(price);
                    FactoryDAO.getInstance().getKeyPriceDAO().addKeyPrice(kp);
                    priceBool = false;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && (marBool)) {
                    km = new Keymarketing();
                    km.setKeyarticle("28739");
                    km.setKeymarketing(marketing);
                    FactoryDAO.getInstance().getKeyMarketingDAO().addKeyMarketing(km);
                    marBool = false;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && (groupBool)) {
                    groupBool = false;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && (atrBool)) {
                    atrBool = false;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && (valueBool)) {
                    valueBool = false;
                    kd = new Keydata();
                    kd.setArticle("28739");
                    kd.setFullName(fullName);
                    kd.setManufacturer(manufacturer);
                    kd.setPictureUrl(pic);
                    kd.setGroupe(group);
                    kd.setAttribute(attribute);
                    kd.setAttributeValue(value);
                    FactoryDAO.getInstance().getKeyDataDAO().addKeydata(kd);
                    value = "";
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("table") && (descBool)) {
                    descBool = false;
                }
                eventType = xpp.next();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            os.close();
            w.close();
//            System.out.println(fullName.trim());
//            System.out.println(warranty.trim());
//            System.out.println(manufacturer.trim());
//            System.out.println(price.trim());
//            System.out.println(pic.trim());
            //System.out.println(marketing.trim());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
