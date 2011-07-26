package com.pav4it.imf.persistance.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pav4it.imf.UnitOfMeasure;
import com.pav4it.imf.UnitsOfMeasureGroup;
import com.pav4it.imf.persistance.UnitsOfMeasureGroupRepository;

/**
 * @author Andrey Popov creates on 19.07.11 (18:21)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
//@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
//@Transactional
public class UnitsOfMeasureGroupRepositoryHibernateTest {
    private final Logger logger = LoggerFactory.getLogger(UnitsOfMeasureGroupRepositoryHibernateTest.class);

    @Autowired
    UnitsOfMeasureGroupRepository unitsOfMeasureGroupRepository;

    @Test
    public void testStore() throws Exception {
        UnitsOfMeasureGroup unitsOfMeasureGroup = new UnitsOfMeasureGroup();

        UnitOfMeasure unitOfMeasure1 = new UnitOfMeasure();
        unitOfMeasure1.setName("Megabyte per second");
        unitOfMeasure1.setPrefix("MB/s");
        unitOfMeasure1.setRatio(1000f);
        unitOfMeasure1.setGroupDefault(false);
        unitOfMeasure1.setComment("Megabyte per second Comment");
//        unitOfMeasure1.setId(1l);
         unitOfMeasure1.setUnitsOfMeasureGroup(unitsOfMeasureGroup);
        logger.info("Create Unit of Measure with name: {}", unitOfMeasure1.getName());
        unitsOfMeasureGroup.addUnitOfMeasure(unitOfMeasure1);


        UnitOfMeasure unitOfMeasure2 = new UnitOfMeasure();
        unitOfMeasure2.setName("Kilobyte per second");
        unitOfMeasure2.setPrefix("KB/s");
        unitOfMeasure2.setRatio(1f);
        unitOfMeasure2.setGroupDefault(true);
        unitOfMeasure2.setComment("Kilobyte per second Comment");
//        unitOfMeasure2.setId(2l);


        unitsOfMeasureGroup.addUnitOfMeasure(unitOfMeasure2);
        unitsOfMeasureGroup.setComment("Group Comment");
        unitsOfMeasureGroup.setName("Group");

        unitsOfMeasureGroupRepository.store(unitsOfMeasureGroup);

    }
//
//    @Test
//    public void testGetUnitsOfMeasureGroup() throws Exception {
//        System.out.println(((UnitsOfMeasureGroup)unitsOfMeasureGroupRepository.getEntity(1l)).getName());
//    }
//
//    @Test
//    public void testRemove() throws Exception {
//
//    }
}
