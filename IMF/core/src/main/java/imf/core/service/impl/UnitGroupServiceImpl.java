package imf.core.service.impl;

import imf.core.dao.UnitGroupDao;
import imf.core.dto.UnitGroupDto;
import imf.core.entity.UnitGroup;
import imf.core.service.UnitGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 18:03:19
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Service("unitGroupService")
public class UnitGroupServiceImpl implements UnitGroupService {
    @Autowired
    private UnitGroupDao unitGroupeDao;
    private List<UnitGroup> unitGroupes;
    private UnitGroupDto unitGroupDto;

    @Override
    public UnitGroupDto getAllUnitGroups() {
        unitGroupes = unitGroupeDao.getAllUnitGroups();
        unitGroupDto = new UnitGroupDto();
        unitGroupDto.setUnitGroup(unitGroupes);
        return unitGroupDto;
    }
}
