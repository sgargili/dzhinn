package com.sitronics.filenet.folders;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sitronics.filenet.folders.sevice.XmlService;

/**
 * @author Andrey Popov creates on 27.04.11 (18:33)
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring4Folders.xml");
        XmlService xmlService = (XmlService) context.getBean("xmlService");
        xmlService.createXml("");
    }
}
