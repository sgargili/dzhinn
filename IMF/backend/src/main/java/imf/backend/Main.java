package imf.backend;

import imf.core.dao.UnitsGroupDao;
import imf.core.dto.UnitsGroupDto;
import imf.core.entity.UnitsGroup;
import imf.core.service.UnitsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: Andrey Popov
 * Date: 18.11.2010
 * Time: 13:08:43
 */
public class Main {
    private static ClassPathXmlApplicationContext appctx = new ClassPathXmlApplicationContext("spring.xml");
    private static UnitsGroupService service = (UnitsGroupService) appctx.getBean("unitsGroupService");
    private static UnitsGroupDao dao = (UnitsGroupDao) appctx.getBean("unitsGroupDao");

    public static void main(String[] args) {
        UnitsGroup ug = dao.getUnitsGroupById(1l);
        ug.setUnitOfMeasures(null);
        System.out.println(ug.getName());
//        System.out.println(service.getAllUnitsGroups().getUnitsGroup().get(0).getName());
    }
}
