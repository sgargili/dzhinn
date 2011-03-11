package imf.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import imf.core.dao.Group2TemplateDao;
import imf.core.dto.web.request.GroupRequest;
import imf.core.dto.web.request.TemplateRequest;
import imf.core.entity.Group2Template;
import imf.core.entity.Group2TemplateId;
import imf.core.service.Group2TemplateService;

/**
 * Developed by: Andrey Popov
 * Date (time): 11.03.11 (16:35)
 */
@Repository
@Service("group2TemplateService")
public class Group2TemplateServiceImpl implements Group2TemplateService {
    @Autowired
    private Group2TemplateDao group2TemplateDao;

    @Override
    @Transactional
    public void addGroup2Template(TemplateRequest templateRequest) {
        Group2Template group2Template;
        Group2TemplateId group2TemplateId;
        for (GroupRequest groupRequest : templateRequest.getGroupRequests()) {

            group2TemplateId = new Group2TemplateId();
            group2TemplateId.setTemplateId(templateRequest.getId());
            group2TemplateId.setGroupId(groupRequest.getId());


            group2Template = new Group2Template();
            group2Template.setId(group2TemplateId);
            group2Template.setComment(groupRequest.getComment());
            group2Template.setWeight(groupRequest.getWeight());
            group2TemplateDao.addGroup2Template(group2Template);
        }
    }

    @Override
    @Transactional
    public void updateGroup2Template(TemplateRequest templateRequest) {
         Group2Template group2Template;
        Group2TemplateId group2TemplateId;
        for (GroupRequest groupRequest : templateRequest.getGroupRequests()) {

            group2TemplateId = new Group2TemplateId();
            group2TemplateId.setTemplateId(templateRequest.getId());
            group2TemplateId.setGroupId(groupRequest.getId());


            group2Template = new Group2Template();
            group2Template.setId(group2TemplateId);
            group2Template.setComment(groupRequest.getComment());
            group2Template.setWeight(groupRequest.getWeight());
            group2TemplateDao.updateGroup2Template(group2Template);
        }
    }

    @Override
    @Transactional
    public void deleteGroup2Template(TemplateRequest templateRequest) {
         Group2Template group2Template;
        Group2TemplateId group2TemplateId;
        for (GroupRequest groupRequest : templateRequest.getGroupRequests()) {

            group2TemplateId = new Group2TemplateId();
            group2TemplateId.setTemplateId(templateRequest.getId());
            group2TemplateId.setGroupId(groupRequest.getId());


            group2Template = new Group2Template();
            group2Template.setId(group2TemplateId);
            group2TemplateDao.deleteGroup2Template(group2Template);
        }
    }
}
