/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Impl.CategoriesDAOImpl;
import DAO.Impl.CategoriesDescriptionDAOImpl;
import DAO.Impl.PcSyncProductsDescriptionDAOImpl;
import DAO.Impl.PcSyncProductsDAOImpl;

/**
 *
 * @author Admin4DB2
 */
public class FactoryDAO {

    private static PcSyncProductsDAO pcSyncProducts = null;
    private static PcSyncProductsDescriptionDAO pcSyncProductsDescriptionDAO = null;
    private static CategoriesDAO categoriesDAO = null;
    private static CategoriesDescriptionDAO categoriesDescriptionDAO = null;
    private static FactoryDAO instance = null;

    public static PcSyncProductsDAO getPcSyncProductsDAO() {
        if (pcSyncProducts == null) {
            pcSyncProducts = new PcSyncProductsDAOImpl();
        }
        return pcSyncProducts;
    }

    public static PcSyncProductsDescriptionDAO getPcSyncProductsDescriptionDAO() {
        if (pcSyncProductsDescriptionDAO == null) {
            pcSyncProductsDescriptionDAO = new PcSyncProductsDescriptionDAOImpl();
        }
        return pcSyncProductsDescriptionDAO;
    }

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }

    public static CategoriesDAO getCategoriesDAO() {
        if (categoriesDAO == null) {
            categoriesDAO = new CategoriesDAOImpl();
        }
        return categoriesDAO;
    }

    public static CategoriesDescriptionDAO getCategoriesDescriptionDAO() {
        if (categoriesDescriptionDAO == null) {
            categoriesDescriptionDAO = new CategoriesDescriptionDAOImpl();
        }
        return categoriesDescriptionDAO;
    }
}
