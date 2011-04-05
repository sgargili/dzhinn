package imf.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import imf.core.dao.Attribute2Group2TemplateDao;
import imf.core.dto.web.request.AttributeRequest;
import imf.core.dto.web.request.GroupRequest;
import imf.core.dto.web.request.TemplateRequest;
import imf.core.entity.Attribute2Group2Template;
import imf.core.entity.Attribute2Group2TemplateId;
import imf.core.service.Attribute2Group2TemplateService;

/**
 * Developed by: Andrey Popov
 * Date (time): 11.03.11 (17:32)
 */
@Service("attribute2Group2TemplateService")
public class Attribute2Group2TemplateServiceImpl implements Attribute2Group2TemplateService {
    @Autowired
    private Attribute2Group2TemplateDao attribute2Group2TemplateDao;

    @Override
    @Transactional
    public void addAttribute2Group2Template(TemplateRequest templateRequest) {
        Attribute2Group2Template attribute2Group2Template;
        Attribute2Group2TemplateId attribute2Group2TemplateId;

        for (GroupRequest groupRequest : templateRequest.getGroupRequests()) {
            for (AttributeRequest attributeRequest : groupRequest.getAttributeRequests()) {
                attribute2Group2TemplateId = new Attribute2Group2TemplateId();
                attribute2Group2TemplateId.setAttributeId(attributeRequest.getId());
                attribute2Group2TemplateId.setGroupId(groupRequest.getId());
                attribute2Group2TemplateId.setTemplateId(templateRequest.getId());

                attribute2Group2Template = new Attribute2Group2Template();
                attribute2Group2Template.setAttribute2Group2TemplateId(attribute2Group2TemplateId);
                attribute2Group2Template.setComment(attributeRequest.getComment());
                attribute2Group2Template.setComposite(attributeRequest.getComposite());
                attribute2Group2Template.setRequire(attributeRequest.getRequire());

                attribute2Group2TemplateDao.addAttribute2Group2Template(attribute2Group2Template);

            }
        }
    }

    @Override
    @Transactional
    public void updateAttribute2Group2Template(TemplateRequest templateRequest) {
        Attribute2Group2Template attribute2Group2Template;
        Attribute2Group2TemplateId attribute2Group2TemplateId;

        for (GroupRequest groupRequest : templateRequest.getGroupRequests()) {
            for (AttributeRequest attributeRequest : groupRequest.getAttributeRequests()) {
                attribute2Group2TemplateId = new Attribute2Group2TemplateId();
                attribute2Group2TemplateId.setAttributeId(attributeRequest.getId());
                attribute2Group2TemplateId.setGroupId(groupRequest.getId());
                attribute2Group2TemplateId.setTemplateId(templateRequest.getId());

                attribute2Group2Template = new Attribute2Group2Template();
                attribute2Group2Template.setAttribute2Group2TemplateId(attribute2Group2TemplateId);
                attribute2Group2Template.setComment(attributeRequest.getComment());
                attribute2Group2Template.setComposite(attributeRequest.getComposite());
                attribute2Group2Template.setRequire(attributeRequest.getRequire());

                attribute2Group2TemplateDao.updateAttribute2Group2Template(attribute2Group2Template);

            }
        }
    }

    @Override
    @Transactional
    public void deleteAttribute2Group2Template(TemplateRequest templateRequest) {
        Attribute2Group2Template attribute2Group2Template;
        Attribute2Group2TemplateId attribute2Group2TemplateId;

        for (GroupRequest groupRequest : templateRequest.getGroupRequests()) {
            for (AttributeRequest attributeRequest : groupRequest.getAttributeRequests()) {
                attribute2Group2TemplateId = new Attribute2Group2TemplateId();
                attribute2Group2TemplateId.setAttributeId(attributeRequest.getId());
                attribute2Group2TemplateId.setGroupId(groupRequest.getId());
                attribute2Group2TemplateId.setTemplateId(templateRequest.getId());

                attribute2Group2Template = new Attribute2Group2Template();
                attribute2Group2Template.setAttribute2Group2TemplateId(attribute2Group2TemplateId);
                attribute2Group2Template.setComment(attributeRequest.getComment());
                attribute2Group2Template.setComposite(attributeRequest.getComposite());
                attribute2Group2Template.setRequire(attributeRequest.getRequire());

                attribute2Group2TemplateDao.deleteAttribute2Group2Template(attribute2Group2Template);

            }
        }
    }
}
