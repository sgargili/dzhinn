package ira.processing;

import ira.dao.FactoryDao;
import ira.entity.Link;
import ira.xml.FactoryHtml2Xml;
import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: PAV
 * Date: 27.10.2010
 * Time: 23:58:50
 * To change this template use File | Settings | File Templates.
 */
public class Links {
    FactoryDao fd = FactoryDao.getInstance();
    FactoryHtml2Xml fXml = FactoryHtml2Xml.getInstance();

    public void getDepartments() {


        String url = "http://www.belygorod.ru/catalog/";

        XmlPullParser xpp = fXml.getHttpData2Xpp().getXpp(url, "Windows-1251", "Windows-1251", true);

        Pattern pat = Pattern.compile("rubric");
        Matcher match;

        Link link;

        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("a") //
                        && xpp.getAttributeCount() == 3 //
                        && xpp.getAttributeValue(0).equals("rect")//
                        && xpp.getAttributeName(1).equals("id")) {

                    match = pat.matcher(xpp.getAttributeValue(2));
                    if (match.find()) {
                        link = new Link();
                        link.setType("Department");
                        link.setUrl("http://www.belygorod.ru" + xpp.getAttributeValue(2).trim() + "?SHOWALL_8=1");
                        fd.getLinkDao().saveLink(link);
                    }
                }

                eventType = xpp.next();
            }
        } catch (Exception ex) {
        }
    }

    public void getProductLinks() {

        XmlPullParser xpp;
        Link link;
        int i = 1;

        List<Link> departments = fd.getLinkDao().getLinkByType("Department");

        for (Link department : departments) {

            System.out.println("Рубрика -> " + i++);

            xpp = fXml.getHttpData2Xpp().getXpp(department.getUrl(), "Windows-1251", "Windows-1251", true);

            try {
                int eventType = xpp.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {

                    if (eventType == XmlPullParser.START_TAG //
                            && xpp.getName().equals("a") //
                            && xpp.getAttributeCount() == 3 //
                            && xpp.getAttributeValue(0).equals("rect")//
                            && xpp.getAttributeValue(1).equals("title")//
                            && xpp.getAttributeName(1).equals("class")) {
                        link = new Link();
                        link.setType("ProductLink");
                        link.setUrl("http://www.belygorod.ru" + xpp.getAttributeValue(2).trim());
                        fd.getLinkDao().saveLink(link);
                    }

                    eventType = xpp.next();
                }
            } catch (Exception ex) {
            }
        }
    }

    public void getProductDescription() {

        XmlPullParser xpp;
        Link link;

        String fullName = "";
        String temp = "";
        String[] attribute2Value = new String[2];
        String description = "";

        boolean fullNameBool = false;
        boolean attribute2ValueBool = false;
        boolean doubleValue = false;
        boolean descriptionBool = false;


        xpp = fXml.getHttpData2Xpp().getXpp("http://www.belygorod.ru/catalog/25425/", "Windows-1251", "Windows-1251", true);

        try {
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
                    //temp += xpp.getText().trim();
                    try {

                        if (!doubleValue) {
                            attribute2Value = xpp.getText().trim().split(":");
                            if (!attribute2Value[1].trim().equals(" ")) {
                                System.out.println("Атрибут: " + attribute2Value[0].trim() + " Значение: " + attribute2Value[1].trim());
                            }
                        } else {
                            if (!attribute2Value[0].trim().equals("")) {
                                System.out.println("Атрибут: " + attribute2Value[0].trim() + " Значение: " + xpp.getText().trim());
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

                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("br")
                        && xpp.getAttributeCount() == 1
                        && xpp.getAttributeValue(0).equals("none")
                        && xpp.getAttributeName(0).equals("clear")) {
                    descriptionBool = false;
                }

                eventType = xpp.next();
            }
        } catch (Exception ex) {
            System.out.println(ex.fillInStackTrace());
        }
        //System.out.println(fullName);
        System.out.println(description);
    }

}
