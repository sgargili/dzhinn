/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Pt;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author APopov
 */
public interface PtDAO {

    public void addPt(Pt pt) throws SQLException;

    public List getAllPT() throws SQLException;

    public boolean getPtByName(String name) throws SQLException;

    public Long getAllPtCount() throws SQLException;
}
