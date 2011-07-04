package com.sitronics.filenet.imports;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.filenet.api.admin.DocumentClassDefinition;
import com.sitronics.filenet.core.model.ExcelClassDefinition;
import com.sitronics.filenet.core.service.ExcelService;
import com.sitronics.filenet.core.service.FileNetService;

/**
 * @author Andrey Popov creates on 30.06.11 (13:08)
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        FileNetSearch search = (FileNetSearch) context.getBean("fileNetSearch");
//        System.out.println(search.isDocumentClassDefinitionPresent("KC3"));
//        System.out.println(search.isDocumentClassDefinitionPresent("M45555555"));

        FileNetService service = (FileNetService) context.getBean("fileNetService");
//        PropertyTemplateSet set = (PropertyTemplateSet) service.getObjectCollection(PropertyTemplate.class);
//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()){
//            PropertyTemplate template = (PropertyTemplate) iterator.next();
//            System.out.println(template.get_Name() + " - " +template.get_Id().toString());
//        }
//        service.getObjectBySymbolicName(DocumentClassDefinition.class, "GTD");
//        service.createDocumentClassDefinition();
//        Jaxb2Marshaller marshaller = (Jaxb2Marshaller) context.getBean("jaxb2Marshaller");
//        ExportDescriptor exportDescriptor = (ExportDescriptor) context.getBean("exportDescriptor");
//        final StringWriter out = new StringWriter();
//        marshaller.marshal(exportDescriptor, new StreamResult(out));
//        System.out.println(out.getBuffer().toString());

//        PropertyFilter filter = new PropertyFilter();
//         IndependentObject independentObject = objectStore.fetchObject("c57469a4-1592-4428-b7ee-0c970e4db76a", "c57469a4-1592-4428-b7ee-0c970e4db76a", filter);
//        System.out.println(independentObject.get_ClassDescription().get_Name());
//        Iterator choiceListsIterator = objectStore.get_ChoiceLists().iterator();
//        Iterator choiceListsValuesIterator;
//
//        while(choiceListsIterator.hasNext()){
//            ChoiceList choiceList = (ChoiceList) choiceListsIterator.next();
//            choiceListsValuesIterator = choiceList.get_ChoiceValues().iterator();
//            while(choiceListsValuesIterator.hasNext()){
//                Choice choice = (Choice) choiceListsValuesIterator.next();
//                System.out.println(choice.get_ChoiceStringValue());
//            }
//
//        }

        ExcelService excelService = (ExcelService) context.getBean("excelService");
        FileInputStream inputStream = new FileInputStream("C://Test.xlsx");
       List<ExcelClassDefinition> list = excelService.getExcelClassDefinitions(inputStream);

        service.storeObject2FileNet(list);

        System.out.println(list.size());
    }
}
