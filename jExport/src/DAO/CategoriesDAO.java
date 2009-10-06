/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Categories;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author APopov
 */
public interface CategoriesDAO {

    public void addCategories(Categories categories) throws SQLException;

    public Collection getAllCategories() throws SQLException;
}
