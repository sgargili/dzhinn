package imf.core.service;

import imf.core.dto.web.response.TemplateResponse;

/**
 * Developed by: Администратор
 * Date (time): 06.03.11 (19:23)
 */

public interface TemplateService {

    TemplateResponse getTemplateById(Long templateId);

}
