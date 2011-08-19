package com.pav4it.imf.persistance.impl;

import org.springframework.stereotype.Repository;

import com.pav4it.imf.Security;
import com.pav4it.imf.persistance.SecurityRepository;

/**
 * @author Andrey Popov creates on 28.07.11 (15:29)
 */
@Repository("securityRepository")
public class SecurityRepositoryHibernate extends BaseRepositoryHibernate<Security> implements SecurityRepository {
}