package imf.backend;

import imf.core.dao.AttributeDao;
import imf.core.dao.SubsGroupDao;
import imf.core.dao.SubstituteDao;
import imf.core.dao.UnitsGroupDao;
import imf.core.dto.UnitsGroupDto;
import imf.core.dto.web.response.TreeResponse;
import imf.core.entity.Group;
import imf.core.entity.SubsGroup;
import imf.core.entity.UnitsGroup;
import imf.core.service.AttributeService;
import imf.core.service.SubsGroupService;
import imf.core.service.UnitsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Andrey Popov
 * Date: 18.11.2010
 * Time: 13:08:43
 */
public class Main {
    private static ClassPathXmlApplicationContext appctx = new ClassPathXmlApplicationContext("spring.xml");
    /*private static UnitsGroupService service = (UnitsGroupService) appctx.getBean("unitsGroupService");
    private static UnitsGroupDao dao = (UnitsGroupDao) appctx.getBean("unitsGroupDao");
    private static SubsGroupDao subsGroupDao = (SubsGroupDao) appctx.getBean("subsGroupDao");
    private static SubsGroupService subsGroupService = (SubsGroupService) appctx.getBean("subsGroupService");
    private static SubstituteDao substituteDao = (SubstituteDao) appctx.getBean("substituteDao");
    private static AttributeDao attributeDao = (AttributeDao) appctx.getBean("attributeDao");*/
    private static AttributeService attributeService = (AttributeService) appctx.getBean("attributeService");
    public static void main(String[] args) {
//        UnitsGroup ug = dao.getUnitsGroupById(1l);
//        ug.setUnitOfMeasures(null);
//        System.out.println(dao.getUnitsGroupWithUnitsById(2L).getName());
//        System.out.println(service.getAllUnitsGroups().getUnitsGroup().get(0).getName());
//        Map<String, String> map = new HashMap<String, String>();
//        SubsGroup subsGroup =  subsGroupDao.getSubsGroupWithSubstitutesById(1l);
//        TreeResponse tree =  subsGroupService.getSubsGroupTreeResponse();
//        @Transactional
//        subsGroupDao.getSubsGroups(0).size();
//        SubsGroup subsGroup = new SubsGroup();
//        subsGroup.setId(1L);
        Group group = new Group();
        group.setId(1l);
        System.out.println(attributeService.getAttributesByGroupId(1L).getDtos().size());

    }
}
