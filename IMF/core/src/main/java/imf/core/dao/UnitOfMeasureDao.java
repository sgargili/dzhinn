package imf.core.dao;

import imf.core.entity.UnitOfMeasure;

import java.util.List;

/**
 * User: Andrey Popov
 * Date: 18.11.2010
 * Time: 11:06:58
 */
public interface UnitOfMeasureDao {
    UnitOfMeasure saveUnitOfMeasure(UnitOfMeasure unitOfMeasure);

    void saveOrUpdateUnitOfMeasure(UnitOfMeasure unitOfMeasure);

    void updateUnitOfMeasure(UnitOfMeasure unitOfMeasure);

    void deleteUnitOfMeasure(UnitOfMeasure unitOfMeasure);

    void deleteUnitOfMeasureById(Long id);

    List<UnitOfMeasure> getAllUnitOfMeasures();

    List<UnitOfMeasure> getUnitOfMeasures(int firstResult);

    List<UnitOfMeasure> getUnitOfMeasures(int firstResult, int maxResult);

    UnitOfMeasure getUnitOfMeasureById(Long id);
}
