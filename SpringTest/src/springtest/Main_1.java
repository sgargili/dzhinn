/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author APopov
 */
public class Main_1 {

    public static void main(String[] args) {

        Resource config = new ClassPathResource("springtest/SpringSettings.xml");
        BeanFactory factory = new XmlBeanFactory(config);
        Message bean = (Message) factory.getBean("sayHello");
        System.out.println(bean.sayHello());
    }
}
