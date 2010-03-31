/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.impl;

import dao.FactoryDAO;
import http.Http;
import interfaces.Download;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.ccil.cowan.tagsoup.Parser;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import pojo.Headphones;
import pojo.Soft;

/**
 *
 * @author APopov
 */
public class DownloadImpl implements Download {

//    private static final String GAME_PAGE = "game_page";
//    private static final String IMG_LINK = "img_link";
//    private static final String OBJECT_TITLE = "object_title";
//    private static final String OBJECT_MANUF = "object_manuf";
//    private static final String OBJECT_PROG = "object_prog";
//    private static final String OBJECT_DATE = "object_date";
//    private static final String OBJECT_TYPE = "object_type";
//    private static final String OBJECT_BOX = "object_box";
//    private static final String OBJECT_LANG = "object_lang";
    public void loadContentFromCdDiski(String article, String url) {
        String GAME_PAGE = "game_page";
        String IMG_LINK = "img_link";
        String OBJECT_TITLE = "object_title";
        String OBJECT_MANUF = "object_manuf";
        String OBJECT_PROG = "object_prog";
        String OBJECT_DATE = "object_date";
        String OBJECT_TYPE = "object_type";
        String OBJECT_BOX = "object_box";
        String OBJECT_LANG = "object_lang";

        FactoryDAO fd = FactoryDAO.getInstance();
        Soft soft;
        if (url.equals("") || url == null) {
            soft = new Soft();
            soft.setKeyArticle(Integer.parseInt(article));
            soft.setFullName("Google нифига не нашел...");
            fd.getSoftDAO().addSoft(soft);
            return;
        }
        Http http = new Http();
        String htmlData = http.DownloadContentAsString(url, "WINDOWS-1251", true);

        String dst = "C://javaTemp/dst.xhtml";

        String tempFile = "C://javaTemp/temp.html";

        Pattern p = Pattern.compile("Ссылка");

        Matcher m;

        String fullName = "",
                pic = "",
                title = "",
                manufacturer = "",
                programmers = "",
                date = "",
                type = "",
                box = "",
                lang = "",
                description = "",
                benefits = "",
                systemReq = "",
                attributes = "";

        boolean fullNameBool = false,
                titleBool = false,
                manufacturerBool = false,
                programmersBool = false,
                dateBool = false,
                typeBool = false,
                boxBool = false,
                langBool = false,
                descriptionBool = false,
                benefitsBool = false,
                systemReqBool = false;



        OutputStream os = null;

        XMLReader r;

        Writer w = null;

        ContentHandler h;

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            File xml = null;
            File html = new File(tempFile);
            FileUtils.writeStringToFile(html, htmlData, "UTF-8");

            try {

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
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(GAME_PAGE))) {
                        fullNameBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(OBJECT_TITLE))) {
                        titleBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("img") && xpp.getAttributeCount() == 3 && (xpp.getAttributeValue(0).equals(IMG_LINK)) && xpp.getAttributeValue(2).trim().equals(fullName)) {
                        pic = xpp.getAttributeValue(1);
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(OBJECT_MANUF))) {
                        manufacturerBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(OBJECT_PROG))) {
                        programmersBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(OBJECT_DATE))) {
                        dateBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(OBJECT_TYPE))) {
                        typeBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(OBJECT_BOX))) {
                        boxBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(OBJECT_LANG))) {
                        langBool = true;
                    }
                    if (eventType == XmlPullParser.TEXT && fullNameBool) {
                        fullName = xpp.getText().trim();
                    }
                    if (eventType == XmlPullParser.TEXT && titleBool) {
                        title += xpp.getText();
                    }
                    if (eventType == XmlPullParser.TEXT && manufacturerBool) {
                        manufacturer += xpp.getText();
                    }
                    if (eventType == XmlPullParser.TEXT && programmersBool) {
                        programmers += xpp.getText();
                    }
                    if (eventType == XmlPullParser.TEXT && dateBool) {
                        date += xpp.getText();
                    }
                    if (eventType == XmlPullParser.TEXT && typeBool) {
                        type += xpp.getText();
                    }
                    if (eventType == XmlPullParser.TEXT && boxBool) {
                        box += xpp.getText();
                    }
                    if (eventType == XmlPullParser.TEXT && langBool) {
                        lang += xpp.getText();
                    }
                    if (eventType == XmlPullParser.TEXT && xpp.getText().trim().equals("Описание")) {
                        descriptionBool = true;

                    }
                    if (eventType == XmlPullParser.TEXT && xpp.getText().trim().equals("Особенности")) {
                        descriptionBool = false;
                        benefitsBool = true;
                    }
                    if (eventType == XmlPullParser.TEXT && xpp.getText().trim().equals("Системные требования")) {
                        benefitsBool = false;
                        systemReqBool = true;
                    }
                    if (eventType == XmlPullParser.TEXT && xpp.getText().trim().equals("Отзывы")) {
                        systemReqBool = false;
                    }
                    if (eventType == XmlPullParser.TEXT && descriptionBool) {
                        description += xpp.getText().trim();
                    }
                    if (eventType == XmlPullParser.TEXT && benefitsBool) {
                        benefits += xpp.getText().trim();
                    }
                    if (eventType == XmlPullParser.TEXT && systemReqBool) {
                        systemReq += xpp.getText().trim();
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("h1") && (fullNameBool)) {
                        fullNameBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && titleBool) {
                        titleBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && manufacturerBool) {
                        manufacturerBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && programmersBool) {
                        programmersBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && dateBool) {
                        dateBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && typeBool) {
                        typeBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && boxBool) {
                        boxBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && langBool) {
                        langBool = false;
                    }
                    eventType = xpp.next();
                }
