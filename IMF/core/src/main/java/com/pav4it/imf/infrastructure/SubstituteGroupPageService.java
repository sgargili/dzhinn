package com.pav4it.imf.infrastructure;

import org.springframework.transaction.annotation.Transactional;

import com.pav4it.imf.infrastructure.page.SubstituteGroupPage;

/**
 * @author Andrey Popov creates on 25.07.11 (16:02)
 */
@Transactional(readOnly = true, rollbackFor = Exception.class)
public interface SubstituteGroupPageService {
    SubstituteGroupPage getSubstituteGroupPage(int firstResult, int maxResult);

    SubstituteGroupPage getSubstituteGroupPageByName(String name, int firstResult, int maxResult);
}
