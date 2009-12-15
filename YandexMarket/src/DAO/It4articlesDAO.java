/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.It4articles;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author APopov
 */
public interface It4articlesDAO {

    public void addIt4articles(It4articles it4articles) throws SQLException;

    public Collection getAllIt4articles() throws SQLException;

    public String getIt4articleById(long id) throws SQLException;

    public long getIdByIt4article(String it4article) throws SQLException;

    public boolean isIt4articlePresent(String it4article) throws SQLException;
}
