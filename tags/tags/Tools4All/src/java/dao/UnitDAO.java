/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.Unit;

/**
 *
 * @author Apopov
 */
public interface UnitDAO {

    public void addAUnit(Unit unit);

    public void addOrUpdateUnitNameOnly(Unit unit);

    public void updateUnitAltNameOnly(Unit unit);

    public void deleteUnit(Unit unit);

    public List<Unit> getAllUnitsOnly();

    public List<Unit> getAllUnitsWithAltNames();

    public List<Unit> getUnitsOnlyByTemplate(String template);

    public Unit getUnitById(int id);

    public Unit getUnitByName(String name);

    public boolean isUnitPresent(Unit unit);

    public boolean isUnitPresent(String unitName);
}
