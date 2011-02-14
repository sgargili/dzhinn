package imf.core.service;

import imf.core.dto.UnitsGroupDto;
import imf.core.dto.web.request.UnitsGroupAddRequest;
import imf.core.dto.web.response.UnitsGroupResponse;
import imf.core.dto.web.response.TreeResponse;
import imf.core.dto.web.response.UnitsOfMeasureResponse;

import java.util.List;

/**
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 18:02:18
 */
public interface UnitsGroupService {
    void addUnitsGroup(UnitsGroupAddRequest request);

    void updateUnitsGroup(UnitsGroupAddRequest request);

    void deleteUnitsGroup(UnitsGroupAddRequest request);

    UnitsGroupDto getUnitsGroupWithUnitsById(Long id);

    List<UnitsGroupDto> getAllUnitsGroup();

    List<UnitsGroupDto> getUnitsGroup(int firstResult, int maxResult);

    UnitsGroupResponse getUnitsGroupResponse(int firstResult, int maxResult);

    TreeResponse getUnitsGroupTreeResponse();

    UnitsOfMeasureResponse getUnitsOfMeasureResponse(Long id);
}
