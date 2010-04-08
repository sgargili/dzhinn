/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.PcManufacturePt;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author APopov
 */
public interface PcManufacturePtDAO {

    public void addPcManufacturePt(PcManufacturePt pcManufacturePt) throws SQLException;

    public Collection getAllPcManufacturePt() throws SQLException;

    public boolean isPcManufacturePtPresent(int manId, int PtId) throws SQLException;
}
