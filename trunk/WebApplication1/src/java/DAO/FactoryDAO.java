/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Impl.NixdataDAOImpl;
import DAO.Impl.NixlinksDAOImpl;
import DAO.Impl.PtDAOImpl;

/**
 *
 * @author Admin4DB2
 */
public class FactoryDAO {

    private static NixlinksDAO nixlinksDAO = null;
    private static NixdataDAO nixdataDAO = null;
    private static PtDAO ptDAO = null;
    private static FactoryDAO instance = null;

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }

    public NixlinksDAO getNixlinksDAO() {
        if (nixlinksDAO == null) {
            nixlinksDAO = new NixlinksDAOImpl();
        }
        return nixlinksDAO;
    }

    public PtDAO getPtDAO() {
        if (ptDAO == null) {
            ptDAO = new PtDAOImpl();
        }
        return ptDAO;
    }

    public NixdataDAO getNixdataDAO() {
        if (nixdataDAO == null) {
            nixdataDAO = new NixdataDAOImpl();
        }
        return nixdataDAO;
    }
}
