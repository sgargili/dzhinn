package hbt;

import java.util.List;

import hbt.dao.AttributeDao;
import hbt.model.Group;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * User: Andrey Popov
 * Date: 18.11.2010
 * Time: 13:08:43
 */
public class Main {
    private static ClassPathXmlApplicationContext appctx = new ClassPathXmlApplicationContext("spring.xml");
    private static AttributeDao attributeDao = (AttributeDao) appctx.getBean("attributeDao");

    public static void main(String[] args) {
        List list = attributeDao.getAllAttributesByGroup(new Group(50l));

        System.out.println(list.size());
    }
}
