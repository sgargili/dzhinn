/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.PcProductTypes;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author APopov
 */
public interface PcProductTypesDAO {

    public void addPcProductsToPt(PcProductTypes pcProductTypes) throws SQLException;

    public Collection getAllPcProductTypes() throws SQLException;

    public int getPcProductTypesByName(String name) throws SQLException;
}
