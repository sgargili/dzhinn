package com.sitronics.filenet.classes.service.impl;


import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import com.sitronics.filenet.classes.model.*;
import com.sitronics.filenet.classes.model.property.ReplicableClassDefinitionProperties;
import com.sitronics.filenet.classes.service.XmlService;


/**
 * @author Andrey Popov creates on 27.04.11 (18:25)
 */
@Service("xmlService")
public class XmlServiceImpl implements XmlService {
    private final static Logger logger = LoggerFactory.getLogger(XmlServiceImpl.class);

    @Qualifier("jaxb2Marshaller")
    @Autowired(required = false)
    private Jaxb2Marshaller jaxb2Marshaller;

    @Autowired
    private LocalizedString localizedString;

    private DisplayNames displayNames;
    private DescriptiveTexts descriptiveTexts;

    @Resource
    private ReplicableClassDefinitionProperties replicableClassDefinitionProperties;

    @Value("${defaultEncoding}")
    private String defaultEncoding;

    @Value("${eMVersion}")
    private String eMVersion;

    @Resource
    Map<String, String> regions;

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
        ExportedObjects exportedObjects = new ExportedObjects();
        exportedObjects.seteMVersion(eMVersion);
        exportedObjects.setChoiceLists("");
        exportedObjects.setLifeCycleActions("");
        exportedObjects.setLifeCyclePolicies("");
        exportedObjects.setPropertyTemplates("");

        ClassDefinitions classDefinitions = new ClassDefinitions();

        ReplicableClassDefinition replicableClassDefinition;


        for (Map.Entry<String, String> region : regions.entrySet()) {
            replicableClassDefinitionProperties.setSymbolicName(region.getKey());
            replicableClassDefinitionProperties.setName(region.getValue());

            localizedString.setLocalizedText(region.getValue());

            displayNames = new DisplayNames(localizedString);

            replicableClassDefinitionProperties.setDisplayNames(displayNames);

            descriptiveTexts = new DescriptiveTexts(localizedString);

            replicableClassDefinitionProperties.setDescriptiveTexts(descriptiveTexts);
            replicableClassDefinitionProperties.setId(UUID.randomUUID().toString());

            localizedString = (LocalizedString) localizedString.clone();

            replicableClassDefinitionProperties = (ReplicableClassDefinitionProperties) replicableClassDefinitionProperties.clone();

            replicableClassDefinition = new ReplicableClassDefinition(replicableClassDefinitionProperties);

            classDefinitions.addReplicableClassDefinition(replicableClassDefinition);


        }

        exportedObjects.setClassDefinitions(classDefinitions);

        try {
            //Маршалим объект типов и суем его в файл...
            IOUtils.write(marshal(exportedObjects), new FileOutputStream(outputFile), defaultEncoding);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
