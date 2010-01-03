/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.impl.KeyDataDAOImpl;
import dao.impl.KeyHtmlDAOImpl;
import dao.impl.KeyMarketingDAOImpl;
import dao.impl.KeyPriceDAOImpl;
import dao.impl.KeyWarrantyDAOImpl;
import dao.impl.MatchingDAOImpl;
import dao.impl.TempPojoDAO2Impl;
import dao.impl.TempPojoDAOImpl;

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
    private KeyHtmlDAO keyHtmlDAO = null;
    private TempPojoDAO tempPojoDAO = null;
    private TempPojoDAO2 tempPojoDAO2 = null;
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

    public KeyHtmlDAO getKeyHtmlDAO() {
        if (keyHtmlDAO == null) {
            keyHtmlDAO = new KeyHtmlDAOImpl();
        }
        return keyHtmlDAO;
    }

    public TempPojoDAO getTempPojoDAO() {
        if (tempPojoDAO == null) {
            tempPojoDAO = new TempPojoDAOImpl();
        }
        return tempPojoDAO;
    }
    public TempPojoDAO2 getTempPojoDAO2() {
        if (tempPojoDAO2 == null) {
            tempPojoDAO2 = new TempPojoDAO2Impl();
        }
        return tempPojoDAO2;
    }
}
