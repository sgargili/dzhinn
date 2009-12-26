/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import pojo.Keyprice;

/**
 *
 * @author Apopov
 */
public interface KeyPriceDAO {

    public void addKeyPrice(Keyprice keyprice) throws SQLException;

    public List getKeyPrice(int firstResult, int maxResult) throws SQLException;

    public List getKeyPrice() throws SQLException;

    public String getPriceByArticle(String article) throws SQLException;
}
