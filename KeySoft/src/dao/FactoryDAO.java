/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author APopov
 */
public class FactoryDAO {

    private ApplicationContext factory = new ClassPathXmlApplicationContext("config/SpringConfig.xml");
    private static FactoryDAO instance = null;

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }

    public SoftDAO getSoftDAO() {
        return (SoftDAO) factory.getBean("SoftDAO");
    }

    public AttributeDAO getAttributeDAO() {
        return (AttributeDAO) factory.getBean("AttributeDAO");
    }

    public ProductTypeDAO getProductTypeDAO() {
        return (ProductTypeDAO) factory.getBean("ProductTypeDAO");
    }

    public ValueDAO getValueDAO() {
        return (ValueDAO) factory.getBean("ValueDAO");
    }

    public HeadphonesDAO getHeadphonesDAO() {
        return (HeadphonesDAO) factory.getBean("HeadphonesDAO");
    }
}
