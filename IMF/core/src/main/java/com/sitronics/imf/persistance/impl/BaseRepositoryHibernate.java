package com.sitronics.imf.persistance.impl;

import java.lang.reflect.ParameterizedType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sitronics.imf.persistance.BaseRepository;

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
        logger.debug("Store Entity Instance: {}", getClass());
        hibernateTemplate.saveOrUpdate(object);
    }

    @Override
    public Object getEntity(Long id) {
        logger.debug("Get Entity Instance: {} with id: {}", getClass(), id);
        return hibernateTemplate.get(getClazz(), id);
    }

    @Override
    public void remove(Object object) {
        logger.debug("Remove Entity Instance: {}", getClass());
        hibernateTemplate.delete(object);
    }
}
