package imf.core.service;

import imf.core.dto.web.request.IndustryRequest;
import imf.core.dto.web.response.IndustryResponse;
import imf.core.entity.Industry;

/**
 * Developed by: Andrey Popov
 * Date (time): 15.03.11 (16:37)
 */

public interface IndustryService {
    Industry addIndustry(IndustryRequest industryRequest);

    void updateIndustry(IndustryRequest industryRequest);

    void deleteIndustry(IndustryRequest industryRequest);

    Boolean isIndustryPresentByName(String industryName);

    IndustryResponse getIndustries(Integer firstResult);

    IndustryResponse getIndustries(Integer firstResult, Integer maxResult);
}
