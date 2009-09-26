/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpClientPack;

import httpClientPack.httpDAO.HttpDAO;
import httpClientPack.httpDAOImpl.HttpDAOImpl;

/**
 *
 * @author APopov
 */
public class HTTPClientFactory {

    private static HttpDAO httpDAO = null;
    private static HTTPClientFactory instance = null;

    public static synchronized HTTPClientFactory getInstance() {
        if (instance == null) {
            instance = new HTTPClientFactory();
        }
        return instance;
    }

    public static HttpDAO getHttpDAO() {
        if (httpDAO == null) {
            httpDAO = new HttpDAOImpl();
        }
        return httpDAO;
    }
}
