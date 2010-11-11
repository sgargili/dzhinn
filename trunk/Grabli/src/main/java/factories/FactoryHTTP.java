/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import httpclient.HttpData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Apopov
 */
public class FactoryHTTP {

    private ApplicationContext factory = new ClassPathXmlApplicationContext("HttpSpringConfig.xml");
    private static FactoryHTTP instance = null;

    public static synchronized FactoryHTTP getInstance() {
        if (instance == null) {
            instance = new FactoryHTTP();
        }
        return instance;
    }

    public HttpData getHttpData() {
        return (HttpData) factory.getBean("httpData");
    }
}
