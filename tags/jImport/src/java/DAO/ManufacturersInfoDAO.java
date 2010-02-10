/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.ManufacturersInfo;
import java.sql.SQLException;

/**
 *
 * @author APopov
 */
public interface ManufacturersInfoDAO {

    public void addManufacturersInfo(ManufacturersInfo manufacturersInfo) throws SQLException;
}
