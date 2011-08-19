package com.pav4it.imf.infrastructure.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pav4it.imf.SubstitutesGroup;
import com.pav4it.imf.infrastructure.SubstitutesGroupPageService;
import com.pav4it.imf.infrastructure.transfer.page.SubstitutesGroupPage;
import com.pav4it.imf.persistance.SubstituteRepository;
import com.pav4it.imf.persistance.SubstitutesGroupRepository;

/**
 * @author Andrey Popov creates on 25.07.11 (16:15)
 */
@Service(value = "substitutesGroupPageService")
public class SubstitutesGroupPageServiceImpl implements SubstitutesGroupPageService {
    private final Logger logger = LoggerFactory.getLogger(SubstitutesGroupPageServiceImpl.class);

    @Autowired
    SubstitutesGroupRepository substitutesGroupRepository;

    @Autowired
    SubstituteRepository substituteRepository;

    @Override
    @SuppressWarnings("unchecked")
    public SubstitutesGroupPage getSubstituteGroupPage(int firstResult, int maxResult) {
        SubstitutesGroupPage page = new SubstitutesGroupPage();
        page.setSubstitutesGroups((List) substitutesGroupRepository.getAllEntities(firstResult, maxResult));
        return page;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SubstitutesGroupPage getSubstituteGroupPageByName(String name, int firstResult, int maxResult) {
        SubstitutesGroupPage page = new SubstitutesGroupPage();
        page.setSubstitutesGroups((List) substitutesGroupRepository.getAllEntitiesByName(name, firstResult, maxResult));
        return page;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SubstitutesGroupPage getSubstituteGroupPageWithDependenciesById(Long id) {
        SubstitutesGroupPage page = new SubstitutesGroupPage();
        page.addSubstitutesGroup((SubstitutesGroup) substitutesGroupRepository.getEntityWithDependencies(id));
//        for (SubstitutesGroup group : page.getSubstitutesGroups()) {
//            group.getUnitsOfMeasureGroup().setUnitsOfMeasure(null);
//            for (Substitute substitute : group.getSubstitutes()) {
//                substitute.setSubstitutesGroup(null);
//            }
//        }
        return page;
    }
}
