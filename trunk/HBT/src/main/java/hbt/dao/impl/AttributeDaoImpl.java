package hbt.dao.impl;

import java.util.List;

import hbt.dao.AttributeDao;
import hbt.model.Attribute;
import hbt.model.Group;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
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

    public List<Attribute> getAttributes() {
        return hibernateTemplate.loadAll(Attribute.class);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Attribute> getAllAttributesByGroup(Group group) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Group.class);

        /*criteria.setFetchMode("attribute2Groups", FetchMode.JOIN); */
        criteria.createAlias("attribute2Groups", "a2g");
        criteria.add(Restrictions.eq("a2g.group", group));
        List<Attribute> list = criteria.list();
        return list;
    }
}
