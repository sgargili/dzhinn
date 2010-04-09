/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Newarticles;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author IRozhkov
 */
public interface newArticlesDAO {

    public void addnArticles(Newarticles articles) throws SQLException;

    public Collection getAllArticles() throws SQLException;
}
