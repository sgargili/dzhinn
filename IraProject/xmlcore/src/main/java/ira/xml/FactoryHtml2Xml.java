package ira.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: PAV
 * Date: 27.10.2010
 * Time: 1:12:47
 * To change this template use File | Settings | File Templates.
 */
public class FactoryHtml2Xml {
    private static FactoryHtml2Xml ourInstance = new FactoryHtml2Xml();
    private ClassPathXmlApplicationContext appctx = new ClassPathXmlApplicationContext("html2Xml.xml");

    public HttpData2Xpp getHttpData2Xpp() {
        return (HttpData2Xpp) appctx.getBean("httpData2Xpp");
    }

    public HttpData2Dom getHttpData2Dom() {
        return (HttpData2Dom) appctx.getBean("httpData2Dom");
    }

    public static FactoryHtml2Xml getInstance() {
        return ourInstance;
    }

    private FactoryHtml2Xml() {
    }
}
