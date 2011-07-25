package com.pav4it.imf.persistance.impl;

import org.springframework.stereotype.Repository;

import com.pav4it.imf.Substitute;
import com.pav4it.imf.persistance.SubstituteRepository;

/**
 * @author Администратор creates on 23.07.11 (1:52)
 */
@Repository("substituteRepository")
public class SubstituteRepositoryHibernate extends BaseRepositoryHibernate<Substitute> implements SubstituteRepository {
}