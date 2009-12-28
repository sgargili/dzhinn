/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import pojo.Keywarranty;

/**
 *
 * @author APopov
 */
public interface KeyWarrantyDAO {

    public void addKeyWarranty(Keywarranty keywarranty) throws SQLException;

    //public List getKeyWarranty(int firstResult, int maxResult) throws SQLException;

    public List getKeyWarranty() throws SQLException;

    public String getWarrantyByArticle(String article) throws SQLException;

    public boolean isWarrantyPresent(String article) throws SQLException;
}
