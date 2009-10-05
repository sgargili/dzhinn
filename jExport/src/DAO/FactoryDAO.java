/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Impl.PcSyncProductsDescriptionDAOImpl;
import DAO.Impl.PcSyncProductsDAOImpl;

/**
 *
 * @author Admin4DB2
 */
public class FactoryDAO {

    private static PcSyncProductsDAO pcSyncProducts = null;
    private static PcSyncProductsDescriptionDAO pcSyncProductsDescriptionDAO = null;
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
}
