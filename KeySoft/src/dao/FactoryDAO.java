/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.impl.AttributeDAOImpl;
import dao.impl.SoftDAOImpl;

/**
 *
 * @author APopov
 */
public class FactoryDAO {

    private static SoftDAO softDAO = null;
    private static FactoryDAO instance = null;
    private static AttributeDAO attributeDAO = null;

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }

    public SoftDAO getSoftDAO() {
        if (softDAO == null) {
            softDAO = new SoftDAOImpl();
        }
        return softDAO;
    }

    public AttributeDAO getAttributeDAO() {
        if (attributeDAO == null) {
            attributeDAO = new AttributeDAOImpl();
        }
        return attributeDAO;
    }
}
