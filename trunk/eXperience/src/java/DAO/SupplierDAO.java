/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Supplier;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author Admin4DB2
 */
public interface SupplierDAO {

    public void addSupplier(Supplier supplier) throws SQLException;

    public void updateSupplier(Supplier supplier) throws SQLException;

    public String getSupplierById(Long Supplier_Id) throws SQLException;

    public Long getSupplierIdByArticle(String Article) throws SQLException;

    public Long getIdBySupplier(String Supplier_Name) throws SQLException;

    public Collection getAllSuppliers() throws SQLException;

    public void deleteSupplier(Supplier supplier) throws SQLException;
}
