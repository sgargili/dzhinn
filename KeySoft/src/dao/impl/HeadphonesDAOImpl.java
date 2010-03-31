/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.HeadphonesDAO;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.Headphones;

/**
 *
 * @author IRozhkov
 */
public class HeadphonesDAOImpl implements HeadphonesDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public void addHeadphones(Headphones headphones) {
        getHibernateTemplate().save(headphones);
        getHibernateTemplate().flush();
    }

    public List getAllHeadphones() {
        return (List<Headphones>) getHibernateTemplate().loadAll(Headphones.class);
    }

    public Headphones getHeadphonesById(int id) {
        return (Headphones) getHibernateTemplate().load(Headphones.class, id);
    }
}
