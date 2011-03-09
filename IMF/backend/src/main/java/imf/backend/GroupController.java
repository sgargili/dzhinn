package imf.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import imf.core.dao.GroupDao;
import imf.core.dto.web.response.AttributeResponse;
import imf.core.dto.web.response.GroupResponse;
import imf.core.service.GroupService;

/**
 * Developed by: Andrey Popov
 * Date (time): 09.03.11 (18:35)
 */

@Controller
public class GroupController {
    @Qualifier("groupService")
    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public GroupResponse getAttributesByName(/*@RequestParam String attributeName,
                                                 @RequestParam Integer firstResult,
                                                 @RequestParam Integer maxResult*/) {
        return groupService.getAllGroupsWithAttributes();
    }
}
