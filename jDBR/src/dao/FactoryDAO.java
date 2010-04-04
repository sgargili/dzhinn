/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.impl.ProductTypeDAOImpl;

/**
 *
 * @author Apopov
 */
public class FactoryDAO {

    private ProductTypeDAO productTypeDAO = null;
    private static FactoryDAO instance = null;

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }

    public ProductTypeDAO getProductTypeDAO() {
        if (productTypeDAO == null) {
            productTypeDAO = new ProductTypeDAOImpl();
        }
        return productTypeDAO;
    }
}
