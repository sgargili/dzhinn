/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.ProductsToCategories;
import java.sql.SQLException;

/**
 *
 * @author APopov
 */
public interface ProductsToCategoriesDAO {

    public void addProductsToCategories(ProductsToCategories productsToCategories) throws SQLException;
}
