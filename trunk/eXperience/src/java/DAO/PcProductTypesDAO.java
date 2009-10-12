/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author APopov
 */
public interface PcProductTypesDAO {

    public Collection getAllPcProductTypes() throws SQLException;
}
