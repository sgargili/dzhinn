package com.pav4it.imf.persistance.impl;

import org.springframework.stereotype.Repository;

import com.pav4it.imf.Document;
import com.pav4it.imf.persistance.DocumentRepository;

/**
 * @author Andrey Popov creates on 20.07.11 (10:47)
 */
@Repository("DocumentRepository")
public class DocumentRepositoryHibernate extends BaseRepositoryHibernate<Document> implements DocumentRepository {
}
