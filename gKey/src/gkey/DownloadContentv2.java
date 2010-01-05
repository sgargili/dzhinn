/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

import tor.IpChange;
import dao.FactoryDAO;
import http.Http;
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
import pojo.Keyhtml;
import pojo.Keymarketing;
import pojo.Keyprice;
import pojo.Keywarranty;
import pojo.Matching;

/**
 *
 * @author Apopov
 */
public class DownloadContentv2 {

    final static String FULL_NAME1 = "margin-top: 10px; font: bold 18px Helvetica,arial;";
    final static String FULL_NAME2 = "white-space: nowrap;height:20px;vertical-align:middle;";
    final static String WARRANTY = "margin-top: 15px;";
    final static String MANUFACTURER = "width: 100px; height: 40px; border: 1px solid #aaa;";
    final static String P_TYPE = "font-weight: bold;";
    final static String PRICE = "color: brown; font: normal 18px Helvetica,arial;";
    final static String MARKETING = "text-align:justify;";
    final static String PIC = "border: solid 1px #aaa; float: left; margin-right: 10px; ";
    final static String DESCRIPTION = "table2";
    final static String TD_HEAD = "head_row21";
    final static String TD_BODY_ATR = "row223";
    final static String TD_BODY_VALUE = "row121";
    static int bayan = 0;

