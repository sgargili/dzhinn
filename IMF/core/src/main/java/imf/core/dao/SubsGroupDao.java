package imf.core.dao;

import imf.core.entity.SubsGroup;
import imf.core.entity.UnitsGroup;

import java.util.List;

/**
 * Developed by: Andrey Popov
 * Date (time): 14.02.11 (16:20)
 */

public interface SubsGroupDao {

    SubsGroup saveSubsGroup(SubsGroup subsGroup);

    void saveOrUpdateSubsGroup(SubsGroup subsGroup);

    void updateSubsGroup(SubsGroup subsGroup);

    void deleteSubsGroup(SubsGroup subsGroup);

    List<SubsGroup> getAllSubsGroups();

    List<SubsGroup> getSubsGroups(int firstResult);

    List<SubsGroup> getSubsGroups(int firstResult, int maxResult);

    SubsGroup getSubsGroupById(Long id);

    SubsGroup getSubsGroupWithSubstitutesById(Long id);

    Long getTotalRowsCount();
}
