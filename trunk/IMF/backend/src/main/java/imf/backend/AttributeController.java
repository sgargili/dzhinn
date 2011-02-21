package imf.backend;

import imf.core.dto.web.response.AttributeResponse;
import imf.core.dto.web.response.TreeResponse;
import imf.core.dto.web.response.UnitsGroupResponse;
import imf.core.service.AttributeService;
import imf.core.service.SubsGroupService;
import imf.core.service.UnitsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Developed by: Andrey Popov
 * Date (time): 21.02.11 (12:53)
 */
@Controller
public class AttributeController {
    @Qualifier("attributeService")
    @Autowired
    private AttributeService attributeService;

    @RequestMapping(value = "/attributes", method = RequestMethod.GET)
    public AttributeResponse getAllUnitGroups(@RequestParam Long groupId) {
        AttributeResponse response = attributeService.getAttributesByGroupId(groupId);
        return response;
    }
}
