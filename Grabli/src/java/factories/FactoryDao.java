package factories;

import dao.InputDataDao;

import dao.ShopDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author APopov
 */
public class FactoryDao {

    private ApplicationContext factory = new ClassPathXmlApplicationContext("config/DaoSpringConfig.xml");
    private static FactoryDao instance = null;

    public static synchronized FactoryDao getInstance() {
        if (instance == null) {
            instance = new FactoryDao();
        }
        return instance;
    }

    public InputDataDao getInputDataDao() {
        return (InputDataDao) factory.getBean("InputDataDao");
    }

    public ShopDao getShopDao() {
        return (ShopDao) factory.getBean("ShopDao");
    }
}
