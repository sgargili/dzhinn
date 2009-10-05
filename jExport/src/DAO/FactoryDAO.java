/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Impl.PcSyncProductsDescriptionImpl;
import DAO.Impl.Pc_sync_productsDAOImpl;

/**
 *
 * @author Admin4DB2
 */
public class FactoryDAO {

    private static Pc_sync_productsDAO pcSyncProducts = null;
    private static PcSyncProductsDescriptionDAO pcSyncProductsDescriptionDAO = null;
    private static FactoryDAO instance = null;

    public static Pc_sync_productsDAO getPcSyncProductsDAO() {
        if (pcSyncProducts == null) {
            pcSyncProducts = new Pc_sync_productsDAOImpl();
        }
        return pcSyncProducts;
    }

    public static PcSyncProductsDescriptionDAO getPcSyncProductsDescriptionDAO() {
        if (pcSyncProductsDescriptionDAO == null) {
            pcSyncProductsDescriptionDAO = new PcSyncProductsDescriptionImpl();
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
