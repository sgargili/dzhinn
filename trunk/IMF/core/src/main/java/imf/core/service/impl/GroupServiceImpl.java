package imf.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import imf.core.dao.GroupDao;
import imf.core.dto.web.response.GroupResponse;
import imf.core.service.GroupService;

/**
 * Developed by: Andrey Popov
 * Date (time): 09.03.11 (18:39)
 */
@Repository
@Service("groupService")
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupDao groupDao;


    @Override
    @Transactional
    public GroupResponse getAllGroupsWithAttributes() {
        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setDtos(groupDao.getAllGroupsWithAttributes());
        return groupResponse;
    }
}
