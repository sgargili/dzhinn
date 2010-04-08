/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.impl.CategoriesDAOImpl;
import dao.impl.CategoriesDescriptionDAOImpl;
import dao.impl.ManufacturersDAOImpl;
import dao.impl.ManufacturersInfoDAOImpl;
import dao.impl.PcManufacturePtDAOImpl;
import dao.impl.PcProductTypesDAOImpl;
import dao.impl.PcProductsAvailableDAOImpl;
import dao.impl.PcProductsToPtDAOImpl;
import dao.impl.PcSyncIdsDAOImpl;
import dao.impl.PcSyncProductsDescriptionDAOImpl;
import dao.impl.PcSyncProductsDAOImpl;
import dao.impl.ProductImgLibDAOImpl;
import dao.impl.ProductsDAOImpl;
import dao.impl.ProductsImagesDAOImpl;
import dao.impl.ProductsToCategoriesDAOImpl;

/**
 * 
 * @author Admin4DB2
 */
public class FactoryDAO4Imports {

    private PcSyncProductsDAO pcSyncProducts = null;
    private ProductsDAO products = null;
    private PcSyncProductsDescriptionDAO pcSyncProductsDescriptionDAO = null;
    private CategoriesDAO categoriesDAO = null;
    private CategoriesDescriptionDAO categoriesDescriptionDAO = null;
    private ProductsToCategoriesDAO productsToCategoriesDAO;
    private PcProductTypesDAO pcProductTypesDAO;
    private PcProductsToPtDAO pcProductsToPtDAO;
    private PcManufacturePtDAO pcManufacturePtDAO;
    private ManufacturersDAO manufacturersDAO;
    private ManufacturersInfoDAO manufacturersInfoDAO;
    private ProductImgLibDAO productImgLibDAO;
    private ProductsImagesDAO productsImagesDAO;
    private static FactoryDAO4Imports instance = null;
    private PcProductsAvailableDAO pcProductsAvailableDAO;
    private PcSyncIdsDAO pcSyncIdsDAO;

    public PcSyncProductsDAO getPcSyncProductsDAO() {
        if (pcSyncProducts == null) {
            pcSyncProducts = new PcSyncProductsDAOImpl();
        }
        return pcSyncProducts;
    }
    public PcSyncIdsDAO getPcSyncIdsDAO() {
        if (pcSyncIdsDAO == null) {
            pcSyncIdsDAO = new PcSyncIdsDAOImpl();
        }
        return pcSyncIdsDAO;
    }

    public ProductsImagesDAO getProductsImagesDAO() {
        if (productsImagesDAO == null) {
            productsImagesDAO = new ProductsImagesDAOImpl();
        }
        return productsImagesDAO;
    }

    public PcProductsAvailableDAO getPcProductsAvailableDAO() {
        if (pcProductsAvailableDAO == null) {
            pcProductsAvailableDAO = new PcProductsAvailableDAOImpl();
        }
        return pcProductsAvailableDAO;
    }

    public ProductImgLibDAO getProductImgLibDAO() {
        if (productImgLibDAO == null) {
            productImgLibDAO = new ProductImgLibDAOImpl();
        }
        return productImgLibDAO;
    }

    public PcProductTypesDAO getPcProductTypesDAO() {
        if (pcProductTypesDAO == null) {
            pcProductTypesDAO = new PcProductTypesDAOImpl();
        }
        return pcProductTypesDAO;
    }

    public ManufacturersInfoDAO getManufacturersInfoDAO() {
        if (manufacturersInfoDAO == null) {
            manufacturersInfoDAO = new ManufacturersInfoDAOImpl();
        }
        return manufacturersInfoDAO;
    }

    public ManufacturersDAO getManufacturersDAO() {
        if (manufacturersDAO == null) {
            manufacturersDAO = new ManufacturersDAOImpl();
        }
        return manufacturersDAO;
    }

    public PcManufacturePtDAO getPcManufacturePtDAO() {
        if (pcManufacturePtDAO == null) {
            pcManufacturePtDAO = new PcManufacturePtDAOImpl();
        }
        return pcManufacturePtDAO;
    }

    public PcSyncProductsDescriptionDAO getPcSyncProductsDescriptionDAO() {
        if (pcSyncProductsDescriptionDAO == null) {
            pcSyncProductsDescriptionDAO = new PcSyncProductsDescriptionDAOImpl();
        }
        return pcSyncProductsDescriptionDAO;
    }

    public PcProductsToPtDAO getPcProductsToPtDAO() {
        if (pcProductsToPtDAO == null) {
            pcProductsToPtDAO = new PcProductsToPtDAOImpl();
        }
        return pcProductsToPtDAO;
    }

    public ProductsDAO getProductsDAO() {
        if (products == null) {
            products = new ProductsDAOImpl();
        }
        return products;
    }

    public ProductsToCategoriesDAO getproductsToCategoriesDAO() {
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

    public CategoriesDAO getCategoriesDAO() {
        if (categoriesDAO == null) {
            categoriesDAO = new CategoriesDAOImpl();
        }
        return categoriesDAO;
    }

    public CategoriesDescriptionDAO getCategoriesDescriptionDAO() {
        if (categoriesDescriptionDAO == null) {
            categoriesDescriptionDAO = new CategoriesDescriptionDAOImpl();
        }
        return categoriesDescriptionDAO;
    }
}
 