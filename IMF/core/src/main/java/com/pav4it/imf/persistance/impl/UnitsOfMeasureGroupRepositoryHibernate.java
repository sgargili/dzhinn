package com.pav4it.imf.persistance.impl;

import org.springframework.stereotype.Repository;

import com.pav4it.imf.UnitsOfMeasureGroup;
import com.pav4it.imf.persistance.UnitsOfMeasureGroupRepository;

/**
 * @author Andrey Popov creates on 19.07.11 (18:18)
 */
@Repository("UnitsOfMeasureGroupRepository")
public class UnitsOfMeasureGroupRepositoryHibernate extends BaseRepositoryHibernate<UnitsOfMeasureGroup> implements UnitsOfMeasureGroupRepository {

}
