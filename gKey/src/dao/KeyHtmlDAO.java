/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import pojo.Keyhtml;

/**
 *
 * @author APopov
 */
public interface KeyHtmlDAO {

    public void addKeyHtml(Keyhtml keyhtml) throws SQLException;

    public List getAllKeyHtml(int firstResult, int maxResult) throws SQLException;

    public List getAllKeyHtml() throws SQLException;

    public String getHtmlByArticle(String article) throws SQLException;

    public boolean isHtmlPresent(String article) throws SQLException;
}