//                System.out.println(fullName);
//                System.out.println(pic);
//                System.out.println(title);
//                System.out.println(manufacturer);
//                System.out.println(programmers);
//                System.out.println(date);
//                System.out.println(type);
//                System.out.println(box);
//                System.out.println(lang);
//                System.out.println(description);
//                System.out.println(benefits);
//                System.out.println(systemReq);
                attributes = title + "|||" + manufacturer + "|||" + programmers + "|||" + date + "|||" + type + "|||" + lang;
                soft = new Soft();
                soft.setFullName(fullName);
                soft.setDescriptions(description.replaceAll("Описание", ""));
                soft.setPicUrl(pic);
                soft.setSystemRequirements(systemReq.replaceAll("Системные требования", ""));
                soft.setBenefits(benefits.replaceAll("Особенности", ""));
                soft.setAttributes(attributes);
                soft.setKeyArticle(Integer.parseInt(article));
//                fd.getSoftDAO().addSoft(soft);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            xml.delete();
            html.delete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            os.close();
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String askGoogle(String description) {

        try {
            description = URLEncoder.encode(description.trim(), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        String url = "http://www.google.com/search?hl=ru&q=" + description + "+site:cddiski.ru";
        Http http = new Http();
        String htmlData = http.DownloadContentAsString(url, "UTF-8", true);

        String dst = "C://javaTemp/dstGoogle.xhtml";

        String tempFile = "C://javaTemp/tempGoogle.html";
        boolean bool = true;

        OutputStream os = null;

        XMLReader r;

        Writer w = null;

        ContentHandler h;

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            File xml = null;
            File html = new File(tempFile);
            FileUtils.writeStringToFile(html, htmlData, "UTF-8");

            try {

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
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("a") && xpp.getAttributeCount() == 4 && (xpp.getAttributeValue(0).equals("rect")) && (xpp.getAttributeValue(1).equals("l")) && bool) {
                        url = xpp.getAttributeValue(2).trim();
                        bool = false;
                    }

                    eventType = xpp.next();
                }
                //System.out.println(url);


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
        return url;
    }

    public void loadContentFromCdVSeti(String article, String url) {

        String GAME_PAGE = "desc";
        String IMG_LINK = "img_link";
        String OBJECT_TITLE = "object_title";
        String OBJECT_MANUF = "object_manuf";
        String OBJECT_PROG = "object_prog";
        String OBJECT_DATE = "object_date";
        String OBJECT_TYPE = "object_type";
        String OBJECT_BOX = "object_box";
        String OBJECT_LANG = "object_lang";

        FactoryDAO fd = FactoryDAO.getInstance();
        Soft soft;
        if (url.equals("") || url == null) {
            soft = new Soft();
            soft.setKeyArticle(Integer.parseInt(article));
            soft.setFullName("Google нифига не нашел...");
            fd.getSoftDAO().addSoft(soft);
            return;
        }
        Http http = new Http();
        String htmlData = http.DownloadContentAsString(url, "WINDOWS-1251", true);

        String dst = "C://javaTemp/dst.xhtml";

        String tempFile = "C://javaTemp/temp.html";
        String sss;

        Pattern p = Pattern.compile("buymessage");

        Matcher m;

        String fullName = "",
                pic = "",
                title = "",
                manufacturer = "",
                programmers = "",
                date = "",
                type = "",
                box = "",
                lang = "",
                description = "",
                benefits = "",
                systemReq = "",
                attributes = "";

        boolean fullNameBool = false,
                titleBool = false,
                manufacturerBool = false,
                programmersBool = false,
                dateBool = false,
                typeBool = false,
                boxBool = false,
                langBool = false,
                descriptionBool = false,
                benefitsBool = false,
                systemReqBool = false;



        OutputStream os = null;

        XMLReader r;

        Writer w = null;

        ContentHandler h;

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            File xml = null;
            File html = new File(tempFile);
            FileUtils.writeStringToFile(html, htmlData, "UTF-8");

            try {

                os = new FileOutputStream(dst);
                r = new Parser();
                w = new OutputStreamWriter(os, "UTF-8");
                h = new XMLWriter(w);
                r.setContentHandler(h);
                r.parse(html.toURI().toString());
                xml = new File(dst);
                xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
                int eventType = xpp.getEventType();
                //до этого стандартно

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(GAME_PAGE))) {
                        fullNameBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1) {
                        sss = xpp.getAttributeValue(0);
                        m = p.matcher(sss);
                        if (m.find()) {
                            titleBool = true;
                        }
                        //titleBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("ul") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals("subcategories"))) {
                        titleBool = false;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("img") && xpp.getAttributeCount() == 3 && (xpp.getAttributeValue(0).equals(IMG_LINK)) && xpp.getAttributeValue(2).trim().equals(fullName)) {
                        pic = xpp.getAttributeValue(1);
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(OBJECT_MANUF))) {
                        manufacturerBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(OBJECT_PROG))) {
                        programmersBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(OBJECT_DATE))) {
                        dateBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(OBJECT_TYPE))) {
                        typeBool = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(OBJECT_BOX))) {
                        boxBool = true;
                    }
