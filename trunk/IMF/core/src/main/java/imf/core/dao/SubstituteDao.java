package imf.core.dao;

import java.util.List;

import imf.core.entity.SubsGroup;
import imf.core.entity.Substitute;

/**
 * Developed by: Andrey Popov
 * Date (time): 17.02.11 (10:41)
 */

public interface SubstituteDao {
    Substitute saveSubstitute(Substitute substitute);

    void saveOrUpdateSubstitute(Substitute substitute);

    void updateSubstitute(Substitute substitute);

    void deleteSubstitute(Substitute substitute);

    void deleteSubstituteById(Long id);

    List<Substitute> getAllSubstitutes();

    List<Substitute> getSubstitutes(int firstResult);

    List<Substitute> getSubstitutes(int firstResult, int maxResult);

    List<Substitute> getSubstitutesBySubsGroup(SubsGroup subsGroup);

    Substitute getSubstituteById(Long id);

    Long getTotalRows();

    Long getTotalRowsByGroupId(Long id);
}
