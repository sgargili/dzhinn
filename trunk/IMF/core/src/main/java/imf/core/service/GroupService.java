package imf.core.service;

import imf.core.dto.web.request.GroupRequest;
import imf.core.dto.web.response.GroupResponse;
import imf.core.entity.Group;

/**
 * Developed by: Andrey Popov
 * Date (time): 09.03.11 (18:38)
 */

public interface GroupService {

    Group addGroup(GroupRequest groupRequest);

    void updateGroup(GroupRequest groupRequest);

    void deleteGroup(GroupRequest groupRequest);

    Boolean isGroupPresentByName(String groupName);

    GroupResponse getAllGroups();

    GroupResponse getGroupsByName(String groupName, Integer firstResult);

    GroupResponse getGroupsByName(String groupName, Integer firstResult, Integer maxResult);

    GroupResponse getAllGroupsWithAttributes();

    GroupResponse getGroupsWithAttributesByName(String groupName, Integer firstResult);

    GroupResponse getGroupsWithAttributesByName(String groupName, Integer firstResult, Integer maxResult);
}
