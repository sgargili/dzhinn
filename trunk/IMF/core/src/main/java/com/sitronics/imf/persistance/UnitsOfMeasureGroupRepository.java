package com.sitronics.imf.persistance;

import com.sitronics.imf.UnitsOfMeasureGroup;

/**
 * @author Andrey Popov creates on 19.07.11 (18:16)
 */
public interface UnitsOfMeasureGroupRepository {
    void store(UnitsOfMeasureGroup unitsOfMeasureGroup);

    UnitsOfMeasureGroup getUnitsOfMeasureGroup(Long id);

    void remove(UnitsOfMeasureGroup unitsOfMeasureGroup);
}
