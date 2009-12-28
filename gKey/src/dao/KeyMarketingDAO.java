/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import pojo.Keymarketing;

/**
 *
 * @author Apopov
 */
public interface KeyMarketingDAO {

    public void addKeyMarketing(Keymarketing keymarketing) throws SQLException;

    public List getAllKeydata(int firstResult, int maxResult) throws SQLException;

    public List getAllKeydata() throws SQLException;

    public String getMarketingByArticle(String article) throws SQLException;

    public boolean isMarketingPresent(String article) throws SQLException;
}
