/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Impl.KeyFromXmlDAOImpl;
import DAO.Impl.ArticlesDAOImpl;
import DAO.Impl.It4articlesDAOImpl;
import DAO.Impl.MarkFromXmlDAOImpl;
import DAO.Impl.MatchingDAOImpl;
import DAO.Impl.RivalsDAOImpl;
import DAO.Impl.RivalsdataDAOImpl;
import DAO.Impl.newArticlesDAOImpl;

/**
 *
 * @author Admin4DB2
 */
public class FactoryDAO {

    private ArticlesDAO articlesDAO = null;
    private newArticlesDAO newarticlesDAO = null;
    private RivalsDAO rivalsDAO = null;
    private RivalsdataDAO rivalsDataDAO = null;
    private It4articlesDAO it4articlesDAO = null;
    private MatchingDAO matchingDAO = null;
    private KeyFromXmlDAO keysDAO = null;
    private MarkFromXmlDAO kmarkDAO = null;
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

    public newArticlesDAO getnewArticlesDAO() {
        if (newarticlesDAO == null) {
            newarticlesDAO = new newArticlesDAOImpl();
        }
        return newarticlesDAO;
    }

    public KeyFromXmlDAO getKeysDAO() {
        if (keysDAO == null) {
            keysDAO = new KeyFromXmlDAOImpl();
        }
        return keysDAO;
    }

    public MarkFromXmlDAO getMKeysDAO() {
        if (kmarkDAO == null) {
            kmarkDAO = new MarkFromXmlDAOImpl();
        }
        return kmarkDAO;
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

    public MatchingDAO getMatchingDAO() {
        if (matchingDAO == null) {
            matchingDAO = new MatchingDAOImpl();
        }
        return matchingDAO;
    }
}
