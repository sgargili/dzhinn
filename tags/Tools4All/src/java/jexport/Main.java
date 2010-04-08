/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jexport;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author APopov
 */
public class Main {

    public static void main(String[] args) {

        Resource config = new ClassPathResource("jexport/SpringSettings.xml");
        BeanFactory factory = new XmlBeanFactory(config);
        Message bean = (Message) factory.getBean("sayHello");
        System.out.println(bean.sayHello());
    }
}
