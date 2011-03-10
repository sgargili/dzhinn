package imf.backend;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import imf.core.dto.web.request.AttributeRequest;
import imf.core.dto.web.request.GroupRequest;
import imf.core.service.Attribute2GroupService;

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

    //    private static GroupService groupService = (GroupService) appctx.getBean("groupService");
    private static Attribute2GroupService attribute2GroupService = (Attribute2GroupService) appctx.getBean("attribute2GroupService");

    public static void main(String[] args) throws IOException {
        GroupRequest request = new GroupRequest();
        request.setId(2L);
        AttributeRequest attributeRequest = new AttributeRequest();
        attributeRequest.setComment("New Relation 4 Group 1");
        attributeRequest.setId(3L);
        attributeRequest.setWeight(0);
        request.addAttributeRequests(attributeRequest);

        attributeRequest = new AttributeRequest();
        attributeRequest.setComment("New Relation 4 Group 2");
        attributeRequest.setId(4L);
        attributeRequest.setWeight(1);
        request.addAttributeRequests(attributeRequest);

        attributeRequest = new AttributeRequest();
        attributeRequest.setComment("New Relation 4 Group 3");
        attributeRequest.setId(5L);
        attributeRequest.setWeight(2);
        request.addAttributeRequests(attributeRequest);

        attribute2GroupService.deleteAttribute2Group(request);

//        GroupResponse groupResponse = groupService.getGroupsWithAttributesByName("", 1000);
//        System.out.println(groupResponse.getDtos().size());
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
