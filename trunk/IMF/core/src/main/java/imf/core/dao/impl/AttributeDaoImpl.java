package imf.core.dao.impl;

import java.util.List;

import imf.core.dao.AttributeDao;
import imf.core.entity.Attribute;
import imf.core.entity.Attribute2Group;
import imf.core.entity.Group;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Developed by: Andrey Popov
 * Date (time): 17.02.11 (16:13)
 */
@Repository
@Service("attributeDao")
public class AttributeDaoImpl implements AttributeDao {
    private Attribute2Group getAttribute2GroupByGroup(Group group) {
//        Attribute attribute = new Attribute();
//        attribute.setId(3l);
        Attribute2Group attribute2Group = new Attribute2Group();
        attribute2Group.setGroup(group);
//        attribute2Group.setAttribute(attribute);
        return attribute2Group;
    }

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public Attribute saveAttribute(Attribute attribute) {
        attribute.setId((Long) hibernateTemplate.save(attribute));
        return attribute;
    }

    @Override
    public void saveOrUpdateAttribute(Attribute attribute) {
        hibernateTemplate.saveOrUpdate(attribute);
    }

    @Override
    public void updateAttribute(Attribute attribute) {
        hibernateTemplate.save(attribute);
    }

    @Override
    public void deleteAttribute(Attribute attribute) {
        hibernateTemplate.delete(attribute);
    }

    @Override
    public void deleteAttributeById(Long id) {
        String deleteQuery = "delete from Attribute attribute where attribute.id = :id";
        Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(deleteQuery);
        query.setLong("id", id);
        query.executeUpdate();
    }

    @Override
    public List<Attribute> getAllAttributes() {
        return hibernateTemplate.loadAll(Attribute.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Attribute> getAttributes(int firstResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Attribute.class);
        criteria.setFirstResult(firstResult);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Attribute> getAttributes(int firstResult, int maxResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Attribute.class);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResult);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Attribute> getAllAttributesByGroup(Group group) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Attribute.class);
        criteria.setFetchMode("subsGroup", FetchMode.JOIN);
        criteria.setFetchMode("subsGroup.substitutes", FetchMode.JOIN);
        criteria.setFetchMode("unitOfMeasure", FetchMode.JOIN);
        criteria.setFetchMode("unitsGroup", FetchMode.JOIN);
        criteria.setFetchMode("attribute2Groups", FetchMode.JOIN);
        criteria.setFetchMode("attribute2Groups.group", FetchMode.JOIN);
//        criteria.setFlushMode(FlushMode.COMMIT);
        criteria.createAlias("attribute2Groups", "a2g");
        criteria.add(Restrictions.eq("a2g.group",group));
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Attribute> getAttributesByGroup(Group group, int firstResult) {
        /* Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Attribute.class);
       criteria.setFirstResult(firstResult);
       //TODO Переделать бы, а то не очень абстрактно все это...
       criteria.add(Restrictions.eq("group", group));
       return criteria.list();*/
        String selectQuery = "from Attribute atr join fetch atr.attribute2Groups a2g join fetch a2g.group  where a2g.group = :group";
        Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(selectQuery);
        query.setParameter("group", group);
        query.setFirstResult(firstResult);
        return query.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Attribute> getAttributesByGroup(Group group, int firstResult, int maxResult) {
        /*Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Attribute.class);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResult);
        //TODO Переделать бы, а то не очень абстрактно все это...
        criteria.add(Restrictions.eq("group", group));
        return criteria.list();*/
        String selectQuery = "from Attribute atr join fetch atr.attribute2Groups a2g join fetch a2g.group  where a2g.group = :group";
        Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(selectQuery);
        query.setParameter("group", group);
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        return query.list();
    }

    @Override
    public Attribute getAttributeById(Long id) {
        return hibernateTemplate.get(Attribute.class, id);
    }

    @Override
    public Long getTotalRows() {
        return null;
    }

    @Override
    public Long getTotalRowsByGroupId(Long id) {
        return null;
    }
}
