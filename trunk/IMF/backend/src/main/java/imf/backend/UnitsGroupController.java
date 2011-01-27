package imf.backend;

import imf.core.dto.UnitsGroupDto;
import imf.core.entity.UnitsGroup;
import imf.core.service.UnitsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 17:14:59
 */
@Controller
public class UnitsGroupController {

    @Autowired
    private UnitsGroupService unitsGroupService;

    @RequestMapping(value = "/units", method = RequestMethod.GET)
//    @ResponseBody
    public UnitsGroupDto getUnitGroups(@RequestParam Long id) {
        return unitsGroupService.getUnitsGroupWithUnitsById(id);
    }
}
