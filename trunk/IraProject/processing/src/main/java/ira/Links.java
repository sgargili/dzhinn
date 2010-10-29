package ira;

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

            System.out.println("������� -> " + i++);

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



}
