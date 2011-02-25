package hbt.dao.impl;

import java.util.List;

import hbt.dao.AttributeDao;
import hbt.model.Attribute;
import hbt.model.Group;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Developed by: Andrey Popov
 * Date (time): 24.02.11 (17:38)
 */
@Repository
@Service("attributeDao")
public class AttributeDaoImpl implements AttributeDao {
    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public Attribute getAttributeById(Long id) {
        return hibernateTemplate.get(Attribute.class, id);
    }

    public List<Attribute> getAttributes() {
        return hibernateTemplate.loadAll(Attribute.class);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Attribute> getAllAttributesByGroup(Group group) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Attribute.class);
//        criteria.setFetchMode("attribute2Group", FetchMode.JOIN);
        criteria.createCriteria("attribute2Group");
//        criteria.createAlias("group", "group");
        criteria.add(Restrictions.eq("attribute2Group.group.id", group.getId()));

        criteria.createCriteria("groups");
//        criteria.createAlias("groups", "group");
        criteria.add(Restrictions.eq("id", group.getId()));

        List<Attribute> list = criteria.list();
        return list;
    }
}
