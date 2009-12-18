/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Matching;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author APopov
 */
public interface MatchingDAO {

    public void addMatching(Matching matching) throws SQLException;
    //public void fillArticles(String fileName) throws SQLException;

    public Collection getAllMatching() throws SQLException;
    //public String getArticleById(long id) throws SQLException;
    //public String getDescriptionByArticle(String article) throws SQLException;
    //public long getIdByArticle(String article) throws SQLException;
    //public boolean isArticlePresent(String article) throws SQLException;
}
