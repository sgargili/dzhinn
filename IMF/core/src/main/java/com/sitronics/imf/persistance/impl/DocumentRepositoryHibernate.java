package com.sitronics.imf.persistance.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sitronics.imf.Document;
import com.sitronics.imf.persistance.DocumentRepository;

/**
 * @author Andrey Popov creates on 20.07.11 (10:47)
 */
@Repository("DocumentRepository")
public class DocumentRepositoryHibernate implements DocumentRepository {
    @Autowired
    HibernateTemplate hibernateTemplate;

    public void store(Document document) {
        hibernateTemplate.saveOrUpdate(document);
    }

    public Document getDocument(Long id) {
        return hibernateTemplate.get(Document.class, id);
    }

    public void remove(Document document) {
        hibernateTemplate.delete(document);
    }
}
