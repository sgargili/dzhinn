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
        try {
            Unit newUnit;
            newUnit = getUnitByName(unit.getUnitName());
            newUnit.setUnitAlternativeNames(unit.getUnitAlternativeNames());
            getHibernateTemplate().update(newUnit);
        } catch (Exception ex) {
            // ex.printStackTrace();
            getHibernateTemplate().save(unit);
        }
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
        String query = "from Unit as u "
                + "join fetch u.unitAlternativeNames order by u.unitName";
        return getHibernateTemplate().find(query);
    }

    public List<Unit> getUnitsOnlyByTemplate(String template) {
        template = "%" + template + "%";
        String query = "from Unit u where unitName like :value";
        //System.out.println(template);
        try {
            return getHibernateTemplate().findByNamedParam(query, "value", template);
        } catch (Exception ex) {
            return null;
        }
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
        String query = "from Unit u where unitName = :value";
        try {
            return (Unit) getHibernateTemplate().findByNamedParam(query, "value", name).get(0);
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean isUnitPresent(Unit unit) {
        try {
            unit = (Unit) getHibernateTemplate().load(Unit.class, unit.getUnitId());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isUnitPresent(String unitName) {
        String query = "from Unit u where unitName = :value";
        try {
            return !getHibernateTemplate().findByNamedParam(query, "value", unitName).isEmpty();
        } catch (Exception ex) {
            return false;
        }
    }
}
