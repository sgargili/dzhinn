package imf.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import imf.core.dto.web.request.IndustryRequest;
import imf.core.dto.web.response.IndustryResponse;
import imf.core.service.IndustryService;

/**
 * Developed by: Andrey Popov
 * Date (time): 15.03.11 (17:36)
 */

@Controller
public class IndustryController {
    @Qualifier("industryService")
    @Autowired
    private IndustryService industryService;

    @RequestMapping(value = "/addIndustry", method = RequestMethod.POST)
    @ResponseBody
    public Boolean addIndustry(@RequestBody IndustryRequest templateRequest) {
        return (industryService.addIndustry(templateRequest) != null);
    }

    @RequestMapping(value = "/updateIndustry", method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateIndustry(@RequestBody IndustryRequest templateRequest) {
        industryService.updateIndustry(templateRequest);
        return true;
    }

    @RequestMapping(value = "/deleteIndustry", method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteIndustry(@RequestBody IndustryRequest templateRequest) {
        industryService.deleteIndustry(templateRequest);
        return true;
    }

    @RequestMapping(value = "/isIndustryPresent", method = RequestMethod.GET)
    @ResponseBody
    public Boolean isIndustryPresent(@RequestParam String industryName) {
        return industryService.isIndustryPresentByName(industryName);
    }

    @RequestMapping(value = "/industries", method = RequestMethod.GET)
    public IndustryResponse getIndustries(@RequestParam Integer firstResult,
                                          @RequestParam Integer maxResult) {
        return industryService.getIndustries(firstResult, maxResult);
    }
}