//                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(OBJECT_LANG))) {
//                        langBool = true;
//                    }
                    if (eventType == XmlPullParser.TEXT && fullNameBool) {
                        fullName = xpp.getText().trim();
                    }
                    if (eventType == XmlPullParser.TEXT && titleBool) {
                        title += xpp.getText() + "\n\r";
                    }
                    if (eventType == XmlPullParser.TEXT && manufacturerBool) {
                        manufacturer += xpp.getText();
                    }
                    if (eventType == XmlPullParser.TEXT && programmersBool) {
                        programmers += xpp.getText();
                    }
                    if (eventType == XmlPullParser.TEXT && dateBool) {
                        date += xpp.getText();
                    }
                    if (eventType == XmlPullParser.TEXT && typeBool) {
                        type += xpp.getText();
                    }
                    if (eventType == XmlPullParser.TEXT && boxBool) {
                        box += xpp.getText();
                    }
                    if (eventType == XmlPullParser.TEXT && langBool) {
                        lang += xpp.getText();
                    }
                    if (eventType == XmlPullParser.TEXT && xpp.getText().trim().equals("Описание")) {
                        descriptionBool = true;

                    }
                    if (eventType == XmlPullParser.TEXT && xpp.getText().trim().equals("Особенности")) {
                        descriptionBool = false;
                        benefitsBool = true;
                    }
                    if (eventType == XmlPullParser.TEXT && xpp.getText().trim().equals("Системные требования")) {
                        benefitsBool = false;
                        systemReqBool = true;
                    }
                    if (eventType == XmlPullParser.TEXT && xpp.getText().trim().equals("Отзывы")) {
                        systemReqBool = false;
                    }
                    if (eventType == XmlPullParser.TEXT && descriptionBool) {
                        description += xpp.getText().trim();
                    }
                    if (eventType == XmlPullParser.TEXT && benefitsBool) {
                        benefits += xpp.getText().trim();
                    }
                    if (eventType == XmlPullParser.TEXT && systemReqBool) {
                        systemReq += xpp.getText().trim();
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("h4") && (fullNameBool)) {
                        fullNameBool = false;
                    }
