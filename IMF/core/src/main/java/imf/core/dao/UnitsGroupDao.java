package imf.core.dao;

import imf.core.entity.UnitsGroup;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 15:55:03
 * To change this template use File | Settings | File Templates.
 */
public interface UnitsGroupDao {
    UnitsGroup saveUnitsGroup(UnitsGroup unitsGroup);

    void saveOrUpdateUnitsGroup(UnitsGroup unitsGroup);

    void updateUnitsGroup(UnitsGroup unitsGroup);

    void deleteUnitsGroup(UnitsGroup unitsGroup);

    void deleteUnitsGroupById(Long id);

    List<UnitsGroup> getAllUnitsGroups();

    List<UnitsGroup> getUnitsGroups(int firstResult);

    List<UnitsGroup> getUnitsGroups(int firstResult, int maxResult);

    UnitsGroup getUnitsGroupById(Long id);
}
