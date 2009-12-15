/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Impl.ArticlesDAOImpl;
import DAO.Impl.It4articlesDAOImpl;
import DAO.Impl.RivalsDAOImpl;
import DAO.Impl.RivalsdataDAOImpl;

/**
 *
 * @author Admin4DB2
 */
public class FactoryDAO {

    private ArticlesDAO articlesDAO = null;
    private RivalsDAO rivalsDAO = null;
    private RivalsdataDAO rivalsDataDAO = null;
    private It4articlesDAO it4articlesDAO = null;
    private static FactoryDAO instance = null;

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }

    public ArticlesDAO getArticlesDAO() {
        if (articlesDAO == null) {
            articlesDAO = new ArticlesDAOImpl();
        }
        return articlesDAO;
    }

    public RivalsdataDAO getRivalsDataDAO() {
        if (rivalsDataDAO == null) {
            rivalsDataDAO = new RivalsdataDAOImpl();
        }
        return rivalsDataDAO;
    }

    public RivalsDAO getRivalsDAO() {
        if (rivalsDAO == null) {
            rivalsDAO = new RivalsDAOImpl();
        }
        return rivalsDAO;
    }

    public It4articlesDAO getIt4articlesDAO() {
        if (it4articlesDAO == null) {
            it4articlesDAO = new It4articlesDAOImpl();
        }
        return it4articlesDAO;
    }
}
