package com.sitronics.filenet.folders.sevice.impl;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import com.sitronics.filenet.folders.model.*;
import com.sitronics.filenet.folders.sevice.XmlService;

/**
 * @author Andrey Popov creates on 27.04.11 (18:25)
 */
@Service("xmlService")
public class XmlServiceImpl implements XmlService {
    private final static Logger logger = LoggerFactory.getLogger(XmlServiceImpl.class);

    @Autowired(required = false)
    private Jaxb2Marshaller jaxb2Marshaller;

    @Resource
    private FolderProperties folderProperties;

    @Value("${defaultEncoding}")
    private String defaultEncoding;

    @Value("${eMVersion}")
    private String eMVersion;

    @Value("${rootObjectId}")
    private String rootObjectId;

    @Value("${defaultClassId}")
    private String defaultClassId;

    @Resource
    List<String> regions;


    private String marshal(ExportedObjects exportedObjects) {
        if (jaxb2Marshaller == null) {
            logger.debug("Jaxb2Marshaller is null... Please set Jaxb2Marshaller in context with name jaxb2Marshaller for more flexible.");
            logger.debug("Create Jaxb2Marshaller by default for {}...", ExportedObjects.class);
            jaxb2Marshaller = new Jaxb2Marshaller();
            jaxb2Marshaller.setClassesToBeBound(ExportedObjects.class);
        }
        final StringWriter out = new StringWriter();
        jaxb2Marshaller.marshal(exportedObjects, new StreamResult(out));
        return out.getBuffer().toString();
    }

    @Override
    public void createXml(String outputFile) {

        ObjectRef objectRef = new ObjectRef(rootObjectId, defaultClassId);

        Parent parent = new Parent(objectRef);

        Folder folder;

        Folders folders = new Folders();

        for (String region : regions) {

            folderProperties.setName(region);
            folderProperties.setFolderName(region);
            folderProperties.setId(UUID.randomUUID().toString());
            folderProperties.setParent(parent);

            folder = new Folder(folderProperties);

            folders.addFolder(folder);

            folderProperties = (FolderProperties) folderProperties.clone();
        }

        ExportedObjects exportedObjects = new ExportedObjects();

        exportedObjects.setFolders(folders);
        exportedObjects.seteMVersion(eMVersion);

        try {
            //Маршалим объект типов и суем его в файл...
            IOUtils.write(marshal(exportedObjects), new FileOutputStream(outputFile), defaultEncoding);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
