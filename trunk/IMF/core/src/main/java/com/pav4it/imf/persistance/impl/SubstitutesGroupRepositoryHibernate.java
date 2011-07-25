package com.pav4it.imf.persistance.impl;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pav4it.imf.SubstitutesGroup;
import com.pav4it.imf.persistance.SubstitutesGroupRepository;

/**
 * @author Andrey Popov creates on 25.07.11 (11:49)
 */
@Repository("substitutesGroupRepository")
public class SubstitutesGroupRepositoryHibernate extends BaseRepositoryHibernate<SubstitutesGroup> implements SubstitutesGroupRepository {
    @Override
    public Object getEntityWithDependencies(Long id) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(getClazz());
        criteria.add(Restrictions.eq("id", id));
        criteria.setFetchMode("substitutes", FetchMode.JOIN);
        return criteria.uniqueResult();
    }
}