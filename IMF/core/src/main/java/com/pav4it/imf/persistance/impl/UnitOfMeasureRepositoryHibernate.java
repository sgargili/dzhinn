package com.pav4it.imf.persistance.impl;

import org.springframework.stereotype.Repository;

import com.pav4it.imf.UnitOfMeasure;
import com.pav4it.imf.persistance.UnitOfMeasureRepository;

/**
 * @author Andrey Popov creates on 20.07.11 (17:30)
 */
@Repository("UnitOfMeasureRepository")
public class UnitOfMeasureRepositoryHibernate extends BaseRepositoryHibernate<UnitOfMeasure> implements UnitOfMeasureRepository {

}
