/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.PcSyncProducts;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author APopov
 */
public interface PcSyncProductsDAO {

    public void addPcSyncProducts(PcSyncProducts pcSyncProducts) throws SQLException;

    public void updatePcSyncProducts(PcSyncProducts pcSyncProducts) throws SQLException;

    public boolean isPcSyncProductspresent(String ProductModel) throws SQLException;

    public PcSyncProducts getPcSyncProductsById(int Currency_Id) throws SQLException;

    public Collection getAllPcSyncProducts() throws SQLException;

    public long getPcSyncProductsByModel(String model) throws SQLException;

    public void deletePcSyncProducts(PcSyncProducts pcSyncProducts) throws SQLException;
}
