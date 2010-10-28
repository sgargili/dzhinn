package ira;

import ira.httpclient.FactoryHttpData;
import ira.xml.FactoryHtml2Xml;


/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 28.10.2010
 * Time: 16:07:12
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        FactoryHtml2Xml xml = FactoryHtml2Xml.getInstance();
        xml.getHttpData2Xpp().getXpp("http://localhost:8080");
    }
}
