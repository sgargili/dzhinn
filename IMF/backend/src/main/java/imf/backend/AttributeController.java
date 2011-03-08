package imf.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import imf.core.dto.web.request.AttributeRequest;
import imf.core.dto.web.response.AttributeResponse;
import imf.core.service.AttributeService;

/**
 * Developed by: Andrey Popov Date (time): 21.02.11 (12:53)
 */
@Controller
public class AttributeController {
    @Qualifier("attributeService")
    @Autowired
    private AttributeService attributeService;

    @RequestMapping(value = "/addAttribute", method = RequestMethod.POST)
    @ResponseBody
    public Boolean addAttribute(@RequestBody AttributeRequest attributeRequest) {
        if (attributeService.addAttribute(attributeRequest) != null) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "/isAttributePresent", method = RequestMethod.GET)
    @ResponseBody
    public Boolean isAttributePresent(@RequestParam String attributeName) {
        return attributeService.isAttributePresentByName(attributeName);
    }

    @RequestMapping(value = "/attributesByGroup", method = RequestMethod.GET)
    public AttributeResponse getAttributesByGroup(@RequestParam Long groupId,
                                                  @RequestParam Integer firstResult,
                                                  @RequestParam Integer maxResult) {
        AttributeResponse response = attributeService.getAttributesByGroupId(groupId, firstResult, maxResult);
        return response;
    }

    @RequestMapping(value = "/attributesByName", method = RequestMethod.GET)
    public AttributeResponse getAttributesByName(@RequestParam String attributeName,
                                                 @RequestParam Integer firstResult,
                                                 @RequestParam Integer maxResult) {
        AttributeResponse response = attributeService.getAttributesByName(attributeName, firstResult, maxResult);
        return response;
    }
}
