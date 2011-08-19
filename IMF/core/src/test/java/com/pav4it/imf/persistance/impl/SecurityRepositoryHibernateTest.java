package com.pav4it.imf.persistance.impl;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pav4it.imf.Security;
import com.pav4it.imf.persistance.SecurityRepository;

/**
 * @author Andrey Popov creates on 28.07.11 (15:30)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class SecurityRepositoryHibernateTest {
    @Autowired
    private SecurityRepository securityRepository;

    @Test
    public void testStore() throws Exception {
        Security security = new Security();
        security.setName("Andrey Popov");
        security.setComment("Some comment");
        security.setUuid(UUID.randomUUID());
        securityRepository.store(security);
        System.out.println("security.getId() = " + security.getId());
    }

    @Test public void testGet(){
        Security security = (Security) securityRepository.getEntity(1l);
        System.out.println(security.getUuid());
    }
}
