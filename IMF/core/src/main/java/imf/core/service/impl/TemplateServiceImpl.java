package imf.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import imf.core.dao.TemplateDao;
import imf.core.dto.web.request.TemplateRequest;
import imf.core.dto.web.response.TemplateResponse;
import imf.core.entity.Template;
import imf.core.service.TemplateService;

/**
 * Developed by: Andrey Popov
 * Date (time): 06.03.11 (19:26)
 */
@Repository
@Service("templateService")
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private TemplateDao templateDao;

    private Template convertTemplateRequestToTemplate(TemplateRequest templateRequest) {
        Template template = new Template();
        template.setId(templateRequest.getId());
        template.setComment(templateRequest.getComment());
        template.setName(templateRequest.getName());
        return template;
    }

    @Override
    @Transactional
    public Template addTemplate(TemplateRequest templateRequest) {
        return templateDao.saveTemplate(convertTemplateRequestToTemplate(templateRequest));
    }

    @Override
    @Transactional
    public void updateTemplate(TemplateRequest templateRequest) {
        templateDao.updateTemplate(convertTemplateRequestToTemplate(templateRequest));
    }

    @Override
    @Transactional
    public void deleteTemplate(TemplateRequest templateRequest) {
        templateDao.deleteTemplate(convertTemplateRequestToTemplate(templateRequest));
    }

    @Override
    @Transactional
    public Boolean isTemplatePresentByName(String templateName) {
        return templateDao.isTemplatePresentByName(templateName);
    }

    @Override
    @Transactional
    public TemplateResponse getTemplateById(Long templateId) {
        Template template = new Template();
        template.setId(templateId);

        TemplateResponse response = new TemplateResponse();

        response.addDto(templateDao.getTemplateDto(template));
//        response.setTotalRowsCount(attributeDao.getTotalRowsByGroupId(groupId));
        return response;
    }
}
