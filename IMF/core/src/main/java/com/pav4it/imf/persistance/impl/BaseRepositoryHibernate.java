package com.pav4it.imf.persistance.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.pav4it.imf.persistance.BaseRepository;

/**
 * @author Andrey Popov creates on 20.07.11 (18:37)
 */
public class BaseRepositoryHibernate<T> implements BaseRepository {
    private final Logger logger = LoggerFactory.getLogger(BaseRepositoryHibernate.class);

    @Autowired
    protected HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    protected Class<Object> getClazz() {
        return (Class<Object>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void store(Object object) {
        logger.error("Store Entity Instance: {}", getClazz().getName());
        hibernateTemplate.saveOrUpdate(object);
    }

    @Override
    public Object getEntity(Long id) {
        logger.error("Get Entity Instance: {} with id: {}", getClazz().getSimpleName(), id);
        return hibernateTemplate.get(getClazz(), id);
    }

    @Override
    public List getAllEntities(int firstResult, int maxResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(getClazz());
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResult);
        return criteria.list();
    }

    @Override
    public List getAllEntitiesByName(String name, int firstResult, int maxResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(getClazz());
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResult);
        criteria.add(Restrictions.ilike("name", name));
        return criteria.list();
    }

    @Override
    public void remove(Object object) {
        logger.error("Remove Entity Instance: {}", getClazz().getName());
        hibernateTemplate.delete(object);
    }
}