//                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && titleBool) {
//                        titleBool = false;
//                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && manufacturerBool) {
                        manufacturerBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && programmersBool) {
                        programmersBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && dateBool) {
                        dateBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && typeBool) {
                        typeBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && boxBool) {
                        boxBool = false;
                    }
                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("div") && langBool) {
                        langBool = false;
                    }
                    eventType = xpp.next();
                }
                System.out.println(fullName);
                System.out.println(pic);
                System.out.println(title);
                System.out.println(manufacturer);
                System.out.println(programmers);
                System.out.println(date);
                System.out.println(type);
                System.out.println(box);
                System.out.println(lang);
                System.out.println(description);
                System.out.println(benefits);
                System.out.println(systemReq);
                attributes = title + "|||" + manufacturer + "|||" + programmers + "|||" + date + "|||" + type + "|||" + lang;
                soft = new Soft();
                soft.setFullName(fullName);
                soft.setDescriptions(description.replaceAll("Описание", ""));
                soft.setPicUrl(pic);
                soft.setSystemRequirements(systemReq.replaceAll("Системные требования", ""));
                soft.setBenefits(benefits.replaceAll("Особенности", ""));
                soft.setAttributes(attributes);
                soft.setKeyArticle(Integer.parseInt(article));
//                fd.getSoftDAO().addSoft(soft);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            xml.delete();
            html.delete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            os.close();
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadContentFromPleer(String article, String url) {
        //throw new UnsupportedOperationException("Not supported yet.");
        String IMAGE_TAG = "image";
        String BLOCKT_TAG = "blockTitle2";
//        String IMG_LINK = "img_link";
//        String OBJECT_TITLE = "object_title";
//        String OBJECT_MANUF = "object_manuf";
//        String OBJECT_PROG = "object_prog";
//        String OBJECT_DATE = "object_date";
//        String OBJECT_TYPE = "object_type";
//        String OBJECT_BOX = "object_box";
//        String OBJECT_LANG = "object_lang";

        FactoryDAO fd = FactoryDAO.getInstance();
        Soft soft;
        if (url.equals("") || url == null) {
            soft = new Soft();
            soft.setKeyArticle(Integer.parseInt(article));
            soft.setFullName("Google нифига не нашел...");
            fd.getSoftDAO().addSoft(soft);
            return;
        }
        Http http = new Http();
        String htmlData = http.DownloadContentAsString(url, "WINDOWS-1251", true);

        String dst = "C://javaTemp/dst.xhtml";

        String tempFile = "C://javaTemp/temp.html";
        String sss;

        Pattern p = Pattern.compile("buymessage");

        Matcher m;

        int attrFlag = 1;

        String fullName = "",
                pic = "",
                description = "",
                attributes = "";

        boolean fullNameBool = false,
                imageTagBool = false,
                attrTagBool1 = false,
                attrTagBool2 = false,
                attrTagBool3 = false,
                bodyTagBool = false,
                tdTagBool = false,
                markBool1 = false,
                markBool2 = false,
                markTextBool = false;



        OutputStream os = null;

        XMLReader r;

        Writer w = null;

        ContentHandler h;

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            File xml = null;
            File html = new File(tempFile);
            FileUtils.writeStringToFile(html, htmlData, "UTF-8");

            try {

                os = new FileOutputStream(dst);
                r = new Parser();
                w = new OutputStreamWriter(os, "UTF-8");
                h = new XMLWriter(w);
                r.setContentHandler(h);
                r.parse(html.toURI().toString());
                xml = new File(dst);
                xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
                int eventType = xpp.getEventType();
                //до этого стандартно

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && (xpp.getAttributeValue(0).equals(IMAGE_TAG))) {
                        imageTagBool = true;
                    }

                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("a") && imageTagBool) {
                        pic = "http://pleer.ru" + xpp.getAttributeValue(1);
//                        imageTagBool = false;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("img") && imageTagBool) {
                        fullName = xpp.getAttributeValue(2);
                        imageTagBool = false;
                    }
