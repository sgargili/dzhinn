/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Impl.CookiesDAOImpl;

/**
 *
 * @author APopov
 */
public class FactoryDAO {

    private CookiesDAO cookiesDAO = null;
    private static FactoryDAO instance = null;

    public CookiesDAO getCookiesDAO() {
        if (cookiesDAO == null) {
            cookiesDAO = new CookiesDAOImpl();
        }
        return cookiesDAO;
    }

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }
}
