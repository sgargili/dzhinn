/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Supplierprice;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author Admin4DB2
 */
public interface SupplierPriceDAO {

    public void addSupplierprice(Supplierprice supplierprice) throws SQLException;

    public void updateSupplierprice(Supplierprice supplierprice) throws SQLException;

    public Long getIdBySupplierByArticle(Long Supplier_Id, String Article);

    public Supplierprice getSupplierpriceById(Long Supplierprice_Id) throws SQLException;

    public Collection getSupplierpriceByArticleBySupplier(String Article, Long Supplier_Id) throws SQLException;

    public boolean isSupplierArticlePresentbySupplier(String Article, Long Supplier_Id) throws SQLException;

    public Collection getAllSupplierprice() throws SQLException;

    public Collection getAllSupplierpriceById(Long Supplierprice_Id, String Article, int Start, int Count) throws SQLException;

    public void deleteSupplierprice(Supplierprice supplierprice) throws SQLException;
}
