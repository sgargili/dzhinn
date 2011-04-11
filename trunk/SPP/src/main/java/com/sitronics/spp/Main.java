package com.sitronics.spp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.sitronics.spp.service.MarshallerService;

/**
 * @author Andrey Popov creates on 11.04.11 (15:25)
 */
public class Main {
    private static Jaxb2Marshaller marshaller;
    private static MarshallerService service;
    private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spp-config.xml");

    public static void main(String[] args) throws IOException {
////        marshaller = (Jaxb2Marshaller) context.getBean("marshaller");
//        service  = (MarshallerService) context.getBean("marshallerService");
//        Pojo pojo = new Pojo("id1", "name1");
//        System.out.println(service.marshal(pojo));
        List<File> files = (List<File>) FileUtils.listFiles(new File("C://test"), TrueFileFilter.TRUE, TrueFileFilter.TRUE);
        int i = 0;
        for (File file : files) {
            FileUtils.copyFile(file, new File(FilenameUtils.concat(file.getParentFile().getPath(), i++ +"/"+file.getName())));
//            System.out.println(file.getName());
//            System.out.println(FilenameUtils.concat("C://test/test/text.xml", "dddddd"));

        }

    }
}
