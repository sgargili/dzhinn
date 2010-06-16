/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import factories.FactoryDAO4Grabli;
import pojo.Unit;
import pojo.UnitAlternativeName;

/**
 *
 * @author Apopov
 */
public class Test4DAO {
    public static void main(String[] args){
    FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
    Unit unit = new Unit();
    unit.setUnitName("килограммы");
    UnitAlternativeName unitAlt = new UnitAlternativeName();
    unitAlt.setUnit(unit);
    unitAlt.setUnitAlernativeNameValue("кг");
    fd.getUnitDAO().addAUnit(unit);
    fd.getUnitAlternativeNameDAO().addUnitAlternativeName(unitAlt);
    }

}
