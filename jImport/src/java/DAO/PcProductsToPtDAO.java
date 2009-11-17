/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.PcProductsToPt;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author APopov
 */
public interface PcProductsToPtDAO {

    public void addPcProductsToPt(PcProductsToPt pcProductsToPt) throws SQLException;

    public Collection getAllPcProductsToPt() throws SQLException;
}
