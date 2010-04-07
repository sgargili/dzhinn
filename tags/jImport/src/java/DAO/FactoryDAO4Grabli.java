package DAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author APopov
 */
public class FactoryDAO4Grabli {

    private ApplicationContext factory = new ClassPathXmlApplicationContext("config/SpringConfig.xml");
    private static FactoryDAO4Grabli instance = null;

    public static synchronized FactoryDAO4Grabli getInstance() {
        if (instance == null) {
            instance = new FactoryDAO4Grabli();
        }
        return instance;
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
}
