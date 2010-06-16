/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.UnitDAO;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.Unit;

/**
 *
 * @author Apopov
 */
public class UnitDAOImpl implements UnitDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public void addAUnit(Unit unit) {
        getHibernateTemplate().saveOrUpdate(unit);
    }

    public void addOrUpdateUnitNameOnly(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateUnitAltNameOnly(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deleteUnit(Unit unit) {
        getHibernateTemplate().delete(unit);
    }

    public List<Unit> getAllUnitsOnly() {
        return (List<Unit>) getHibernateTemplate().loadAll(Unit.class);
    }

    public List<Unit> getAllUnitsWithAltNames() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Unit> getUnitsOnlyByTemplate(String template) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Unit getUnitById(int id) {
        Unit unit;
        String query = "from Unit u where unitId = :value";
        try {
            unit = (Unit) getHibernateTemplate().findByNamedParam(query, "value", id).get(0);
            unit.getUnitAlternativeNames().isEmpty();
            return unit;
        } catch (Exception ex) {
            return null;
        }
    }

    public Unit getUnitByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isUnitPresent(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isUnitPresent(String unitName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
