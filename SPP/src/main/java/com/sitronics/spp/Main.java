package com.sitronics.spp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sitronics.spp.model.BatchTypes;
import com.sitronics.spp.model.publicationrecords.Publication;
import com.sitronics.spp.model.type.Type;
import com.sitronics.spp.model.type.registrationparameters.RegParam;
import com.sitronics.spp.service.XmlService;

/**
 * @author Andrey Popov creates on 14.04.11 (12:09)
 */
public class Main {
    private static XmlService xmlService;
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spp-config.xml");

    public static void main(String[] args) throws IOException {
//        SeparationOptions separationOptions = (SeparationOptions) context.getBean("separationOptions");
//        ImageProcessingOptions imageProcessingOptions = (ImageProcessingOptions) context.getBean("imageProcessingOptions");
//        List<ExportOptionBase> exportOptions = (List<ExportOptionBase>) context.getBean("exportOptions");
//        List<RegParam> registrationParameters = (List<RegParam>) context.getBean("registrationParameters");
//        PageSizeCheckingOptions pageSizeCheckingOptions = (PageSizeCheckingOptions) context.getBean("pageSizeCheckingOptions");


        Map<String, String> additionList = (Map<String, String>) context.getBean("additionList");
        Map<String, String> regionList = (Map<String, String>) context.getBean("regionList");
        List<String> packagesList = (List<String>) context.getBean("packagesList");
        StringBuilder builder = new StringBuilder();
        Type type = (Type) context.getBean("type");
        RegParam regParam;
        RegParam regParam1;
        List<RegParam> regParams;
        List<Type> types = new ArrayList<Type>();

        for (String pack : packagesList) {
            for (Map.Entry<String, String> entry : additionList.entrySet()) {
                type = (Type) type.clone();
                type.setUID(UUID.randomUUID().toString());
                builder.append(pack).append("_").append(entry.getValue()).append("_").append(entry.getKey());
                type.setName(builder.toString());
                regParam = new RegParam();
                regParam.setName("Region");
                regParam.setRequired(true);
                regParam.setType("Text");
                regParam.setValue(regionList.get(entry.getKey()));
                regParam1 = new RegParam();
                regParam1.setName("PackageID");
                regParam1.setRequired(true);
                regParam1.setType("Text");
                regParam1.setValue("&lt;I&gt;&lt;D&gt;&lt;T&gt;");
                regParams = new ArrayList<RegParam>();
                regParams.add(regParam1);
                regParams.add(regParam);
//                regParam = (RegParam) type.getRegistrationParameters().get(1).clone();
//                regParam.setValue(regionList.get(entry.getKey()));
//                type.getRegistrationParameters().remove(type.getRegistrationParameters().get(1));
                type.setRegistrationParameters(regParams);
//                type.getRegistrationParameters().get(1).setValue(regionList.get(entry.getKey()));
                types.add(type);
                builder.setLength(0);
            }
        }


        Publication publication = (Publication) context.getBean("publication");

        List<Publication> publications = new ArrayList<Publication>();
        publications.add(publication);

        BatchTypes batchTypes = new BatchTypes();
        batchTypes.setPublicationRecords(publications);
        batchTypes.setTypes(types);

        xmlService = (XmlService) context.getBean("xmlService");
        IOUtils.write(xmlService.marshal(batchTypes), new FileOutputStream("C://XML.xml"));
//        System.out.println(xmlService.marshal(batchTypes).toString());

    }
}
