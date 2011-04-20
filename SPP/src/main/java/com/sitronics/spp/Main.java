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
import com.sitronics.spp.model.type.*;
import com.sitronics.spp.model.type.ImageProcessingOptions;
import com.sitronics.spp.model.type.exportoptions.*;
import com.sitronics.spp.model.type.registrationparameters.RegParam;
import com.sitronics.spp.service.XmlService;

/**
 * @author Andrey Popov creates on 14.04.11 (12:09)
 */
public class Main {
    private static XmlService xmlService;
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spp-config.xml");

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        SeparationOptions separationOptions = (SeparationOptions) context.getBean("separationOptions");
        ImageProcessingOptions imageProcessingOptions = (ImageProcessingOptions) context.getBean("imageProcessingOptions");
        List<ExportOptionBase> exportOptions;
        List<RegParam> registrationParameters = (List<RegParam>) context.getBean("registrationParameters");
        PageSizeCheckingOptions pageSizeCheckingOptions = (PageSizeCheckingOptions) context.getBean("pageSizeCheckingOptions");

        Map<String, String> additionList = (Map<String, String>) context.getBean("additionList");
        Map<String, String> regionList = (Map<String, String>) context.getBean("regionList");
        Map<String, Integer> regionCodeList = (Map<String, Integer>) context.getBean("regionCodeList");
        List<String> packagesList = (List<String>) context.getBean("packagesList");
        ImageSavingOptions imageSavingOptions = (ImageSavingOptions) context.getBean("imageSavingOptions");

        StringBuilder builder = new StringBuilder();

        Type type = (Type) context.getBean("type");

        ToFlexiCapture toFlexiCapture;
        ToFolder toFolder;
        ToFTP toFTP;
        ToRecognitionServer toRecognitionServer;

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
                regParam1.setValue("<I><D><T>");
                regParams = new ArrayList<RegParam>();
                regParams.add(regParam1);
                regParams.add(regParam);

                type.setRegistrationParameters(regParams);

                toFlexiCapture = new ToFlexiCapture();
                toFlexiCapture.setBatchDescription("");
                toFlexiCapture.setBatchName(builder.toString());
                toFlexiCapture.setBatchTypeID(regionCodeList.get(builder.toString()));
                try {
                    if (regionCodeList.get(builder.toString()).equals("") || regionCodeList.get(builder.toString()) == null) {
                        System.out.println(builder.toString());
                    }
                } catch (NullPointerException e) {
                    System.out.println(builder.toString());
                    toFlexiCapture.setBatchTypeID(1);
                }
                toFlexiCapture.setBatchTypeName("");
                toFlexiCapture.setLocalProjectPath("https://10.35.42.13/4D4AE3A0-559D-4E10-ADDA-A09CAC4BC1A1/mts_eco;;");
                toFlexiCapture.setShowBeforeExport(true);
                toFlexiCapture.setBatchDescription("");

                toFolder = new ToFolder();
                toFolder.setBatchTypeName("");
                toFolder.setPath("");
                toFolder.setImageSavingOptions(imageSavingOptions);
                toFolder.setShowBeforeExport(true);

                toFTP = new ToFTP();
                toFTP.setBatchTypeName("");
                toFTP.setImageSavingOptions(imageSavingOptions);
                toFTP.setLogin("");
                toFTP.setPassword("");
                toFTP.setLoginType("Anonymous");
                toFTP.setShowBeforeExport(true);
                toFTP.setuRL("ftp://");

                toRecognitionServer = new ToRecognitionServer();
                toRecognitionServer.setWorkflow("");
                toRecognitionServer.setServerLocation("");
                toRecognitionServer.setBatchTypeName("");
                toRecognitionServer.setShowBeforeExport(true);

                exportOptions = new ArrayList();
                exportOptions.add(toFolder);
                exportOptions.add(toFTP);
                exportOptions.add(toFlexiCapture);
                exportOptions.add(toRecognitionServer);

                type.setExportOptions(exportOptions);

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
        String tag = (String) context.getBean("tag");
        batchTypes.setTag(tag);

        xmlService = (XmlService) context.getBean("xmlService");
        IOUtils.write(xmlService.marshal(batchTypes), new FileOutputStream("C://XML.xml"));

    }
}
