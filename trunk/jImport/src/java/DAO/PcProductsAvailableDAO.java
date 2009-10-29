/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.PcProductsAvailable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author APopov
 */
public interface PcProductsAvailableDAO {

    public List<PcProductsAvailable> getPcProductsAvailable() throws SQLException;
}
