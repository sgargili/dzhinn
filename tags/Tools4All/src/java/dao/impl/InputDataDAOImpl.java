/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.InputDataDAO;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.InputData;

/**
 *
 * @author APopov
 */
public class InputDataDAOImpl implements InputDataDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public void addInputData(InputData inputData) {
        getHibernateTemplate().saveOrUpdate(inputData);
    }

    public void deleteInputData(InputData inputData) {
        getHibernateTemplate().delete(inputData);
    }

    public List<InputData> getAllInputData() {
        return (List<InputData>) getHibernateTemplate().loadAll(InputData.class);
    }

    public InputData getInputDataById(int id) {
        InputData inputData;
        String query = "from InputData id where inputDataId = :value";
        try {
            inputData = (InputData) getHibernateTemplate().findByNamedParam(query, "value", id).get(0);
            return inputData;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<InputData> getInputDataBySessionId(long sessionId) {
        String query = "from InputData id where sessionId = :value";
        try {
            return getHibernateTemplate().findByNamedParam(query, "value", sessionId);
        } catch (Exception ex) {
            return null;
        }
    }

    public List<InputData> getInputDataByArticle(String article) {
        String query = "from InputData id where article = :value";
        try {
            return getHibernateTemplate().findByNamedParam(query, "value", article);
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean isInputDataPresent(InputData inputData) {
        String query = "from InputData id where inputDataId = :value";
        try {
            return !getHibernateTemplate().findByNamedParam(query, "value", inputData.getInputDataId()).isEmpty();
        } catch (Exception ex) {
            return false;
        }
    }
}
