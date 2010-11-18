package imf.core.service.impl;

import imf.core.dao.UnitOfMeasureDao;
import imf.core.dao.UnitsGroupDao;
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

    private UnitsGroup unitsGroupWP;
    private UnitsGroup unitsGroupWOP;
    private List<UnitOfMeasure> units;
    int i;
//    private List<UnitOfMeasure> units2 = new ArrayList<UnitOfMeasure>();


    @Override
    public UnitsGroup getUnitsGroupById(Long id) {
        i = 0;
        unitsGroupWP = unitsGroupDao.getUnitsGroupById(id);
        units = unitOfMeasureDao.getAllUnitOfMeasures();
        for (UnitOfMeasure unit : units) {
            unit.setUnitsGroupe(null);
            units.set(i++, unit);
        }
        unitsGroupWP.setUnitOfMeasures(units);
        return unitsGroupWP;
    }
}
