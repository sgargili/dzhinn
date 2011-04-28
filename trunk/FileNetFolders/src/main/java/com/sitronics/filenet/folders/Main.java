package com.sitronics.filenet.folders;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        xmlService.createXml("D://Folder.xml");
        //2011-04-11T06:41:58.0Z

//       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss'.0Z'");
//           String time = simpleDateFormat.format(Calendar.getInstance().getTime());
//        System.out.println(time);
    }
}
