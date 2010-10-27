package ira;

import ira.dao.FactoryDao;
import ira.httpclient.FactoryHttpData;
import ira.processing.Links;
import ira.xml.FactoryHtml2Xml;
import org.xmlpull.v1.XmlPullParser;


/**
 * Created by IntelliJ IDEA.
 * User: PAV
 * Date: 26.10.2010
 * Time: 22:32:35
 * To change this template use File | Settings | File Templates.
 */
public class Main {


    public static void main(final String[] args) throws Exception {

        Links links = new Links();
        links.getProductDescription();
//        FactoryHtml2Xml fXml = FactoryHtml2Xml.getInstance();
//        fXml.getHttpData2Xpp().getXpp("http://www.belygorod.ru/catalog/25425/", "Windows-1251", "Windows-1251", true);
    }
}
