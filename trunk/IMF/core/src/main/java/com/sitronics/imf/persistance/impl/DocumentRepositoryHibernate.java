package com.sitronics.imf.persistance.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sitronics.imf.Document;
import com.sitronics.imf.persistance.DocumentRepository;

/**
 * @author Andrey Popov creates on 20.07.11 (10:47)
 */
@Repository("DocumentRepository")
public class DocumentRepositoryHibernate extends BaseRepositoryHibernate<Document> implements DocumentRepository {
}
