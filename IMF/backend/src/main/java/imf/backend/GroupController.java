package imf.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import imf.core.dto.web.request.GroupRequest;
import imf.core.dto.web.response.GroupResponse;
import imf.core.service.Attribute2GroupService;
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

    @Qualifier("attribute2GroupService")
    @Autowired
    private Attribute2GroupService attribute2GroupService;

    @RequestMapping(value = "/addGroup", method = RequestMethod.POST)
    @ResponseBody
    public Boolean addGroup(@RequestBody GroupRequest groupRequest) {
        return (groupService.addGroup(groupRequest) != null);
    }

    @RequestMapping(value = "/updateGroup", method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateGroup(@RequestBody GroupRequest groupRequest) {
        groupService.updateGroup(groupRequest);
        return true;
    }

    @RequestMapping(value = "/deleteGroup", method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteGroup(@RequestBody GroupRequest groupRequest) {
        groupService.deleteGroup(groupRequest);
        return true;
    }

    @RequestMapping(value = "/addGroupWithAttributes", method = RequestMethod.POST)
    @ResponseBody
    public Boolean addGroupWithAttributes(@RequestBody GroupRequest groupRequest) {
        attribute2GroupService.addAttribute2Group(groupRequest);
        return true;
    }

    @RequestMapping(value = "/updateGroupWithAttributes", method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateGroupWithAttributes(@RequestBody GroupRequest groupRequest) {
        attribute2GroupService.updateAttribute2Group(groupRequest);
        return true;
    }

    @RequestMapping(value = "/deleteGroupWithAttributes", method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteGroupWithAttributes(@RequestBody GroupRequest groupRequest) {
        attribute2GroupService.deleteAttribute2Group(groupRequest);
        return true;
    }

    @RequestMapping(value = "/isGroupPresent", method = RequestMethod.GET)
    @ResponseBody
    public Boolean isAttributePresent(@RequestParam String groupName) {
        return groupService.isGroupPresentByName(groupName);
    }

    @RequestMapping(value = "/groupsWithAttributes", method = RequestMethod.GET)
    public GroupResponse getGroupsWithAttributes(@RequestParam String groupName,
                                                 @RequestParam Integer firstResult,
                                                 @RequestParam Integer maxResult) {
        return groupService.getGroupsWithAttributesByName(groupName, firstResult, maxResult);
    }

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public GroupResponse getGroups(@RequestParam String groupName,
                                   @RequestParam Integer firstResult,
                                   @RequestParam Integer maxResult) {
        return groupService.getGroupsByName(groupName, firstResult, maxResult);
    }
}
