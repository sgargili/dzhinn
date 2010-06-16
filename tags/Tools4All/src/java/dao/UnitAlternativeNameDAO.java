/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
}
