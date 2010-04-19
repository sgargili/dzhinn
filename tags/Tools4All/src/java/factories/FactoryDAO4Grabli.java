package factories;

import dao.AttributeAlternativeNameDAO;
import dao.AttributeDAO;
import dao.ParentRelateElementDAO;
import dao.ProductTypeDAO;
import dao.ValueDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author APopov
 */
public class FactoryDAO4Grabli {

    private ApplicationContext factory = new ClassPathXmlApplicationContext("config/DaoSpringConfig.xml");
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

    public ParentRelateElementDAO getParentRelateElementDAO() {
        return (ParentRelateElementDAO) factory.getBean("ParentRelateElementDAO");
    }
    public AttributeAlternativeNameDAO getAttributeAlternativeNameDAO() {
        return (AttributeAlternativeNameDAO) factory.getBean("AttributeAlternativeNameDAO");
    }
}
