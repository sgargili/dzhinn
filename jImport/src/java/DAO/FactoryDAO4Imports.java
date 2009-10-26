/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Impl.CategoriesDAOImpl;
import DAO.Impl.CategoriesDescriptionDAOImpl;
import DAO.Impl.ManufacturersDAOImpl;
import DAO.Impl.ManufacturersInfoDAOImpl;
import DAO.Impl.PcManufacturePtDAOImpl;
import DAO.Impl.PcProductTypesDAOImpl;
import DAO.Impl.PcProductsToPtDAOImpl;
import DAO.Impl.PcSyncProductsDescriptionDAOImpl;
import DAO.Impl.PcSyncProductsDAOImpl;
import DAO.Impl.ProductsDAOImpl;
import DAO.Impl.ProductsImagesDAOImpl;
import DAO.Impl.ProductsToCategoriesDAOImpl;

/**
 *
 * @author Admin4DB2
 */
public class FactoryDAO4Imports {

    private static PcSyncProductsDAO pcSyncProducts = null;
    private static ProductsDAO products = null;
    private static PcSyncProductsDescriptionDAO pcSyncProductsDescriptionDAO = null;
    private static CategoriesDAO categoriesDAO = null;
    private static CategoriesDescriptionDAO categoriesDescriptionDAO = null;
    private static ProductsToCategoriesDAO productsToCategoriesDAO;
    private static PcProductTypesDAO pcProductTypesDAO;
    private static PcProductsToPtDAO pcProductsToPtDAO;
    private static PcManufacturePtDAO pcManufacturePtDAO;
    private static ManufacturersDAO manufacturersDAO;
    private static ManufacturersInfoDAO manufacturersInfoDAO;
    private static ProductsImagesDAO productsImagesDAO;
    private static FactoryDAO4Imports instance = null;

    public static PcSyncProductsDAO getPcSyncProductsDAO() {
        if (pcSyncProducts == null) {
            pcSyncProducts = new PcSyncProductsDAOImpl();
        }
        return pcSyncProducts;
    }

    public static ProductsImagesDAO getProductsImagesDAO() {
        if (productsImagesDAO == null) {
            productsImagesDAO = new ProductsImagesDAOImpl();
        }
        return productsImagesDAO;
    }

    public static PcProductTypesDAO getPcProductTypesDAO() {
        if (pcProductTypesDAO == null) {
            pcProductTypesDAO = new PcProductTypesDAOImpl();
        }
        return pcProductTypesDAO;
    }

    public static ManufacturersInfoDAO getManufacturersInfoDAO() {
        if (manufacturersInfoDAO == null) {
            manufacturersInfoDAO = new ManufacturersInfoDAOImpl();
        }
        return manufacturersInfoDAO;
    }

    public static ManufacturersDAO getManufacturersDAO() {
        if (manufacturersDAO == null) {
            manufacturersDAO = new ManufacturersDAOImpl();
        }
        return manufacturersDAO;
    }

    public static PcManufacturePtDAO getPcManufacturePtDAO() {
        if (pcManufacturePtDAO == null) {
            pcManufacturePtDAO = new PcManufacturePtDAOImpl();
        }
        return pcManufacturePtDAO;
    }

    public static PcSyncProductsDescriptionDAO getPcSyncProductsDescriptionDAO() {
        if (pcSyncProductsDescriptionDAO == null) {
            pcSyncProductsDescriptionDAO = new PcSyncProductsDescriptionDAOImpl();
        }
        return pcSyncProductsDescriptionDAO;
    }

    public static PcProductsToPtDAO getPcProductsToPtDAO() {
        if (pcProductsToPtDAO == null) {
            pcProductsToPtDAO = new PcProductsToPtDAOImpl();
        }
        return pcProductsToPtDAO;
    }

    public static ProductsDAO getProductsDAO() {
        if (products == null) {
            products = new ProductsDAOImpl();
        }
        return products;
    }

    public static ProductsToCategoriesDAO getproductsToCategoriesDAO() {
        if (productsToCategoriesDAO == null) {
            productsToCategoriesDAO = new ProductsToCategoriesDAOImpl();
        }
        return productsToCategoriesDAO;
    }

    public static synchronized FactoryDAO4Imports getInstance() {
        if (instance == null) {
            instance = new FactoryDAO4Imports();
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
