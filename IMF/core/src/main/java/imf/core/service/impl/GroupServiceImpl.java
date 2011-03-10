package imf.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import imf.core.dao.GroupDao;
import imf.core.dto.GroupDto;
import imf.core.dto.web.request.GroupRequest;
import imf.core.dto.web.response.GroupResponse;
import imf.core.entity.Group;
import imf.core.service.GroupService;

/**
 * Developed by: Andrey Popov
 * Date (time): 09.03.11 (18:39)
 */
@Repository
@Service("groupService")
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;

    private Group convertGroupRequestToGroup(GroupRequest groupRequest) {
        Group group = new Group();
        group.setId(groupRequest.getId());
        group.setComment(groupRequest.getComment());
        group.setName(groupRequest.getName());
        return group;
    }

    private List<GroupDto> convertGroupListToGroupDtoList(List<Group> groups) {
        List<GroupDto> groupDtos = new ArrayList<GroupDto>();
        GroupDto groupDto;
        for (Group group : groups) {
            groupDto = new GroupDto();
            groupDto.setId(group.getId());
            groupDto.setName(group.getName());
            groupDto.setComment(group.getComment());
            groupDtos.add(groupDto);
        }
        return groupDtos;
    }

    @Override
    @Transactional
    public Group addGroup(GroupRequest groupRequest) {
        return groupDao.saveGroup(convertGroupRequestToGroup(groupRequest));
    }

    @Override
    @Transactional
    public void updateGroup(GroupRequest groupRequest) {
        groupDao.updateGroup(convertGroupRequestToGroup(groupRequest));
    }

    @Override
    @Transactional
    public void deleteGroup(GroupRequest groupRequest) {
        groupDao.deleteGroup(convertGroupRequestToGroup(groupRequest));
    }

    @Override
    @Transactional
    public Boolean isGroupPresentByName(String groupName) {
        return groupDao.isGroupPresentByName(groupName);
    }

    @Override
    @Transactional
    public GroupResponse getAllGroups() {
        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setDtos(convertGroupListToGroupDtoList(groupDao.getAllGroups()));
        groupResponse.setTotalRowsCount(groupDao.getTotalRows());
        return groupResponse;
    }

    @Override
    @Transactional
    public GroupResponse getGroupsByName(String groupName, Integer firstResult) {
        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setDtos(convertGroupListToGroupDtoList(groupDao.getGroupsByName(groupName, firstResult)));
        groupResponse.setTotalRowsCount(groupDao.getTotalRowsByName(groupName));
        return groupResponse;
    }

    @Override
    @Transactional
    public GroupResponse getGroupsByName(String groupName, Integer firstResult, Integer maxResult) {
        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setDtos(convertGroupListToGroupDtoList(groupDao.getGroupsByName(groupName, firstResult, maxResult)));
        groupResponse.setTotalRowsCount(groupDao.getTotalRowsByName(groupName));
        return groupResponse;
    }

    @Override
    @Transactional
    public GroupResponse getAllGroupsWithAttributes() {
        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setDtos(groupDao.getAllGroupsWithAttributes());
        groupResponse.setTotalRowsCount(groupDao.getTotalRows());
        return groupResponse;
    }

    @Override
    @Transactional
    public GroupResponse getGroupsWithAttributesByName(String groupName, Integer firstResult) {
        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setDtos(groupDao.getGroupsWithAttributesByName(groupName, firstResult));
        groupResponse.setTotalRowsCount(groupDao.getTotalRowsByName(groupName));
        return groupResponse;
    }

    @Override
    @Transactional
    public GroupResponse getGroupsWithAttributesByName(String groupName, Integer firstResult, Integer maxResult) {
        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setDtos(groupDao.getGroupsWithAttributesByName(groupName, firstResult, maxResult));
        groupResponse.setTotalRowsCount(groupDao.getTotalRowsByName(groupName));
        return groupResponse;
    }
}
