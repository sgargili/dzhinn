package com.pav4it.imf.persistance.impl;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.io.Files;
import com.pav4it.imf.Document;

/**
 * @author Andrey Popov creates on 20.07.11 (10:49)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class DocumentRepositoryHibernateTest {
    @Autowired
    DocumentRepositoryHibernate documentRepositoryHibernate;

    @Test
    public void testStore() throws Exception {
        byte[] bytes = Files.toByteArray(new File("C://SPP-1.0.jar"));

        Document document = new Document();
        document.setName("Some Document");
        document.setComment("Some Comment");
        document.setContent(bytes);
        documentRepositoryHibernate.store(document);
    }

//    @Test
//    public void testGetDocument() throws Exception {
//       Document document = documentRepositoryHibernate.getDocument(2l);
//        File file = new File("C://SPP-1.0.jar");
//        Files.write(document.getContent(), file);
//        System.out.println(new MimetypesFileTypeMap().getContentType(file));
//    }

//    @Test
//    public void testRemove() throws Exception {
//
//    }


}
