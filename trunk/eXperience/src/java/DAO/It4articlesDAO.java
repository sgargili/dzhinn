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

    public void updateIt4articles(It4articles it4articles) throws SQLException;

    public It4articles getIt4articlesById(Long Article_Id) throws SQLException;

    public String getDescriptionByIt4articleName(String It4articleName) throws SQLException;

    public Collection getAllIt4articles() throws SQLException;

    public boolean isIt4articlePresent(String Article) throws SQLException;

    public void deleteMatching(It4articles it4articles) throws SQLException;
}
