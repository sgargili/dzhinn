/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Admin4DB2
 */
import Pojo.Matching;
import java.sql.SQLException;
import java.util.Collection;

public interface MatchingDAO {

    public void addMatching(Matching matching) throws SQLException;

    public void updateMatching(Matching matching) throws SQLException;

    public Matching getMatchingById(Long Supplier_Id) throws SQLException;

    public String getDescriptionBySupplierArticleName(String SupplierArticleName) throws SQLException;

    public Collection getAllMatching() throws SQLException;

    public boolean isMatchingPresent(String Article, Long SupplierId) throws SQLException;

    public void deleteMatching(Matching matching) throws SQLException;
}
