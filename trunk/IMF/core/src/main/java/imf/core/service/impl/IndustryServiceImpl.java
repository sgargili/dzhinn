package imf.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import imf.core.dao.IndustryDao;
import imf.core.dto.IndustryDto;
import imf.core.dto.web.request.IndustryRequest;
import imf.core.dto.web.response.IndustryResponse;
import imf.core.entity.Industry;
import imf.core.service.IndustryService;

/**
 * Developed by: Andrey Popov
 * Date (time): 15.03.11 (16:40)
 */

@Repository
@Service("industryService")
public class IndustryServiceImpl implements IndustryService {
    @Autowired
    private IndustryDao industryDao;

    private Industry convertIndustryRequestToIndustry(IndustryRequest industryRequest) {
        Industry industry = new Industry();
        industry.setId(industryRequest.getId());
        industry.setName(industryRequest.getName());
        industry.setComment(industryRequest.getComment());
        return industry;
    }

    List<IndustryDto> convertIndustryListToIndustryDtoList(List<Industry> industries) {
        List<IndustryDto> industryDtos = new ArrayList<IndustryDto>();
        IndustryDto industryDto;
        for (Industry industry : industries) {
            industryDto = new IndustryDto();
            industryDto.setId(industry.getId());
            industryDto.setName(industry.getName());
            industryDto.setComment(industry.getComment());
            industryDtos.add(industryDto);
        }
        return industryDtos;
    }

    @Override
    @Transactional
    public Industry addIndustry(IndustryRequest industryRequest) {
        return industryDao.saveIndustry(convertIndustryRequestToIndustry(industryRequest));
    }

    @Override
    @Transactional
    public void updateIndustry(IndustryRequest industryRequest) {
        industryDao.updateIndustry(convertIndustryRequestToIndustry(industryRequest));
    }

    @Override
    @Transactional
    public void deleteIndustry(IndustryRequest industryRequest) {
        industryDao.deleteIndustry(convertIndustryRequestToIndustry(industryRequest));
    }

    @Override
    @Transactional
    public Boolean isIndustryPresentByName(String industryName) {
        return industryDao.isIndustryPresentByName(industryName);
    }

    @Override
    @Transactional
    public IndustryResponse getIndustries(Integer firstResult) {
        IndustryResponse industryResponse = new IndustryResponse();

        industryResponse.setTotalRowsCount(industryDao.getAllIndustriesCount());
        industryResponse.setDtos(convertIndustryListToIndustryDtoList(industryDao.getIndustries(firstResult)));

        return industryResponse;
    }

    @Override
    @Transactional
    public IndustryResponse getIndustries(Integer firstResult, Integer maxResult) {
        IndustryResponse industryResponse = new IndustryResponse();

        industryResponse.setTotalRowsCount(industryDao.getAllIndustriesCount());
        industryResponse.setDtos(convertIndustryListToIndustryDtoList(industryDao.getIndustries(firstResult, maxResult)));

        return industryResponse;
    }


}
