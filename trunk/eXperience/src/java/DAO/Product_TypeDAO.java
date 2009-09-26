/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Admin4DB2
 */
import Pojo.ProductType;
import java.sql.SQLException;
import java.util.Collection;

public interface Product_TypeDAO {

    public void addProduct_Type(ProductType productType) throws SQLException;

    public void updateProduct_Type(ProductType productType) throws SQLException;

    public boolean isProduct_Type_IdPresent(Long ProductType_Id) throws SQLException;

    public ProductType getProduct_TypeById(Long ProductType_Id) throws SQLException;

    public Long getIdByProduct_Type_Id(Long ProductType_Id) throws SQLException;

    public Collection getAllProduct_Types() throws SQLException;

    public void deleteProduct_Type(ProductType productType) throws SQLException;
}
