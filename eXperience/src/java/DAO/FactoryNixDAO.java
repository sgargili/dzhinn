/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Impl.NixProcessDAOImpl;
import DAO.Impl.NixdataDAOImpl;
import DAO.Impl.NixlinksDAOImpl;

/**
 *
 * @author Admin4DB2
 */
public class FactoryNixDAO {

    private static NixlinksDAO nixlinksDAO = null;
    private static NixdataDAO nixdataDAO = null;
    private static NixProcessDAO nixProcessDAO = null;
    private static FactoryNixDAO instance = null;

    public static synchronized FactoryNixDAO getInstance() {
        if (instance == null) {
            instance = new FactoryNixDAO();
        }
        return instance;
    }

    public NixlinksDAO getNixlinksDAO() {
        if (nixlinksDAO == null) {
            nixlinksDAO = new NixlinksDAOImpl();
        }
        return nixlinksDAO;
    }

    public NixdataDAO getNixdataDAO() {
        if (nixdataDAO == null) {
            nixdataDAO = new NixdataDAOImpl();
        }
        return nixdataDAO;
    }

    public NixProcessDAO getNixProcessDAO() {
        if (nixProcessDAO == null) {
            nixProcessDAO = new NixProcessDAOImpl();
        }
        return nixProcessDAO;
    }
}