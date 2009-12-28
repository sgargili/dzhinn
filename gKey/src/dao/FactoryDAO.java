/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.impl.KeyDataDAOImpl;
import dao.impl.KeyMarketingDAOImpl;
import dao.impl.KeyPriceDAOImpl;
import dao.impl.KeyWarrantyDAOImpl;
import dao.impl.MatchingDAOImpl;

/**
 *
 * @author Admin4DB2
 */
public class FactoryDAO {

    private KeyDataDAO keyDataDAO = null;
    private MatchingDAO matchingDAO = null;
    private KeyPriceDAO keyPrice = null;
    private KeyMarketingDAO keyMatching = null;
    private KeyWarrantyDAO keyWarrantyDAO = null;
    private static FactoryDAO instance = null;

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }

    public KeyDataDAO getKeyDataDAO() {
        if (keyDataDAO == null) {
            keyDataDAO = new KeyDataDAOImpl();
        }
        return keyDataDAO;
    }

    public MatchingDAO getMatchingDAO() {
        if (matchingDAO == null) {
            matchingDAO = new MatchingDAOImpl();
        }
        return matchingDAO;
    }

    public KeyPriceDAO getKeyPriceDAO() {
        if (keyPrice == null) {
            keyPrice = new KeyPriceDAOImpl();
        }
        return keyPrice;
    }

    public KeyMarketingDAO getKeyMarketingDAO() {
        if (keyMatching == null) {
            keyMatching = new KeyMarketingDAOImpl();
        }
        return keyMatching;
    }

    public KeyWarrantyDAO getKeyWarrantyDAO() {
        if (keyWarrantyDAO == null) {
            keyWarrantyDAO = new KeyWarrantyDAOImpl();
        }
        return keyWarrantyDAO;
    }
}
