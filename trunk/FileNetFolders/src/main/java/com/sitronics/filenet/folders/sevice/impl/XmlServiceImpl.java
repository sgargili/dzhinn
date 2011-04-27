package com.sitronics.filenet.folders.sevice.impl;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private String defaultEncoding;

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
    public void createXml(String outputFolder) {

        ObjectRef objectRef = new ObjectRef("0f1e2d3c-4b5a-6978-8796-a5b4c3d2e1f0","01a3a8ca-7aec-11d1-a31b-0020af9fbb1c");

        Parent parent = new Parent(objectRef);

        FolderProperties folderProperties = new FolderProperties();
        folderProperties.setObjectType("2");
        folderProperties.setName("Регион_7776");
        folderProperties.setSecurityPolicy("");
        folderProperties.setCreator("p8admin");
        folderProperties.setDateLastModified("2011-04-11T06:41:58.0Z");
        folderProperties.setDateCreated("2011-04-11T06:41:58.0Z");
        folderProperties.setFolderName("Регион_1957776");
        folderProperties.setReplicationGroup("");
        folderProperties.setId("5aab44ee-60d9-4370-a6a9-6b3ec75cf011");
        folderProperties.setContainerType("");
        folderProperties.setExternalReplicaIdentities("");
        folderProperties.setLastModifier("p8admin");
        folderProperties.setHiddenContainer("0");
        folderProperties.setInheritParentPermissions("1");
        folderProperties.setParent(parent);

        Folder folder = new Folder(folderProperties);

        Folders folders = new Folders();
        folders.addFolder(folder);

        ExportedObjects exportedObjects = new ExportedObjects();
        exportedObjects.setFolders(folders);
        exportedObjects.seteMVersion("4.51.0.100");
        try {
            logger.info(marshal(exportedObjects));
            //Маршалим объект типов и суем его в файл...
            //IOUtils.write(marshal(exportedObjects), new FileOutputStream(outputFolder.replaceFirst("/$", "") + "/BatchTypes.xml"), defaultEncoding);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
