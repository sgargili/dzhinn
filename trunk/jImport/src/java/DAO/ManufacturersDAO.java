/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Manufacturers;
import java.sql.SQLException;

/**
 *
 * @author APopov
 */
public interface ManufacturersDAO {

    public void addManufacturers(Manufacturers manufacturers) throws SQLException;
}
