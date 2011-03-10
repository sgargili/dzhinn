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
        return (attributeService.addAttribute(attributeRequest) != null);
    }

    @RequestMapping(value = "/updateAttribute", method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateAttribute(@RequestBody AttributeRequest attributeRequest) {
        attributeService.updateAttribute(attributeRequest);
        return true;
    }

    @RequestMapping(value = "/deleteAttribute", method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteAttribute(@RequestBody AttributeRequest attributeRequest) {
        attributeService.deleteAttribute(attributeRequest);
        return true;
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
        return attributeService.getAttributesByGroupId(groupId, firstResult, maxResult);
    }

    @RequestMapping(value = "/attributesByName", method = RequestMethod.GET)
    public AttributeResponse getAttributesByName(@RequestParam String attributeName,
                                                 @RequestParam Integer firstResult,
                                                 @RequestParam Integer maxResult) {
        return attributeService.getAttributesByName(attributeName, firstResult, maxResult);
    }
}
