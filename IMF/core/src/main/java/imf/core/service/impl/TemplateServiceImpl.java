package imf.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import imf.core.dao.TemplateDao;
import imf.core.dto.web.response.TemplateResponse;
import imf.core.entity.Template;
import imf.core.service.TemplateService;

/**
 * Developed by: Администратор
 * Date (time): 06.03.11 (19:26)
 */
@Repository
@Service("templateService")
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    TemplateDao templateDao;

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
