package com.pav4it.imf;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pav4it.imf.infrastructure.SubstitutesGroupPageService;
import com.pav4it.imf.infrastructure.transfer.page.SubstitutesGroupPage;

/**
 * @author Andrey Popov creates on 27.07.11 (13:01)
 */
@Controller
public class TestController {
    @Autowired
    SubstitutesGroupPageService service;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    @ResponseBody
    public SubstitutesGroupPage getSubstitutesGroupPage() {
        SubstitutesGroupPage page = service.getSubstituteGroupPageWithDependenciesById(1l);
        return page;
    }

    @RequestMapping(value = "/testDate", method = RequestMethod.GET)
//    @ResponseBody
    public Page getPage() {
        Page page = new Page();
        page.setDate(new Date(new java.util.Date().getTime()));
        return page;
    }

}
