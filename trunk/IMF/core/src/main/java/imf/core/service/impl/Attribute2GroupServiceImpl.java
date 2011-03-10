package imf.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import imf.core.dao.Attribute2GroupDao;
import imf.core.dto.web.request.AttributeRequest;
import imf.core.dto.web.request.GroupRequest;
import imf.core.entity.Attribute2Group;
import imf.core.entity.Attribute2GroupId;
import imf.core.service.Attribute2GroupService;

/**
 * Developed by: Andrey Popov
 * Date (time): 10.03.11 (18:07)
 */
@Repository
@Service("attribute2GroupService")
public class Attribute2GroupServiceImpl implements Attribute2GroupService {
    @Autowired
    private Attribute2GroupDao attribute2GroupDao;

    @Override
    @Transactional
    public void addAttribute2Group(GroupRequest groupRequest) {
        Attribute2Group attribute2Group;
        Attribute2GroupId attribute2GroupId;
        for (AttributeRequest attributeRequest : groupRequest.getAttributeRequests()) {

            attribute2GroupId = new Attribute2GroupId();
            attribute2GroupId.setAttributeId(attributeRequest.getId());
            attribute2GroupId.setGroupId(groupRequest.getId());

            attribute2Group = new Attribute2Group();
            attribute2Group.setId(attribute2GroupId);
            attribute2Group.setComment(attributeRequest.getComment());
            attribute2Group.setWeight(attributeRequest.getWeight());
            attribute2GroupDao.addAttribute2Group(attribute2Group);
        }
    }

    @Override
    @Transactional
    public void updateAttribute2Group(GroupRequest groupRequest) {
        Attribute2Group attribute2Group;
        Attribute2GroupId attribute2GroupId;
        for (AttributeRequest attributeRequest : groupRequest.getAttributeRequests()) {

            attribute2GroupId = new Attribute2GroupId();
            attribute2GroupId.setAttributeId(attributeRequest.getId());
            attribute2GroupId.setGroupId(groupRequest.getId());

            attribute2Group = new Attribute2Group();
            attribute2Group.setId(attribute2GroupId);
            attribute2Group.setComment(attributeRequest.getComment());
            attribute2Group.setWeight(attributeRequest.getWeight());
            attribute2GroupDao.updateAttribute2Group(attribute2Group);
        }
    }

    @Override
    @Transactional
    public void deleteAttribute2Group(GroupRequest groupRequest) {
        Attribute2Group attribute2Group;
        Attribute2GroupId attribute2GroupId;
        for (AttributeRequest attributeRequest : groupRequest.getAttributeRequests()) {

            attribute2GroupId = new Attribute2GroupId();
            attribute2GroupId.setAttributeId(attributeRequest.getId());
            attribute2GroupId.setGroupId(groupRequest.getId());

            attribute2Group = new Attribute2Group();
            attribute2Group.setId(attribute2GroupId);

            attribute2GroupDao.deleteAttribute2Group(attribute2Group);
        }
    }
}
