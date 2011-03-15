package imf.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import imf.core.dto.web.request.TemplateRequest;
import imf.core.dto.web.response.TemplateResponse;
import imf.core.service.Attribute2Group2TemplateService;
import imf.core.service.TemplateService;

/**
 * Developed by: Andrey Popov
 * Date (time): 06.03.11 (22:50)
 */
@Controller
public class TemplateController {
    @Qualifier("templateService")
    @Autowired
    private TemplateService templateService;

    @Qualifier("attribute2Group2TemplateService")
    @Autowired
    private Attribute2Group2TemplateService attribute2Group2TemplateService;

    @RequestMapping(value = "/addTemplate", method = RequestMethod.POST)
    @ResponseBody
    public Boolean addTemplate(@RequestBody TemplateRequest templateRequest) {
        return (templateService.addTemplate(templateRequest) != null);
    }

    @RequestMapping(value = "/updateTemplate", method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateTemplate(@RequestBody TemplateRequest templateRequest) {
        templateService.updateTemplate(templateRequest);
        return true;
    }

    @RequestMapping(value = "/deleteTemplate", method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteTemplate(@RequestBody TemplateRequest templateRequest) {
        templateService.deleteTemplate(templateRequest);
        return true;
    }

    @RequestMapping(value = "/templates", method = RequestMethod.GET)
    public TemplateResponse getTemplateResponse(@RequestParam Long templateId) {
        TemplateResponse response = templateService.getTemplateById(templateId);
        return response;
    }

    @RequestMapping(value = "/isTemplatePresent", method = RequestMethod.GET)
    @ResponseBody
    public Boolean isAttributePresent(@RequestParam String templateName) {
        return templateService.isTemplatePresentByName(templateName);
    }

    @RequestMapping(value = "/updateTemplateWithGroupWithAttributes", method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateGroupWithAttributes(@RequestBody TemplateRequest templateRequest) {
        attribute2Group2TemplateService.updateAttribute2Group2Template(templateRequest);
        return true;
    }
}
