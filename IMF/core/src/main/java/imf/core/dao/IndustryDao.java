package imf.core.dao;

import java.util.List;

import imf.core.entity.Industry;

/**
 * Developed by: Andrey Popov
 * Date (time): 15.03.11 (16:09)
 */

public interface IndustryDao {
    Industry saveIndustry(Industry industry);

    void saveOrUpdateIndustry(Industry industry);

    void updateIndustry(Industry industry);

    void deleteIndustry(Industry industry);

    List<Industry> getAllIndustries();

    List<Industry> getIndustries(Integer firstResult);

    List<Industry> getIndustries(Integer firstResult, Integer maxResult);

    Boolean isIndustryPresentByName(String industryName);

    Industry getIndustryById(Long id);

    Long getAllIndustriesCount();
}
