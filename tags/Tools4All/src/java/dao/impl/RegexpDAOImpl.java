/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.RegexpDAO;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.Attribute;
import pojo.Regexp;

/**
 *
 * @author APOPOV
 */
public class RegexpDAOImpl implements RegexpDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public void addRegexp(Regexp regexp) {
        getHibernateTemplate().saveOrUpdate(regexp);
    }

    public void deleteRegexp(Regexp regexp) {
        getHibernateTemplate().delete(regexp);
    }

    public void deleteRegexpByAttribute(final Attribute attribute) {
        final String request = "delete from Regexp reg where reg.attribute = :attribute";
        getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setParameter("attribute", attribute);
                return query.executeUpdate();
            }
        });
    }

    public boolean isRegexpPresent(Regexp regexp) {
        try {
            regexp = (Regexp) getHibernateTemplate().load(Regexp.class, regexp.getRegexpId());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isRegexpPresent(String regexpValue) {
        String query = "from Regexp reg where reg.regexpPattern = :value";
        try {
            return !getHibernateTemplate().findByNamedParam(query, "value", regexpValue).isEmpty();
        } catch (Exception ex) {
            return false;
        }
    }

    public List<Regexp> getRegexpsByAttribute(Attribute attribute) {
        String query = "from Regexp reg " +//
                "join fetch reg.attribute as attribute " + //
                "where attribute = :attribute ";  //
//                "order by a.attributeName";
        return getHibernateTemplate().findByNamedParam(query, "attribute", attribute);
    }

    public Regexp getRegexpById(int regexpId) {
        return (Regexp) getHibernateTemplate().get(Regexp.class, regexpId);
    }

    public List getRegexpsByAttributeByGroupeByNativeSQL(final int attributeId, final int groupeId) {
        List result = null;
        final String request =
                "select "
                + "    reg.regexp_id, "
                + "    reg.regexp_type, "
                + "    reg.regexp_pattern, "
                + "    reg.regexp_replacement "
                + "from  "
                + "    `regexp` as reg "
                + "where "
                + "    reg.attribute_id = :attributeId "
                + "    and reg.groupe_id = :groupeId";

        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                query.setInteger("attributeId", attributeId);
                query.setInteger("groupeId", groupeId);
                return query.list();
            }
        });
        return result;
    }
}
