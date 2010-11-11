/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ShopDao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pojo.Shop;

/**
 * @author PAV
 */
@Repository
@Service("shopDao")
public class ShopDaoImpl implements ShopDao {

    private HibernateTemplate hibernateTemplate;

        public void setSessionFactory(SessionFactory sessionFactory) {
            this.hibernateTemplate = new HibernateTemplate(sessionFactory);
        }
    

    @Override
    public Shop getShopById(int shopid) {
        return (Shop) hibernateTemplate.get(Shop.class, shopid);
    }

    @Override
    public Shop getShopByName(final String shopName) {
        List result = null;
        final String request = "from Shop shop where shop.shopName = :shopName";
        result = (List) hibernateTemplate.execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setString("shopName", shopName);
                return query.list();
            }
        });
        if (!result.isEmpty()) {
            return (Shop) result.get(0);
        } else {
            return null;
        }
    }
}
