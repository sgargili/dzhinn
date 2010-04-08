/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import dao.ValueLanguageDAO;
import java.util.ArrayList;
import util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.ValueLanguage;

/**
 *
 * @author Apopov
 */
public class ValueLanguageDAOImpl implements ValueLanguageDAO {

    public List getAllValueLanguages() {
        Session session = null;
        List<ValueLanguage> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from ValueLanguage v order by v.name");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public ValueLanguage getValueLanguageById(int id) {
       Session session = null;
        List<ValueLanguage> result = new ArrayList();
        session = HibernateUtil.getSessionFactory().openSession();
        ValueLanguage out = null;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from ValueLanguage v where v.id = :id")//
                    .setLong("id", id);
            result = getByLogin.list();
            out = result.get(0);
        } catch (RuntimeException e) {
        } catch (Exception ex) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

}
