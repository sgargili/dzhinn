package com.sitronics.filenet.imports;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.filenet.api.admin.DocumentClassDefinition;
import com.sitronics.filenet.core.model.EntityDefinition;
import com.sitronics.filenet.core.model.ExcelClassDefinition;
import com.sitronics.filenet.core.model.FieldDefinition;
import com.sitronics.filenet.core.service.ExcelService;
import com.sitronics.filenet.core.service.FileNetService;
import com.sitronics.filenet.core.service.JobService;

/**
 * @author Andrey Popov creates on 30.06.11 (13:08)
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        JobService jobService = (JobService) context.getBean("jobService");

        FileInputStream inputStream = new FileInputStream("C://Test.xlsx");

        jobService.doJob(inputStream);
    }
}
