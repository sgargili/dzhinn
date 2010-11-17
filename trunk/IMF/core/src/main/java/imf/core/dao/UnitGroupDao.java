package imf.core.dao;

import imf.core.entity.UnitGroup;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 15:55:03
 * To change this template use File | Settings | File Templates.
 */
public interface UnitGroupDao {
    UnitGroup saveUnitGroup(UnitGroup unitGroup);

    void saveOrUpdateUnitGroup(UnitGroup unitGroup);

    void updateUnitGroup(UnitGroup unitGroup);

    void deleteUnitGroup(UnitGroup unitGroup);

    void deleteUnitGroupById(Long id);

    List<UnitGroup> getAllUnitGroups();

    List<UnitGroup> getUnitGroups(int firstResult);

    List<UnitGroup> getUnitGroups(int firstResult, int maxResult);

    UnitGroup getUnitGroupById(Long id);
}
