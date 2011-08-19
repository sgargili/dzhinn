package com.pav4it.imf.infrastructure.impl;

import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.pav4it.imf.infrastructure.SubstitutesGroupPageService;
import com.pav4it.imf.infrastructure.transfer.page.SubstitutesGroupPage;


/**
 * @author Andrey Popov creates on 25.07.11 (17:19)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class SubstituteGroupPageServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(SubstituteGroupPageServiceImplTest.class);
    @Autowired
    SubstitutesGroupPageService service;

    @Autowired
    Jaxb2Marshaller jaxb2Marshaller;

    @Test
    public void testGetSubstituteGroupPage() throws Exception {
        SubstitutesGroupPage group = service.getSubstituteGroupPage(0, 10);
//        final StringWriter out = new StringWriter();
//        jaxb2Marshaller.marshal(group, new StreamResult(out));
        ObjectMapper mapper = new ObjectMapper();
        logger.error(mapper.writeValueAsString(group));
    }

    @Test
    public void testGetSubstituteGroupPageByName() throws Exception {

    }

    @Test
    public void testGetSubstituteGroupPageWithDependenciesById() throws Exception {
        SubstitutesGroupPage group = service.getSubstituteGroupPageWithDependenciesById(1l);
        final StringWriter out = new StringWriter();
        jaxb2Marshaller.marshal(group, new StreamResult(out));
        logger.error(out.getBuffer().toString());
//        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
//        mapper.writeValueAsString(group);
//        System.out.println("Hello!");
//        logger.error(mapper.writeValueAsString(group));
    }
}