//******************************** Поиск атрибутов на странице******************************
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && xpp.getAttributeValue(0).equals(BLOCKT_TAG)) {
                        attrTagBool1 = true;
                    }

                    if (eventType == XmlPullParser.TEXT && attrTagBool1 && xpp.getText().trim().equals("Техническое описание")) {
                        attrTagBool1 = false;
                        attrTagBool2 = true;
                    }

                    if (eventType == XmlPullParser.START_TAG && attrTagBool2 && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && xpp.getAttributeValue(0).equals("text")) {
                        attrTagBool2 = false;
                        attrTagBool3 = true;
                    }

                    if (eventType == XmlPullParser.TEXT && attrTagBool3) {
                        if (!xpp.getText().trim().equals(" ") | !xpp.getText().trim().equals(" ")) {
                            attributes += xpp.getText().trim() + ";";
                        }
                    }
                    if (eventType == XmlPullParser.END_TAG && attrTagBool3 && xpp.getName().equals("div")) {
                        attrTagBool3 = false;
                    }

//                    if (eventType == XmlPullParser.START_TAG && attrTagBool2 && xpp.getName().equals("tbody")) {
//                        bodyTagBool = true;
//                        attrTagBool2 = false;
//                    }
//
//
//                    if (eventType == XmlPullParser.START_TAG && bodyTagBool && xpp.getName().equals("td")) {
//                        tdTagBool = true;
//                    }
//
//                    if (eventType == XmlPullParser.TEXT && tdTagBool && !xpp.getText().equals(" ")) {
//                        if (attrFlag % 2 == 1) {
//                            attributes += xpp.getText().trim();
//                            attrFlag++;
//                            tdTagBool = false;
//                        } else {
//                            attributes += " - " + xpp.getText().trim() + ";";
//                            attrFlag++;
//                            tdTagBool = false;
//                        }
//                    }
//
//
//                    if (eventType == XmlPullParser.END_TAG && bodyTagBool && xpp.getName().equals("tbody")) {
//                        bodyTagBool = false;
//                    }
//*************************Поиск маркетинга на странице************************************
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && xpp.getAttributeValue(0).equals(BLOCKT_TAG)) {
                        markBool1 = true;
                    }
                    if (eventType == XmlPullParser.TEXT && markBool1 && xpp.getText().trim().equals("Полное описание")) {
                        markBool1 = false;
                        markBool2 = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && markBool2 && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && xpp.getAttributeValue(0).equals("text")) {
                        markBool2 = false;
                        markTextBool = true;
                    }
                    if (eventType == XmlPullParser.TEXT && markTextBool) {
                        markTextBool = false;
                        description = xpp.getText().trim();
                    }

                    eventType = xpp.next();
                }
                System.out.println("Fullname: " + fullName);
                System.out.println("Ссылка на изображение: " + pic);
                System.out.println("Атрибуты: " + attributes);
//            System.out.println(title);
//            System.out.println(manufacturer);
//            System.out.println(programmers);
//            System.out.println(date);
//            System.out.println(type);
//            System.out.println(box);
//            System.out.println(lang);
                System.out.println("Маркетинговое описание: " + description);
//            System.out.println(benefits);
//            System.out.println(systemReq);
//            attributes = title + "|||" + manufacturer + "|||" + programmers + "|||" + date + "|||" + type + "|||" + lang;
//            soft = new Soft();
//            soft.setFullName(fullName);
//            soft.setDescriptions(description.replaceAll("Описание", ""));
//            soft.setPicUrl(pic);
//            soft.setSystemRequirements(systemReq.replaceAll("Системные требования", ""));
//            soft.setBenefits(benefits.replaceAll("Особенности", ""));
//            soft.setAttributes(attributes);
//            soft.setKeyArticle(Integer.parseInt(article));
//                fd.getSoftDAO().addSoft(soft);
                Headphones hp = new Headphones();
                hp.setAttributes(attributes);
                hp.setDescriptions(description);
                hp.setFullName(fullName);
                hp.setKeyArticle(Integer.parseInt(article));
                hp.setPicUrl(pic);
                fd.getHeadphonesDAO().addHeadphones(hp);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            xml.delete();
            html.delete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }






        try {
            os.close();
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
