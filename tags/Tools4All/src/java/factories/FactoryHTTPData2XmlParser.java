/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.HttpData2Dom;
import xml.HttpData2Xpp;

/**
 *
 * @author Apopov
 */
public class FactoryHTTPData2XmlParser {

    private ApplicationContext factory = new ClassPathXmlApplicationContext("config/HttpData2XmlParsersSpringConfig.xml");
    private static FactoryHTTPData2XmlParser instance = null;

    public static synchronized FactoryHTTPData2XmlParser getInstance() {
        if (instance == null) {
            instance = new FactoryHTTPData2XmlParser();
        }
        return instance;
    }

    public HttpData2Xpp getHttpData2Xpp() {
        return (HttpData2Xpp) factory.getBean("HttpData2Xpp");
    }

    public HttpData2Dom getHttpData2Dom() {
        return (HttpData2Dom) factory.getBean("HttpData2Dom");
    }
}
