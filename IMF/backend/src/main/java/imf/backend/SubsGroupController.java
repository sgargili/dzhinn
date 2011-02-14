package imf.backend;

import imf.core.dto.web.response.TreeResponse;
import imf.core.service.SubsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Developed by: Andrey Popov
 * Date (time): 14.02.11 (16:55)
 */

@Controller
public class SubsGroupController {
    @Autowired
    private SubsGroupService subsGroupService;

    @RequestMapping(value = "/subsGroupTree", method = RequestMethod.GET)
    public TreeResponse getSubsGroupTree() {
        return subsGroupService.getSubsGroupTreeResponse();
    }
}
