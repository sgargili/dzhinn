package imf.core.service;

import imf.core.dto.web.request.TemplateRequest;
import imf.core.dto.web.response.TemplateResponse;
import imf.core.entity.Template;

/**
 * Developed by: Andrey Popov
 * Date (time): 06.03.11 (19:23)
 */

public interface TemplateService {

    Template addTemplate(TemplateRequest templateRequest);

    void updateTemplate(TemplateRequest templateRequest);

    void deleteTemplate(TemplateRequest templateRequest);

    Boolean isTemplatePresentByName(String templateName);

    TemplateResponse getTemplateById(Long templateId);

}
