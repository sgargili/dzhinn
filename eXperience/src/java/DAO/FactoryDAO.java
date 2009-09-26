/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Impl.CurrencyDAOImpl;
import DAO.Impl.ManufacturerDAOImpl;
import DAO.Impl.MatchingDAOImpl;
import DAO.Impl.Product_TypeDAOImpl;
import DAO.Impl.SupplierDAOImpl;
import DAO.Impl.SupplierPriceDAOImpl;

/**
 *
 * @author Admin4DB2
 */
public class FactoryDAO {

    private static ManufacturerDAO manufacturerDAO = null;
    private static SupplierDAO supplierDAO = null;
    private static SupplierPriceDAO supplierPriceDAO = null;
    private static MatchingDAO matchingDAO = null;
    private static Product_TypeDAO product_TypeDAO = null;
    private static CurrencyDAO currencyDAO = null;
    private static FactoryDAO instance = null;

    public static CurrencyDAO getCurrencyDAO() {
         if (currencyDAO == null) {
            currencyDAO = new CurrencyDAOImpl();
        }
        return currencyDAO;
    }

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }

    public static Product_TypeDAO getProduct_TypeDAO() {
        if (product_TypeDAO == null) {
            product_TypeDAO = new Product_TypeDAOImpl();
        }
        return product_TypeDAO;
    }

    public ManufacturerDAO getManufacturerDAO() {
        if (manufacturerDAO == null) {
            manufacturerDAO = new ManufacturerDAOImpl();
        }
        return manufacturerDAO;
    }

    public SupplierDAO getSupplierDAO() {
        if (supplierDAO == null) {
            supplierDAO = new SupplierDAOImpl();
        }
        return supplierDAO;
    }

    public SupplierPriceDAO getSupplierPriceDAO() {
        if (supplierPriceDAO == null) {
            supplierPriceDAO = new SupplierPriceDAOImpl();
        }
        return supplierPriceDAO;
    }

    public MatchingDAO getMatchingDAO() {
        if (matchingDAO == null) {
            matchingDAO = new MatchingDAOImpl();
        }
        return matchingDAO;
    }
}
