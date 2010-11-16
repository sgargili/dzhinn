/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GroupeDAO;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.Attribute;
import pojo.Groupe;
import pojo.ProductType;

/**
 *
 * @author APopov
 */
public class GroupeDAOImpl implements GroupeDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public void addGroupe(Groupe groupe) {
        getHibernateTemplate().saveOrUpdate(groupe);
    }

    public void addOrUpdateGroupeNameOnly(Groupe groupe) {
//        try {
//            Groupe newGroupe;
//            newGroupe = getGroupeByName(groupe.getGroupeName());
//            getHibernateTemplate().update(newGroupe);
//        } catch (Exception ex) {
        getHibernateTemplate().save(groupe);
//        }
    }

    public void deleteGroupe(Groupe groupe) {
        getHibernateTemplate().delete(groupe);
    }

    public List<Groupe> getAllGroupesOnly() {
        return (List<Groupe>) getHibernateTemplate().loadAll(Groupe.class);
    }

    public List<Groupe> getGroupesOnlyByProductType(ProductType productType) {
        String query = "from Groupe g " +//
                "join fetch g.productTypes as productType " + //
                "where productType = :productType " + //
                "order by g.groupeName";
        return getHibernateTemplate().findByNamedParam(query, "productType", productType);
    }

    public List<Groupe> getGroupesByProductType(ProductType productType) {
        List<Groupe> gps;
        Groupe gp;
        Attribute atr;
        String query = "from Groupe g " +//
                "join fetch g.productTypes as productType " + //
                "where productType = :productType " + //
                "order by g.groupeName";
        gps = getHibernateTemplate().findByNamedParam(query, "productType", productType);
        Iterator it = gps.iterator();
        Iterator iter;
        while (it.hasNext()) {
            gp = (Groupe) it.next();
            //gp.getAttributes().isEmpty();
            iter = gp.getAttributes().iterator();
            while (iter.hasNext()) {
                atr = (Attribute) iter.next();
                atr.getAttributeAlternativeNames().isEmpty();
            }
        }
        return gps;
    }

    public List<Groupe> getGroupesOnlyByProductTypeId(int id) {
        ProductType productType = new ProductType();
        productType.setProductTypeId(id);
        String query = "from Groupe g " +//
                "join fetch g.productTypes as productType " + //
                "where productType = :productType " + //
                "order by g.groupeName";
        List<Groupe> outList = getHibernateTemplate().findByNamedParam(query, "productType", productType);
        productType = null;
        return outList;
    }

    public List<Groupe> getGroupesOnlyByAttribute(Attribute attribute) {
        String query = "from Groupe g " +//
                "join fetch g.attributes as attribute " + //
                "where attribute = :attribute " + //
                "order by g.groupeName";
        return getHibernateTemplate().findByNamedParam(query, "attributes", attribute);
    }

    public List<Groupe> getGroupesOnlyByTemplate(String template) {
        template = "%" + template + "%";
        String query = "from Groupe p where groupeName like :value order by groupeName";
        try {
            return getHibernateTemplate().findByNamedParam(query, "value", template);
        } catch (Exception ex) {
            return null;
        }
    }

    public Groupe getGroupeById(int id) {
        Groupe groupe;
        String query = "from Groupe a where groupeId = :value";
        try {
            groupe = (Groupe) getHibernateTemplate().findByNamedParam(query, "value", id).get(0);
            groupe.getAttributes().isEmpty();
            groupe.getProductTypes().isEmpty();
            return groupe;
        } catch (Exception ex) {
            return null;
        }
    }

    public Groupe getGroupeByName(String name) {
        String query = "from Groupe a where groupeName = :value";
        Groupe groupe;
        try {
            groupe = (Groupe) getHibernateTemplate().findByNamedParam(query, "value", name).get(0);
            groupe.getAttributes().isEmpty();
            groupe.getProductTypes().isEmpty();
            return groupe;

        } catch (Exception ex) {
            return null;
        }
    }

    public boolean isGroupePresent(Groupe groupe) {
        try {
            groupe = (Groupe) getHibernateTemplate().load(Attribute.class, groupe.getGroupeId());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isGroupePresent(String groupeName) {
        String query = "from Groupe a where groupeName = :value";
        try {
            return !getHibernateTemplate().findByNamedParam(query, "value", groupeName).isEmpty();
        } catch (Exception ex) {
            return false;
        }
    }

    public Groupe getGroupeByIdWithAttributes(int id) {
        Groupe groupe;
        groupe = (Groupe) getHibernateTemplate().load(Groupe.class, id);
        groupe.getAttributes().isEmpty();
        return groupe;
    }

    public List getGroupesWithAttributesByNativeSQL() {
        List result = null;
        final String request =
                "select "
                + "    groupe.groupe_name, "
                + "    atr.attribute_name "
                + "from "
                + "    groupe as groupe "
                + "inner join "
                + "    attribute as atr "
                + "inner join "
                + "    groupe2atr as g2a "
                + "on "
                + "    groupe.groupe_id = g2a.groupe_id "
                + "    and "
                + "    atr.attribute_id = g2a.attribute_id "
                + "order by "
                + "    groupe.groupe_name";

        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                return query.list();
            }
        });
        return result;
    }

    @Override
    public void updateGroupeCommentByNativeSQL(final int id, final String comment) {
        final String request =
                "update "
                + "    groupe as gp "
                + "set "
                + "    gp.groupe_comment = :value "
                + "where "
                + "gp.groupe_id = :id";

        getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                query.setString("value", comment);
                query.setInteger("id", id);
                return query.executeUpdate();
            }
        });
    }
}
