package com.sitronics.filenet.classes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sitronics.filenet.classes.service.XmlService;

/**
 * @author Andrey Popov creates on 28.04.11 (17:40)
 */
public class ClassesMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring4Classes.xml");
        XmlService xmlService = (XmlService) context.getBean("xmlService");
        xmlService.createXml("D://Classes.xml");
    }
}
