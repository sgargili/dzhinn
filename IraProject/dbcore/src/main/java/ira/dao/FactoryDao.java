package ira.dao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: PAV
 * Date: 27.10.2010
 * Time: 0:29:01
 * To change this template use File | Settings | File Templates.
 */
public class FactoryDao {
    private static FactoryDao ourInstance = new FactoryDao();
    private ClassPathXmlApplicationContext appctx = new ClassPathXmlApplicationContext("springDao.xml");

    public DataDao getDataDao() {
        return (DataDao) appctx.getBean("dataDao");
    }

    public LinkDao getLinkDao() {
        return (LinkDao) appctx.getBean("linkDao");
    }

    public static FactoryDao getInstance() {
        return ourInstance;
    }

    private FactoryDao() {
    }


}
