package com.pav4it.imf.infrastructure.transfer;

import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;

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

import com.pav4it.imf.BaseEntity;
import com.pav4it.imf.SubstitutesGroup;
import com.pav4it.imf.infrastructure.SimplyConverter;
import com.pav4it.imf.persistance.SubstitutesGroupRepository;

import ar.com.fdvs.bean2bean.Bean2Bean;

/**
 * @author Andrey Popov creates on 26.07.11 (18:24)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class SubstitutesGroupDtoTest {
    private final Logger logger = LoggerFactory.getLogger(SubstitutesGroupDtoTest.class);
    @Autowired
    SubstitutesGroupRepository repository;
    @Autowired
    Bean2Bean bean2Bean;
    @Autowired
    Jaxb2Marshaller jaxb2Marshaller;

    @Test
    public void test() {
        SubstitutesGroup group = (SubstitutesGroup) repository.getEntity(1l);
        bean2Bean.getTypeConverter().registerSpecializedConverterFor(BaseEntity.class, BaseEntity.class, new SimplyConverter());

        SubstitutesGroupDto dto = bean2Bean.createFrom(group, SubstitutesGroupDto.class);
        final StringWriter out = new StringWriter();
        jaxb2Marshaller.marshal(dto, new StreamResult(out));
        logger.error(out.getBuffer().toString());
    }
}
