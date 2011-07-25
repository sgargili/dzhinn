package com.pav4it.imf.persistance.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pav4it.imf.Substitute;
import com.pav4it.imf.SubstitutesGroup;
import com.pav4it.imf.persistance.SubstituteRepository;

/**
 * @author Администратор creates on 23.07.11 (1:53)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class SubstituteRepositoryHibernateTest {
    private final Logger logger = LoggerFactory.getLogger(SubstituteRepositoryHibernateTest.class);

    @Autowired
    private SubstituteRepository substituteRepository;

    @Test
    public void testStore() throws Exception {
        SubstitutesGroup group = new SubstitutesGroup();
        group.setId(1l);

        Substitute<Double> substitute = new Substitute<Double>();
        substitute.setOrderIndex(0l);
        substitute.setRealValue(0l);
        substitute.setName("ChoiceList0 Value");
        substitute.setComment("ChoiceList0 Value Comment");
        substitute.setValue(0.1d);
        substitute.setSubstitutesGroup(group);
        substituteRepository.store(substitute);
        substitute = new Substitute<Double>();
        substitute.setOrderIndex(1l);
        substitute.setRealValue(1l);
        substitute.setName("ChoiceList1 Value");
        substitute.setComment("ChoiceList1 Value Comment");
        substitute.setValue(1.1d);
        substitute.setSubstitutesGroup(group);
        substituteRepository.store(substitute);
        substitute = new Substitute<Double>();
        substitute.setOrderIndex(2l);
        substitute.setRealValue(2l);
        substitute.setName("ChoiceList2 Value");
        substitute.setComment("ChoiceList2 Value Comment");
        substitute.setValue(2.1d);
        substitute.setSubstitutesGroup(group);
        substituteRepository.store(substitute);
    }

//    @Test
//    @SuppressWarnings("unchecked")
//    public void testGetEntity() throws Exception {
//        Substitute<Boolean> substitute = (Substitute<Boolean>) substituteRepository.getEntity(4l);
//        System.out.println(substitute.getValue());
//    }
}
