package imf.backend;

import imf.core.dto.UnitsGroupDto;
import imf.core.dto.web.request.UnitsGroupAddRequest;
import imf.core.dto.web.response.UnitsGroupResponse;
import imf.core.dto.web.response.UnitsGroupTreeResponse;
import imf.core.dto.web.response.UnitsOfMeasureResponse;
import imf.core.service.UnitsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 17:14:59
 */
@Controller
public class UnitsGroupController {

    @Autowired
    private UnitsGroupService unitsGroupService;

    @RequestMapping(value = "/unitsGroup", method = RequestMethod.GET)
    public UnitsGroupResponse getAllUnitGroups(@RequestParam int firstResult,
                                               @RequestParam int maxResult) {
        return unitsGroupService.getUnitsGroupResponse(firstResult, maxResult);
    }

    @RequestMapping(value = "/addUnitsGroup", method = RequestMethod.POST)
    @ResponseBody
    public boolean addUnitsGroup(@RequestBody UnitsGroupAddRequest request) {
        unitsGroupService.addUnitsGroup(request);
        return true;
    }

    @RequestMapping(value = "/updateUnitsGroup", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateUnitsGroup(@RequestBody UnitsGroupAddRequest request) {
        unitsGroupService.updateUnitsGroup(request);
        return true;
    }

    @RequestMapping(value = "/deleteUnitsGroup", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteUnitsGroup(@RequestBody UnitsGroupAddRequest request) {
        unitsGroupService.deleteUnitsGroup(request);
        return true;
    }

    @RequestMapping(value = "/unitsGroupTree", method = RequestMethod.GET)
    public UnitsGroupTreeResponse getUnitsGroupTree() {
        return unitsGroupService.getUnitsGroupTreeResponse();
    }

    @RequestMapping(value = "/unitsOfMeasure", method = RequestMethod.GET)
    public UnitsOfMeasureResponse getUnitsOfMeasure(@RequestParam Long id) {
        return unitsGroupService.getUnitsOfMeasureResponse(id);
    }
}
