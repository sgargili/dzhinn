package ira.httpclient;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: PAV
 * Date: 27.10.2010
 * Time: 0:56:29
 * To change this template use File | Settings | File Templates.
 */
public class FactoryHttpData {
    private static FactoryHttpData ourInstance = new FactoryHttpData();
    private ClassPathXmlApplicationContext appctx = new ClassPathXmlApplicationContext("httpData.xml");

    public HttpData getHttpData() {
        return (HttpData) appctx.getBean("httpData");
    }

    public static FactoryHttpData getInstance() {
        return ourInstance;
    }

    private FactoryHttpData() {
    }
}
