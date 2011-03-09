package imf.backend;

import java.io.IOException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import imf.core.dao.GroupDao;
import imf.core.dto.GroupDto;

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
//    private static AttributeService attributeService = (AttributeService) appctx.getBean("attributeService");

//    private static TemplateService templateService = (TemplateService) appctx.getBean("templateService");

//    private static SqlScalarTypesConfig config = (SqlScalarTypesConfig) appctx.getBean("sqlScalarTypesConfig");

//    private static CsvService csvService = (CsvService) appctx.getBean("csvService");

    private static GroupDao dao = (GroupDao) appctx.getBean("groupDao");

    public static void main(String[] args) throws IOException {

        List<GroupDto> dtos = dao.getGroupsWithAttributes(0, 20);
        System.out.println(dtos.size());
//        Long start = System.nanoTime();
//        System.out.println(csvService.getValueByKey("Ключ 199997"));
//        Long end = System.nanoTime();
//        System.out.println((end - start));
//
//
//         start = System.nanoTime();
//        System.out.println(csvService.getValueByKey("Ключ 199997"));
//         end = System.nanoTime();
//        System.out.println((end - start));
//
//         csvService.clear();
//         start = System.nanoTime();
//        System.out.println(csvService.getValueByKey("Ключ 199997"));
//         end = System.nanoTime();
//        System.out.println((end - start));


//        UnitsGroup ug = dao.getUnitsGroupById(1l);
//        ug.setUnitOfMeasures(null);
//        System.out.println(dao.getUnitsGroupWithUnitsById(2L).getName());
//        System.out.println(service.getAllUnitsGroups().getUnitsGroupId().get(0).getName());
//        Map<String, String> map = new HashMap<String, String>();
//        SubsGroup subsGroup =  subsGroupDao.getSubsGroupWithSubstitutesById(1l);
//        TreeResponse tree =  subsGroupService.getSubsGroupTreeResponse();
//        @Transactional
//        subsGroupDao.getSubsGroups(0).size();
//        SubsGroup subsGroup = new SubsGroup();
//        subsGroup.setId(1L);
//        Group group = new Group();
//        group.setId(1l);
//        System.out.println(attributeService.getAttributesByGroupId(50L).getTotalRowsCount());

//        System.out.println(templateService.getTemplateById(8l).getDtos().size());


        /*TestService service = (TestService) appctx.getBean("testService");

   Long start = System.nanoTime();
   System.out.print(service.getInteger(10));
   Long end = System.nanoTime();
   System.out.println(" 6 - "+(end - start));

   start = System.nanoTime();
   System.out.print(service.getInteger(20));
   end = System.nanoTime();
   System.out.println(" 7 - "+(end - start));

   start = System.nanoTime();
   System.out.print(service.getInteger(20));
   end = System.nanoTime();
   System.out.println(" 7 - "+(end - start));

   start = System.nanoTime();
   System.out.print(service.getInteger(20));
   end = System.nanoTime();
   System.out.println(" 7 - "+(end - start));

   start = System.nanoTime();
   System.out.print(service.getInteger(20));
   end = System.nanoTime();
   System.out.println(" 7 - "+(end - start));

   start = System.nanoTime();
   System.out.print(service.getInteger(20));
   end = System.nanoTime();
   System.out.println(" 7 - "+(end - start));

   start = System.nanoTime();
   System.out.print(service.getInteger(20));
   end = System.nanoTime();
   System.out.println(" 7 - "+(end - start));

   start = System.nanoTime();
   System.out.print(service.getInteger(20));
   end = System.nanoTime();
   System.out.println(" 7 - "+(end - start));
   start = System.nanoTime();
   System.out.print(service.getInteger(20));
   end = System.nanoTime();
   System.out.println(" 7 - "+(end - start));

   start = System.nanoTime();
   System.out.print(service.getInteger(20));
   end = System.nanoTime();
   System.out.println(" 7 - "+(end - start));

   start = System.nanoTime();
   System.out.print(service.getInteger(20));
   end = System.nanoTime();
   System.out.println(" 7 - "+(end - start));

   start = System.nanoTime();
   System.out.print(service.getInteger(20));
   end = System.nanoTime();
   System.out.println(" 7 - "+(end - start));


   start = System.nanoTime();
   System.out.print(service.getInteger(30));
   end = System.nanoTime();
   System.out.println(" 8 - "+(end - start));

   start = System.nanoTime();
   System.out.print(service.getInteger(10));
   end = System.nanoTime();
   System.out.println(" 6 - "+(end - start));

   service.clear();

   start = System.nanoTime();
   System.out.print(service.getInteger(10));
   end = System.nanoTime();
   System.out.println(" 6 - "+(end - start));*/
    }
}
