package imf.core.service;

import imf.core.dto.UnitsGroupDto;

/**
 *
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 18:02:18
 * 
 */
public interface UnitsGroupService {
    public UnitsGroupDto getUnitsGroupWithUnitsById(Long id);
}
