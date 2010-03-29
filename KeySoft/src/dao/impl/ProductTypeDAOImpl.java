/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ProductTypeDAO;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.ProductType;

/**
 *
 * @author APopov
 */
public class ProductTypeDAOImpl implements ProductTypeDAO {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public List<ProductType> getAllProductTypes() {
        return (List<ProductType>) hibernateTemplate.loadAll(ProductType.class);
    }
}
