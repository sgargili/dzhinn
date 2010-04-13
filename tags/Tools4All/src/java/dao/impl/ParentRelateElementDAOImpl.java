/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ParentRelateElementDAO;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.ParentRelateElement;

/**
 *
 * @author APopov
 */
public class ParentRelateElementDAOImpl implements ParentRelateElementDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public void addParentRelateElement(ParentRelateElement prElement) {
        getHibernateTemplate().saveOrUpdate(prElement);
    }

    public void updateParentRelateElement(ParentRelateElement prElement) {
        getHibernateTemplate().update(prElement);
    }

    public void deleteParentRelateElement(ParentRelateElement prElement) {
        getHibernateTemplate().delete(prElement);

    }

    public List<ParentRelateElement> getAllParentRelateElements() {
        return (List<ParentRelateElement>) getHibernateTemplate().loadAll(ParentRelateElement.class);
    }

    public List<ParentRelateElement> getAllParentRelateElementsByType(Byte type) {
        String query = "from ParentRelateElement p where parentRelateElementType = :type";
        try {
            return (List<ParentRelateElement>) getHibernateTemplate().findByNamedParam(query, "type", type);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<ParentRelateElement> getAllParentRelateElementsByType(String type) {
        byte b = 1;
        if (type.equals("Parent")) {
            b = 0;
        }
        String query = "from ParentRelateElement p where parentRelateElementType = :type";
        try {
            return (List<ParentRelateElement>) getHibernateTemplate().findByNamedParam(query, "type", b);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
