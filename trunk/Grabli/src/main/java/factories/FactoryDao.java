package factories;

import dao.InputDataDao;

import dao.ProcessDao;
import dao.ShopDao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author APopov
 */
public class FactoryDao {

	private ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
            "DaoSpringConfig.xml");
	private static FactoryDao instance = null;

	public static synchronized FactoryDao getInstance() {
		if (instance == null) {
			instance = new FactoryDao();
		}
		return instance;
	}

	public InputDataDao getInputDataDao() {
		return (InputDataDao) factory.getBean("inputDataDao");
	}

	public ShopDao getShopDao() {
		return (ShopDao) factory.getBean("shopDao");
	}

    public ProcessDao getProcessDao() {
		return (ProcessDao) factory.getBean("processDao");
	}
}
