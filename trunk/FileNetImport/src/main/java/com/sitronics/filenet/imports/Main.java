package com.sitronics.filenet.imports;

import java.io.StringWriter;
import java.util.Iterator;

import javax.xml.transform.stream.StreamResult;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.filenet.api.admin.Choice;
import com.filenet.api.admin.ChoiceList;
import com.filenet.api.admin.DocumentClassDefinition;
import com.filenet.api.collection.IndependentObjectSet;
import com.filenet.api.core.*;
import com.filenet.api.property.PropertyFilter;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import com.sitronics.filenet.core.repository.FileNetService;
import com.sitronics.filenet.core.search.FileNetSearch;
import com.sitronics.filenet.core.storage.FileNetStorage;
import com.sitronics.filenet.imports.model.ExportDescriptor;

/**
 * @author Andrey Popov creates on 30.06.11 (13:08)
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        FileNetSearch search = (FileNetSearch) context.getBean("fileNetSearch");
//        System.out.println(search.isDocumentClassDefinitionPresent("KC3"));
//        System.out.println(search.isDocumentClassDefinitionPresent("M45555555"));

        FileNetService service = (FileNetService) context.getBean("fileNetService");

        service.createDocumentClassDefinition();
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
    }
}
