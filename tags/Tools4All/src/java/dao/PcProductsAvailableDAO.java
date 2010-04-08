/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.PcProductsAvailable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author APopov
 */
public interface PcProductsAvailableDAO {

    public List<PcProductsAvailable> getPcProductsAvailable() throws SQLException;
}
