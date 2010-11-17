package imf.backend;

import imf.core.dao.UnitGroupDao;
import imf.core.dto.UnitGroupDto;
import imf.core.entity.UnitGroup;
import imf.core.service.UnitGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 17:14:59
 *
 */
@Controller
public class UnitGroupController {

    @Autowired
    private UnitGroupService unitGroupeService;

    @RequestMapping(value = "/units", method = RequestMethod.GET)
    @ResponseBody
    public UnitGroupDto getUnitGroups() {
        return unitGroupeService.getAllUnitGroups();
    }
}
