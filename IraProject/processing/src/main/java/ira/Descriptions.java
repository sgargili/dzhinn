package ira;

import ira.dao.FactoryDao;
import ira.entity.Data;
import ira.entity.Link;
import ira.httpclient.FactoryHttpData;
import ira.xml.FactoryHtml2Xml;
import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: PAV
 * Date: 28.10.2010
 * Time: 22:07:06
 * To change this template use File | Settings | File Templates.
 */
public class Descriptions {
    private FactoryDao fd = FactoryDao.getInstance();
    private FactoryHtml2Xml fXml = FactoryHtml2Xml.getInstance();
    private FactoryHttpData http = FactoryHttpData.getInstance();

    public void getProductDescription() {

        XmlPullParser xpp;
        Data data;
        List<Data> datas = new ArrayList();
        List<Link> links = fd.getLinkDao().getLinkByType("ProductLink");

        String fullName = "";
        String temp = "";
        String[] attribute2Value = new String[2];
        String description = "";
        String article = "";
        String fullDescriptionUrl = "";

        boolean fullNameBool = false;
        boolean attribute2ValueBool = false;
        boolean doubleValue = false;
        boolean descriptionBool = false;

        Pattern pat = Pattern.compile("/preface/");
        Matcher match;

        int cicle = 1;
        int count = links.size();

        for (Link link : links) {
            if (cicle++ <= 644) {
                continue;
            }
            try {
                xpp = fXml.getHttpData2Xpp().getXpp(link.getUrl(), "Windows-1251", "UTF-8", true);

                int eventType = xpp.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {

                    if (eventType == XmlPullParser.START_TAG //
                            && xpp.getName().equals("h1") //
                            && xpp.getAttributeCount() == 1 //
                            && xpp.getAttributeValue(0).equals("title")
                            && xpp.getAttributeName(0).equals("class")) {
                        fullNameBool = true;
                    }

                    if (eventType == XmlPullParser.TEXT && fullNameBool) {
                        fullName = xpp.getText().trim();
                    }

                    if (eventType == XmlPullParser.END_TAG && fullNameBool) {
                        fullNameBool = false;
                    }

                    if (eventType == XmlPullParser.START_TAG //
                            && xpp.getName().equals("td") //
                            && xpp.getAttributeCount() == 5 //
                            && xpp.getAttributeValue(3).equals("desc")
                            && xpp.getAttributeName(3).equals("class")) {
                        attribute2ValueBool = true;
                    }

                    if (eventType == XmlPullParser.START_TAG //
                            && (xpp.getName().equals("a") || xpp.getName().equals("span")) //
                            && attribute2ValueBool) {
                        doubleValue = true;
                    }

                    if (eventType == XmlPullParser.TEXT && attribute2ValueBool) {
                        try {

                            if (!doubleValue) {
                                attribute2Value = xpp.getText().trim().split(":");
                                if (!attribute2Value[1].trim().equals(" ")) {
                                    data = new Data();
                                    data.setAttribute(attribute2Value[0].trim().replaceAll(" ", ""));
                                    data.setValue(attribute2Value[1].trim().replaceAll(" ", ""));
                                    datas.add(data);
                                    if (attribute2Value[0].trim().equals("Артикул")) {
                                        article = attribute2Value[1].trim().replaceAll(" ", "");
                                    }
                                }
                            } else {
                                if (!attribute2Value[0].trim().equals("")) {
                                    data = new Data();
                                    data.setAttribute(attribute2Value[0].trim().replaceAll(" ", ""));
                                    data.setValue(xpp.getText().trim().replaceAll(" ", ""));
                                    datas.add(data);
                                }
                            }
                        } catch (Exception ex) {

                        }
                    }
                    if (eventType == XmlPullParser.END_TAG //
                            && (xpp.getName().equals("a") || xpp.getName().equals("span")) //
                            && attribute2ValueBool) {
                        doubleValue = false;
                    }

                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && attribute2ValueBool) {
                        attribute2ValueBool = false;
                    }

                    if (eventType == XmlPullParser.TEXT
                            && xpp.getText().trim().equals("Описание книги")) {
                        descriptionBool = true;
                    }
                    if (eventType == XmlPullParser.TEXT && descriptionBool) {
                        description = xpp.getText().trim();
                    }

                    if (eventType == XmlPullParser.START_TAG) {
                        descriptionBool = false;
                    }

                    if (eventType == XmlPullParser.START_TAG //
                            && xpp.getName().equals("a") //
                            && xpp.getAttributeCount() == 2 //
                            && xpp.getAttributeValue(0).equals("rect")
                            && xpp.getAttributeName(0).equals("shape")
                            && xpp.getAttributeName(1).equals("href")) {
                        match = pat.matcher(xpp.getAttributeValue(1));
                        if (match.find()) {
                            getFullDescription("http://www.belygorod.ru" + xpp.getAttributeValue(1), article);
                        }
                    }

                    eventType = xpp.next();
                }
            } catch (Exception ex) {
                System.out.println(ex.fillInStackTrace());
            }

            data = new Data();
            data.setAttribute("Описание книги");
            data.setValue(description);
            datas.add(data);
            int i = 0;
            for (Data dataNew : datas) {
                dataNew.setArticle(article);
                fd.getDataDao().saveData(dataNew);
            }
            System.out.println(cicle + " из " + count + " - Получили данные для артикля: " + article);
            datas.clear();
        }
    }

    private void getFullDescription(String url, String article) {
        XmlPullParser xpp;

        String fullDescription = "";

        boolean isAssept = false;

        try {
            xpp = fXml.getHttpData2Xpp().getXpp(url, "Windows-1251", "UTF-8", true);
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("h1") //
                        && xpp.getAttributeCount() == 1 //
                        && xpp.getAttributeValue(0).equals("center")
                        && xpp.getAttributeName(0).equals("align")) {
                    isAssept = true;
                }

                if (eventType == XmlPullParser.TEXT && isAssept) {
                    fullDescription += xpp.getText().trim() + "|||";
                }

                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("script") //
                        && xpp.getAttributeCount() == 1 //
                        && xpp.getAttributeValue(0).equals("text/javascript")
                        && xpp.getAttributeName(0).equals("type")) {
                    isAssept = false;
                }
                eventType = xpp.next();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        //System.out.println(fullDescription);
        Data data = new Data();
        data.setArticle(article);
        data.setAttribute("Полное описание");
        data.setValue(fullDescription);
        fd.getDataDao().saveData(data);
    }

}
