/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import pojo.Matching;

/**
 *
 * @author APopov
 */
public interface MatchingDAO {

    public void addMatching(Matching matching) throws SQLException;

    public List getAllMatching() throws SQLException;

    public int getMatchingIdByArticle(String article) throws SQLException;
}
