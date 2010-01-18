/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.impl.NixOutputDataDAOImpl;
import dao.impl.NixInputDataDAOImpl;

/**
 *
 * @author APopov
 */
public class FactoryDAO {

    private NixOutputDataDAO nixDataDAO = null;
    private NixInputDataDAO nixLinksDAO = null;
    private static FactoryDAO instance = null;

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }

    public NixOutputDataDAO getNixOutputDataDAO() {
        if (nixDataDAO == null) {
            nixDataDAO = new NixOutputDataDAOImpl();
        }
        return nixDataDAO;
    }

    public NixInputDataDAO getNixInputDataDAO() {
        if (nixLinksDAO == null) {
            nixLinksDAO = new NixInputDataDAOImpl();
        }
        return nixLinksDAO;
    }
}
