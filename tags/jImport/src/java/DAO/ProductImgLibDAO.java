/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.ProductImgLib;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author root
 */
public interface ProductImgLibDAO {

    public void addProductImgLib(ProductImgLib productImgLib) throws SQLException;

    public void deleteProductImgLib(ProductImgLib productImgLib) throws SQLException;

    public Collection getAllProductImgLib() throws SQLException;

    public Collection getProductImgLibById(Long id) throws SQLException;
}
