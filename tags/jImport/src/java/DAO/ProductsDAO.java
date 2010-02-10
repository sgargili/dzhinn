/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Products;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author APopov
 */
public interface ProductsDAO {

    public void addProducts(Products products) throws SQLException;

    public Collection getAllProducts() throws SQLException;

    public Products getProductById(Long id) throws SQLException;
}
