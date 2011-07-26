package com.pav4it.imf.persistance.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pav4it.imf.SubstitutesGroup;
import com.pav4it.imf.UnitsOfMeasureGroup;
import com.pav4it.imf.ValueType;
import com.pav4it.imf.persistance.SubstitutesGroupRepository;

/**
 * @author Andrey Popov creates on 25.07.11 (11:51)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class SubstitutesGroupRepositoryHibernateTest {
    private final Logger logger = LoggerFactory.getLogger(SubstitutesGroupRepositoryHibernateTest.class);

    @Autowired
    SubstitutesGroupRepository repository;
    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;

    @Autowired


    @Test
    public void testStore() throws Exception {
        UnitsOfMeasureGroup unitsOfMeasureGroup = new UnitsOfMeasureGroup();
        unitsOfMeasureGroup.setId(1l);
        SubstitutesGroup group = new SubstitutesGroup();
        group.setName("Группа Автозамен 0");
        group.setComment("Группа Автозамен 0 Комментарий");
        group.setUnitsOfMeasureGroup(unitsOfMeasureGroup);
        group.setValueType(ValueType.Decimal);
        repository.store(group);
    }

//    @Test
//    public void testGetEntity() throws Exception {
//        SubstitutesGroup group = (SubstitutesGroup) repository.getEntity(1l);
//        final StringWriter out = new StringWriter();
//        jaxb2Marshaller.marshal(group, new StreamResult(out));
//        logger.error(out.getBuffer().toString());
//    }
}
