/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.Unit;
import pojo.UnitAlternativeName;

/**
 *
 * @author Apopov
 */
public interface UnitAlternativeNameDAO {

    public void addUnitAlternativeName(UnitAlternativeName unitAlternativeName);

    public void deleteUnitAlternativeName(UnitAlternativeName attributeAlternativeName);

    public void deleteUnitAlternativeNameByUnit(Unit unit);

    public boolean isUnitAlternativeNamePresent(UnitAlternativeName unitAlternativeName);

    public boolean isUnitAlternativeNamePresent(String unitAlternativeNameValue);

    public List<UnitAlternativeName> getAllUnitAlternativeNamesOnly();

    public List<UnitAlternativeName> getAllUnitAlternativeNamesByUnitId(int unitId);
}
