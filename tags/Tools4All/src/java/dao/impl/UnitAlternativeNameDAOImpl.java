/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.UnitAlternativeNameDAO;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.Unit;
import pojo.UnitAlternativeName;

/**
 *
 * @author Apopov
 */
public class UnitAlternativeNameDAOImpl implements UnitAlternativeNameDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public void addUnitAlternativeName(UnitAlternativeName unitAlternativeName) {
        if (!isUnitAlternativeNamePresent(unitAlternativeName.getUnitAlernativeNameValue())) {
            getHibernateTemplate().save(unitAlternativeName);
        }
    }

    public void deleteUnitAlternativeName(UnitAlternativeName unitAlternativeName) {
        getHibernateTemplate().delete(unitAlternativeName);
    }

    public void deleteUnitAlternativeNameByUnit(final Unit unit) {
        final String request = "delete from UnitAlternativeName alt where alt.unit = :unit";
        getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setParameter("unit", unit);
                return query.executeUpdate();
            }
        });
    }

    public boolean isUnitAlternativeNamePresent(UnitAlternativeName unitAlternativeName) {
        try {
            unitAlternativeName = (UnitAlternativeName) getHibernateTemplate().load(UnitAlternativeName.class, unitAlternativeName.getUnitAlernativeNameId());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isUnitAlternativeNamePresent(String unitAlternativeNameValue) {
        String query = "from UnitAlternativeName u where unitAlernativeNameValue = :value";
        try {
            return !getHibernateTemplate().findByNamedParam(query, "value", unitAlternativeNameValue).isEmpty();
        } catch (Exception ex) {
            return false;
        }
    }
}
