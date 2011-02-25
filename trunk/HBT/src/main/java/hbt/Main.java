package hbt;

import java.util.List;
import java.util.Set;

import hbt.dao.AttributeDao;
import hbt.dao.ItemDao;
import hbt.dao.TemplateDao;
import hbt.model.Attribute;
import hbt.model.Group;
import hbt.model.Template;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * User: Andrey Popov
 * Date: 18.11.2010
 * Time: 13:08:43
 */
public class Main {
    private static ClassPathXmlApplicationContext appctx = new ClassPathXmlApplicationContext("spring.xml");
    private static AttributeDao attributeDao = (AttributeDao) appctx.getBean("attributeDao");
    private static TemplateDao templateDao = (TemplateDao) appctx.getBean("templateDao");
     private static ItemDao itemDao = (ItemDao) appctx.getBean("itemDao");

    public static void main(String[] args) {
//        Attribute attribute = attributeDao.getAttributeById(50L);
//        System.out.println(attribute);
//        List list = attributeDao.getAllAttributesByGroup(new Group(7l));

//        System.out.println(list.size());
//        Template template = templateDao.getTemplateById(8l);
//        Set<Group> groups = template.getGroups();
//        System.out.println(template.getName());
        System.out.println(itemDao.getItemsByProductId(1).size());
    }
}
