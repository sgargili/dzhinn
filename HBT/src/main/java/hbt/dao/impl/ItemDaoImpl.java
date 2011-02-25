package hbt.dao.impl;

import java.util.List;

import hbt.dao.ItemDao;
import hbt.model.Attribute;
import hbt.model.Item;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Developed by: Andrey Popov
 * Date (time): 25.02.11 (16:54)
 */
@Repository
@Service("itemDao")
public class ItemDaoImpl implements ItemDao {
    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public Item getItemById(Integer id) {
        return hibernateTemplate.get(Item.class, id);
    }
    @Transactional
    public List<Item> getItemsByProductId(Integer id) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Item.class);
        criteria.createAlias("productItems","productItem");
        criteria.add(Restrictions.eq("productItem.pk.product.id", id));
        List<Item> list = criteria.list();
        return list;
    }
}
