package com.pav4it.imf.persistance.impl;

import org.springframework.stereotype.Repository;

import com.pav4it.imf.SubstitutesGroup;
import com.pav4it.imf.persistance.SubstitutesGroupRepository;

/**
 * @author Andrey Popov creates on 25.07.11 (11:49)
 */
@Repository("substitutesGroupRepository")
public class SubstitutesGroupRepositoryHibernate extends BaseRepositoryHibernate<SubstitutesGroup> implements SubstitutesGroupRepository {
}