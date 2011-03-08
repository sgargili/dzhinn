package imf.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import imf.core.dto.web.response.TemplateResponse;
import imf.core.service.TemplateService;

/**
 * Developed by: Администратор
 * Date (time): 06.03.11 (22:50)
 */
@Controller
public class TemplateController {
    @Qualifier("templateService")
    @Autowired
    private TemplateService templateService;

    @RequestMapping(value = "/templates", method = RequestMethod.GET)
    public TemplateResponse getTemplateResponse(@RequestParam Long templateId/*,
                                             @RequestParam Integer firstResult,
                                             @RequestParam Integer maxResult*/) {
        TemplateResponse response = templateService.getTemplateById(templateId);
        return response;
    }
}