    public void load(String threadNum, int i, String htmlData) {
        FactoryDAO fd = FactoryDAO.getInstance();
//        try {
//            if (fd.getKeyHtmlDAO().isHtmlPresent(i + "")) {
//                System.out.println("Uzhe est' article -> " + i);
//                return;
//            }
//        } catch (Exception ex) {
//        }
        String dst = "/root/" + threadNum + ".xhtml";
        String tempFile = "/root/" + threadNum + ".html";
        //String htmlData;
        Pattern p = Pattern.compile("Ссылка");
        Matcher m;
        String fullName = "",
                warranty = "",
                manufacturer = "",
                pType = "",
                price = "",
                marketing = "",
                matching = "",
                pic = "",
                description = "",
                group = "",
                attribute = "",
                value = "",
                link = "";
        boolean fullNameBool = false,
                warBool = false,
                priceBool = false,
                marBool = false,
                pTypeBool = false,
                pTypeBoolAll = false,
                pTypeFindBool = true,
                matchBool = false,
                groupBool = false,
                atrBool = false,
                valueBool = false,
                descBool = false;
        OutputStream os = null;
        XMLReader r;
        Writer w = null;
        ContentHandler h;
        //Http ht = new Http();
        //File fl;
        //fl = ht.DownloadContentAsFile("http://shop.key.ru/shop/goods/12548", true);
        //IpChange ip = new IpChange();
        try {
            //htmlData = fd.getKeyHtmlDAO().getHtmlByArticle(i + "");
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            File xml = null;
            File html = new File(tempFile);
            FileUtils.writeStringToFile(html, htmlData, "UTF-8");
            Matching mtch;
            Keydata kd;
            Keyprice kp;
            Keymarketing km;
            Keywarranty kw;
            //Keyhtml kh;
            //int j = 1;
            try {
                // for (int i = 1500; i < 10000; i++) {
                System.out.println("Поток " + threadNum + " -> Продукт -> " + i);
//                if (bayan++ == 17) {
//                    ip.setChange();
//                    bayan = 1;
//                    System.out.println(" Сменился IP...");
//                }
//                fl = ht.DownloadContentAsFile("http://shop.key.ru/shop/goods/" + i, true, threadNum);
//                kh = new Keyhtml();
//                kh.setKeyarticle(i + "");
//                kh.setKeyhtml(FileUtils.readFileToString(fl));
//                fd.getKeyHtmlDAO().addKeyHtml(kh);
                os = new FileOutputStream(dst);
                r = new Parser();
                w = new OutputStreamWriter(os, "UTF-8");
                h = new XMLWriter(w);
                r.setContentHandler(h);
                r.parse(html.toURI().toString());
                xml = new File(dst);
                xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
                int eventType = xpp.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(FULL_NAME1) || xpp.getAttributeValue(0).equals(FULL_NAME2))) {
                        fullNameBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(WARRANTY))) {
                        warBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("img") && xpp.getAttributeCount() == 4 && (xpp.getAttributeValue(3).equals(MANUFACTURER))) {
                        manufacturer = xpp.getAttributeValue(2);
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("span") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(P_TYPE))) {
                        pTypeBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("a") && pTypeBool) {
                        pTypeBoolAll = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("span") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(PRICE))) {
                        priceBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("img") && xpp.getAttributeCount() == 3 && (xpp.getAttributeValue(2).equals(PIC))) {
                        pic = xpp.getAttributeValue(0);
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(MARKETING))) {
                        marBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("table") && xpp.getAttributeCount() == 3 && (xpp.getAttributeValue(0).equals(DESCRIPTION))) {
                        descBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("td") && xpp.getAttributeCount() == 3 && (xpp.getAttributeValue(2).equals(TD_HEAD)) && descBool) {
                        groupBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("td") && xpp.getAttributeCount() == 4 && (xpp.getAttributeValue(2).equals(TD_BODY_ATR)) && descBool) {
                        atrBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("td") && xpp.getAttributeCount() == 5 && (xpp.getAttributeValue(2).equals(TD_BODY_VALUE))) {
                        valueBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("a") && xpp.getAttributeCount() == 2 && valueBool) {
                        link = xpp.getAttributeValue(1);
                    }
                    if (eventType == XmlPullParser.TEXT && fullNameBool) {
                        fullName += xpp.getText();
                    }
                    if (eventType == XmlPullParser.TEXT && pTypeBoolAll && pTypeFindBool) {
                        pType = xpp.getText();
                        pTypeFindBool = false;
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
                    }
                    if (eventType == XmlPullParser.TEXT && atrBool) {
                        attribute = xpp.getText();
                        if (attribute.trim().equals("Код производителя")) {
                            matchBool = true;
                        }
                    }
                    if (eventType == XmlPullParser.TEXT && valueBool) {
                        value += xpp.getText() + "; ";
                        //System.out.println(value);
                    }

                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && (fullNameBool)) {
                        fullNameBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("span") && (pTypeBool)) {
                        pTypeBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && (warBool)) {
                        warBool = false;
                        kw = new Keywarranty();
                        kw.setKeyarticle(i + "");
                        kw.setKeywarranty(warranty.trim());
                        fd.getKeyWarrantyDAO().addKeyWarranty(kw);
                        warranty = "";
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("span") && (priceBool)) {
                        if (!fd.getKeyPriceDAO().isPricePresent(i + "")) {
                            kp = new Keyprice();
                            kp.setKeyarticle(i + "");
                            kp.setKeyprice(price);
                            fd.getKeyPriceDAO().addKeyPrice(kp);
                        }
                        price = "";
                        priceBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && (marBool)) {
                        if (!fd.getKeyMarketingDAO().isMarketingPresent(i + "")) {
                            km = new Keymarketing();
                            km.setKeyarticle(i + "");
                            if (marketing.equals("")) {
                                marketing = null;
                            }
                            km.setKeymarketing(marketing);
                            fd.getKeyMarketingDAO().addKeyMarketing(km);
                        }
                        marketing = "";
                        marBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && (groupBool)) {
                        groupBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && (atrBool)) {
                        atrBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && (valueBool)) {
                        if (matchBool) {
                            if (!fd.getMatchingDAO().isMatchingPresent(i + "")) {
                                mtch = new Matching();
                                mtch.setKeyarticle(i + "");
                                mtch.setVendorarticle(value.replaceAll("(; )$", ""));
                                fd.getMatchingDAO().addMatching(mtch);
                            }
                            matching = "";
                            matchBool = false;
                        }
                        valueBool = false;
                        // if (!fd.getKeyDataDAO().isKeyArticlePresent("28739")) {
                        kd = new Keydata();
                        kd.setArticle(i + "");
                        kd.setFullName(fullName);
                        kd.setManufacturer(manufacturer);
                        kd.setPictureUrl(pic);
                        kd.setProductType(pType);
                        kd.setGroupe(group);
                        kd.setAttribute(attribute);
                        m = p.matcher(value);
                        if (m.find() && !link.equals("")) {
                            value = link;
                        }
                        kd.setAttributeValue(value.replaceAll("(; )$", ""));
                        fd.getKeyDataDAO().addKeydata(kd);
                        //}
                        value = "";
                        link = "";
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("table") && (descBool)) {
                        descBool = false;
                    }
                    eventType = xpp.next();
                }
                fullName = "";
                //System.out.println(" -> Done.");
                // }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            xml.delete();
            html.delete();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            os.close();
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void load(String threadNum, int i) {
        FactoryDAO fd = FactoryDAO.getInstance();
//        try {
//            if (fd.getKeyHtmlDAO().isHtmlPresent(i + "")) {
//                System.out.println("Uzhe est' article -> " + i);
//                return;
//            }
//        } catch (Exception ex) {
//        }
        String dst = "/root/" + threadNum + ".xhtml";
        String tempFile = "/root/" + threadNum + ".html";
        String htmlData;
        Pattern p = Pattern.compile("Ссылка");
        Matcher m;
        String fullName = "",
                warranty = "",
                manufacturer = "",
                pType = "",
                price = "",
                marketing = "",
                matching = "",
                pic = "",
                description = "",
                group = "",
                attribute = "",
                value = "",
                link = "";
        boolean fullNameBool = false,
                warBool = false,
                priceBool = false,
                marBool = false,
                pTypeBool = false,
                pTypeBoolAll = false,
                pTypeFindBool = true,
                matchBool = false,
                groupBool = false,
                atrBool = false,
                valueBool = false,
                descBool = false;
        OutputStream os = null;
        XMLReader r;
        Writer w = null;
        ContentHandler h;
        //Http ht = new Http();
        //File fl;
        //fl = ht.DownloadContentAsFile("http://shop.key.ru/shop/goods/12548", true);
        //IpChange ip = new IpChange();
        try {
            htmlData = fd.getKeyHtmlDAO().getHtmlByArticle(i + "");
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            File xml = null;
            File html = new File(tempFile);
            FileUtils.writeStringToFile(html, htmlData, "UTF-8");
            Matching mtch;
            Keydata kd;
            Keyprice kp;
            Keymarketing km;
            Keywarranty kw;
            //Keyhtml kh;
            //int j = 1;
            try {
                // for (int i = 1500; i < 10000; i++) {
                System.out.println("Поток " + threadNum + " -> Продукт -> " + i);
//                if (bayan++ == 17) {
//                    ip.setChange();
//                    bayan = 1;
//                    System.out.println(" Сменился IP...");
//                }
//                fl = ht.DownloadContentAsFile("http://shop.key.ru/shop/goods/" + i, true, threadNum);
//                kh = new Keyhtml();
//                kh.setKeyarticle(i + "");
//                kh.setKeyhtml(FileUtils.readFileToString(fl));
//                fd.getKeyHtmlDAO().addKeyHtml(kh);
                os = new FileOutputStream(dst);
                r = new Parser();
                w = new OutputStreamWriter(os, "UTF-8");
                h = new XMLWriter(w);
                r.setContentHandler(h);
                r.parse(html.toURI().toString());
                xml = new File(dst);
                xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
                int eventType = xpp.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(FULL_NAME1) || xpp.getAttributeValue(0).equals(FULL_NAME2))) {
                        fullNameBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(WARRANTY))) {
                        warBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("img") && xpp.getAttributeCount() == 4 && (xpp.getAttributeValue(3).equals(MANUFACTURER))) {
                        manufacturer = xpp.getAttributeValue(2);
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("span") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(P_TYPE))) {
                        pTypeBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("a") && pTypeBool) {
                        pTypeBoolAll = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("span") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(PRICE))) {
                        priceBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("img") && xpp.getAttributeCount() == 3 && (xpp.getAttributeValue(2).equals(PIC))) {
                        pic = xpp.getAttributeValue(0);
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(MARKETING))) {
                        marBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("table") && xpp.getAttributeCount() == 3 && (xpp.getAttributeValue(0).equals(DESCRIPTION))) {
                        descBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("td") && xpp.getAttributeCount() == 3 && (xpp.getAttributeValue(2).equals(TD_HEAD)) && descBool) {
                        groupBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("td") && xpp.getAttributeCount() == 4 && (xpp.getAttributeValue(2).equals(TD_BODY_ATR)) && descBool) {
                        atrBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("td") && xpp.getAttributeCount() == 5 && (xpp.getAttributeValue(2).equals(TD_BODY_VALUE))) {
                        valueBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("a") && xpp.getAttributeCount() == 2 && valueBool) {
                        link = xpp.getAttributeValue(1);
                    }
                    if (eventType == XmlPullParser.TEXT && fullNameBool) {
                        fullName += xpp.getText();
                    }
                    if (eventType == XmlPullParser.TEXT && pTypeBoolAll && pTypeFindBool) {
                        pType = xpp.getText();
                        pTypeFindBool = false;
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
                    }
                    if (eventType == XmlPullParser.TEXT && atrBool) {
                        attribute = xpp.getText();
                        if (attribute.trim().equals("Код производителя")) {
                            matchBool = true;
                        }
                    }
                    if (eventType == XmlPullParser.TEXT && valueBool) {
                        value += xpp.getText() + "; ";
                        //System.out.println(value);
                    }

                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && (fullNameBool)) {
                        fullNameBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("span") && (pTypeBool)) {
                        pTypeBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && (warBool)) {
                        warBool = false;
                        kw = new Keywarranty();
                        kw.setKeyarticle(i + "");
                        kw.setKeywarranty(warranty.trim());
                        fd.getKeyWarrantyDAO().addKeyWarranty(kw);
                        warranty = "";
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("span") && (priceBool)) {
                        if (!fd.getKeyPriceDAO().isPricePresent(i + "")) {
                            kp = new Keyprice();
                            kp.setKeyarticle(i + "");
                            kp.setKeyprice(price);
                            fd.getKeyPriceDAO().addKeyPrice(kp);
                        }
                        price = "";
                        priceBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && (marBool)) {
                        if (!fd.getKeyMarketingDAO().isMarketingPresent(i + "")) {
                            km = new Keymarketing();
                            km.setKeyarticle(i + "");
                            if (marketing.equals("")) {
                                marketing = null;
                            }
                            km.setKeymarketing(marketing);
                            fd.getKeyMarketingDAO().addKeyMarketing(km);
                        }
                        marketing = "";
                        marBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && (groupBool)) {
                        groupBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && (atrBool)) {
                        atrBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && (valueBool)) {
                        if (matchBool) {
                            if (!fd.getMatchingDAO().isMatchingPresent(i + "")) {
                                mtch = new Matching();
                                mtch.setKeyarticle(i + "");
                                mtch.setVendorarticle(value.replaceAll(".*", "eee"));
                                fd.getMatchingDAO().addMatching(mtch);
                            }
                            matching = "";
                            matchBool = false;
                        }
                        valueBool = false;
                        // if (!fd.getKeyDataDAO().isKeyArticlePresent("28739")) {
                        kd = new Keydata();
                        kd.setArticle(i + "");
                        kd.setFullName(fullName);
                        kd.setManufacturer(manufacturer);
                        kd.setPictureUrl(pic);
                        kd.setProductType(pType);
                        kd.setGroupe(group);
                        kd.setAttribute(attribute);
                        m = p.matcher(value);
                        if (m.find() && !link.equals("")) {
                            value = link;
                        }
                        kd.setAttributeValue(value.replaceAll("(; )$", ""));
                        fd.getKeyDataDAO().addKeydata(kd);
                        //}
                        value = "";
                        link = "";
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("table") && (descBool)) {
                        descBool = false;
                    }
                    eventType = xpp.next();
                }
                fullName = "";
                //System.out.println(" -> Done.");
                // }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            xml.delete();
            html.delete();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            os.close();
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
