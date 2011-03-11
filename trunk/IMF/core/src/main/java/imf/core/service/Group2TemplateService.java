package imf.core.service;

import imf.core.dto.web.request.TemplateRequest;

/**
 * Developed by: Andrey Popov
 * Date (time): 11.03.11 (16:28)
 */

public interface Group2TemplateService {
    void addGroup2Template(TemplateRequest templateRequest);

    void updateGroup2Template(TemplateRequest templateRequest);

    void deleteGroup2Template(TemplateRequest templateRequest);

}
