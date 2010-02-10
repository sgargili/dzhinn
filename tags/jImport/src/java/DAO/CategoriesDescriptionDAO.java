/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.CategoriesDescription;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author APopov
 */
public interface CategoriesDescriptionDAO {

    public void addCategoriesDescription(CategoriesDescription categoriesDescription) throws SQLException;

    public Collection getAllCategoriesDescription() throws SQLException;

    public CategoriesDescription getAllCategoriesDescriptionById(int id) throws SQLException;
}
