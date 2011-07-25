package com.pav4it.imf.infrastructure;

import org.springframework.transaction.annotation.Transactional;

import com.pav4it.imf.infrastructure.page.SubstitutesGroupPage;

/**
 * @author Andrey Popov creates on 25.07.11 (16:02)
 */
@Transactional(readOnly = true, rollbackFor = Exception.class)
public interface SubstitutesGroupPageService {
    SubstitutesGroupPage getSubstituteGroupPage(int firstResult, int maxResult);

    SubstitutesGroupPage getSubstituteGroupPageByName(String name, int firstResult, int maxResult);

    SubstitutesGroupPage getSubstituteGroupPageWithDependenciesById(Long id);
}
