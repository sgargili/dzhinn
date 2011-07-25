package com.pav4it.imf.infrastructure.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pav4it.imf.infrastructure.SubstituteGroupPageService;
import com.pav4it.imf.infrastructure.page.SubstituteGroupPage;
import com.pav4it.imf.persistance.SubstituteRepository;
import com.pav4it.imf.persistance.SubstitutesGroupRepository;

/**
 * @author Andrey Popov creates on 25.07.11 (16:15)
 */
public class SubstituteGroupPageServiceImpl implements SubstituteGroupPageService {
    private final Logger logger = LoggerFactory.getLogger(SubstituteGroupPageServiceImpl.class);

    @Autowired
    SubstitutesGroupRepository substitutesGroupRepository;

    @Autowired
    SubstituteRepository substituteRepository;

    @Override
    public SubstituteGroupPage getSubstituteGroupPage(int firstResult, int maxResult) {
        return null;
    }

    @Override
    public SubstituteGroupPage getSubstituteGroupPageByName(String name, int firstResult, int maxResult) {
        return null;
    }
}
