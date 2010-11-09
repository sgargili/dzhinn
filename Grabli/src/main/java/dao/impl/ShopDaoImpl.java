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
import pojo.Shop;

/**
 *
 * @author PAV
 */
public class ShopDaoImpl implements ShopDao {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    @Override
    public Shop getShopById(int shopid) {
        return (Shop) getHibernateTemplate().get(Shop.class, shopid);
    }

    @Override
    public Shop getShopByName(final String shopName) {
        List result = null;
        final String request = "from Shop shop where shop.shopName = :shopName";
        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

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
