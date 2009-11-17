/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.PcSyncIds;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author root
 */
public interface PcSyncIdsDAO {

    public void addPcSyncIds(PcSyncIds pcSyncIds) throws SQLException;

    //public void updatePcSyncProducts(PcSyncProducts pcSyncProducts) throws SQLException;
    //public boolean isPcSyncProductspresent(String ProductModel) throws SQLException;
    public PcSyncIds getPcSyncIdsByIt4Pid(long it4Pid) throws SQLException;

    public Collection getAllPcSyncIds() throws SQLException;

    public long getShopPidByIt4Pid(long it4Pid) throws SQLException;
    public long getIt4PidByShopPid(long shopPid) throws SQLException;
    //public long getPcSyncProductsByModel(String model) throws SQLException;
    // public void deletePcSyncProducts(PcSyncProducts pcSyncProducts) throws SQLException;
}
