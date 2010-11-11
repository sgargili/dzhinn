/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.Html2Xml;

/**
 *
 * @author Apopov
 */
public class FactoryHTML2XML {

    private ApplicationContext factory = new ClassPathXmlApplicationContext("Html2XmlSpringConfig.xml");
    private static FactoryHTML2XML instance = null;

    public static synchronized FactoryHTML2XML getInstance() {
        if (instance == null) {
            instance = new FactoryHTML2XML();
        }
        return instance;
    }

    public Html2Xml getHtml2Xml() {
        return (Html2Xml) factory.getBean("html2Xml");
    }
}
