/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.ProductsImages;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author APopov
 */
public interface ProductsImagesDAO {

    public void addProductsImages(ProductsImages productsImages) throws SQLException;

    public void deleteProductsImages(ProductsImages productsImages) throws SQLException;

    public Collection getAllProductsImages() throws SQLException;

    public ProductsImages getProductsImagesById(int id) throws SQLException;
}
