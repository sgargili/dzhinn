/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Articles;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author Admin4DB2
 */
public interface ArticlesDAO {

    public void addArticles(Articles articles) throws SQLException;

    public Collection getAllArticles() throws SQLException;

    public String getArticleById(long id) throws SQLException;

    public long getIdByArticle(String article) throws SQLException;

    public boolean isArticlePresent(String article) throws SQLException;
}
