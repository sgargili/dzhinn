package com.sitronics.imf.persistance.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sitronics.imf.persistance.UnitOfMeasureRepository;

/**
 * @author Andrey Popov creates on 20.07.11 (17:32)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class UnitOfMeasureRepositoryHibernateTest {
    private final Logger logger = LoggerFactory.getLogger(UnitOfMeasureRepositoryHibernateTest.class);

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    public void testStore() throws Exception {
        unitOfMeasureRepository.store(new String("ddd"));
    }
}
