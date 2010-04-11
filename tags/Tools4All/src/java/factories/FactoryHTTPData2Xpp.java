/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.HttpData2Xpp;

/**
 *
 * @author Apopov
 */
public class FactoryHTTPData2Xpp {

    private ApplicationContext factory = new ClassPathXmlApplicationContext("config/HttpData2XppSpringConfig.xml");
    private static FactoryHTTPData2Xpp instance = null;

    public static synchronized FactoryHTTPData2Xpp getInstance() {
        if (instance == null) {
            instance = new FactoryHTTPData2Xpp();
        }
        return instance;
    }

    public HttpData2Xpp getHttpData2Xpp() {
        return (HttpData2Xpp) factory.getBean("HttpData2Xpp");
    }
}
