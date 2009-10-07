/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.PcSyncProductsDescription;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author APopov
 */
public interface PcSyncProductsDescriptionDAO {

    public void addPcSyncProductsDescription(PcSyncProductsDescription pcSyncProductsDescription) throws SQLException;

    public Collection getPcSyncProductsDescription() throws SQLException;

}
