package com.sitronics.imf.persistance.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sitronics.imf.UnitsOfMeasureGroup;
import com.sitronics.imf.persistance.UnitsOfMeasureGroupRepository;

/**
 * @author Andrey Popov creates on 19.07.11 (18:18)
 */
@Repository("UnitsOfMeasureGroupRepository")
public class UnitsOfMeasureGroupRepositoryHibernate implements UnitsOfMeasureGroupRepository {
    @Autowired
    HibernateTemplate hibernateTemplate;

    public void store(UnitsOfMeasureGroup unitsOfMeasureGroup) {
        hibernateTemplate.saveOrUpdate(unitsOfMeasureGroup);
    }

    public UnitsOfMeasureGroup getUnitsOfMeasureGroup(Long id) {
        return hibernateTemplate.get(UnitsOfMeasureGroup.class, id);
    }

    public void remove(UnitsOfMeasureGroup unitsOfMeasureGroup) {
        hibernateTemplate.delete(unitsOfMeasureGroup);
    }
}
