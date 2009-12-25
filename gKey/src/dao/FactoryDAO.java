/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.impl.KeyDataDAOImpl;
import dao.impl.MatchingDAOImpl;

/**
 *
 * @author Admin4DB2
 */
public class FactoryDAO {

    private KeyDataDAO keyDataDAO = null;
    private MatchingDAO matchingDAO = null;
    private static FactoryDAO instance = null;

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }

    public KeyDataDAO getKeyDataDAO() {
        if (keyDataDAO == null) {
            keyDataDAO = new KeyDataDAOImpl();
        }
        return keyDataDAO;
    }

    public MatchingDAO getMatchingDAO() {
        if (matchingDAO == null) {
            matchingDAO = new MatchingDAOImpl();
        }
        return matchingDAO;
    }
}
