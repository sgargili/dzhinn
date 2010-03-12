/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.Impl.BankDAOImpl;

/**
 *
 * @author APopov
 */
public class FactoryDAO {

    private static BankDAO bankDAO = null;
    private static FactoryDAO instance = null;

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }

    public BankDAO getBankDAO() {
        if (bankDAO == null) {
            bankDAO = new BankDAOImpl();
        }
        return bankDAO;
    }
}
