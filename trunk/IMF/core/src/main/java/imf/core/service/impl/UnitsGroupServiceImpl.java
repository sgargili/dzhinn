package imf.core.service.impl;

import imf.core.dao.UnitOfMeasureDao;
import imf.core.dao.UnitsGroupDao;
import imf.core.dto.UnitOfMeasureDto;
import imf.core.dto.UnitsGroupDto;
import imf.core.entity.UnitOfMeasure;
import imf.core.entity.UnitsGroup;
import imf.core.service.UnitsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 18:03:19
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Service("unitsGroupService")
public class UnitsGroupServiceImpl implements UnitsGroupService {
    @Autowired
    private UnitsGroupDao unitsGroupDao;
    @Autowired
    private UnitOfMeasureDao unitOfMeasureDao;

    private UnitsGroup unitsGroup;
    private List<UnitOfMeasure> units;
    private UnitsGroupDto unitsGroupDto;
    private UnitOfMeasureDto unitOfMeasureDto;

    private UnitOfMeasureDto convertUnitOfMeasureToDto(UnitOfMeasure unit) {
        UnitOfMeasureDto dto = new UnitOfMeasureDto();
        dto.setComment(unit.getComment());
        dto.setDefaultValue(unit.isDefaultValue());
        dto.setId(unit.getId());
        dto.setName(unit.getName());
        dto.setPrefix(unit.getPrefix());
        dto.setRatio(unit.getRatio());
        return dto;
    }

    private UnitsGroupDto convertUnitsGroupToDto(UnitsGroup ug) {
        UnitsGroupDto dto = new UnitsGroupDto();
        dto.setComment(ug.getComment());
        dto.setId(ug.getId());
        dto.setName(ug.getName());
        return dto;
    }

    @Override
    public UnitsGroupDto getUnitsGroupWithUnitsById(Long id) {
        unitsGroup = unitsGroupDao.getUnitsGroupById(id);
        unitsGroupDto = convertUnitsGroupToDto(unitsGroup);

        units = unitOfMeasureDao.getUnitOfMeasuresByUnitsGroup(unitsGroup);
        for (UnitOfMeasure um : units) {
            unitOfMeasureDto = convertUnitOfMeasureToDto(um);
            unitsGroupDto.addUnitOfMeasureDto(unitOfMeasureDto);
        }

        return unitsGroupDto;
    }
}
