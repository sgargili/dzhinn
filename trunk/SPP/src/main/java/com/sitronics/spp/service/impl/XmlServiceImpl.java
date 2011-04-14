package com.sitronics.spp.service.impl;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import com.sitronics.spp.model.BatchTypes;
import com.sitronics.spp.service.XmlService;

/**
 * @author Andrey Popov creates on 11.04.11 (16:02)
 */
@Service("xmlService")
public class XmlServiceImpl implements XmlService {
    Logger logger = LoggerFactory.getLogger(XmlServiceImpl.class);

    @Autowired(required = false)
    Jaxb2Marshaller jaxb2Marshaller;

    public String marshal(BatchTypes batchTypes) {
        if (jaxb2Marshaller == null) {
            logger.debug("Jaxb2Marshaller is null... Please set Jaxb2Marshaller in context with name jaxb2Marshaller for more flexible.");
            logger.debug("Create Jaxb2Marshaller by default for {}...", BatchTypes.class);
            jaxb2Marshaller = new Jaxb2Marshaller();
            jaxb2Marshaller.setClassesToBeBound(BatchTypes.class);
        }
        final StringWriter out = new StringWriter();
        jaxb2Marshaller.marshal(batchTypes, new StreamResult(out));
        return out.getBuffer().toString();
    }

    public BatchTypes unmarshal(String xmlData) {
        if (jaxb2Marshaller == null) {
            logger.debug("Jaxb2Marshaller is null... Please set Jaxb2Marshaller in context with name jaxb2Marshaller for more flexible.");
            logger.debug("Create Jaxb2Marshaller by default for {}...", BatchTypes.class);
            jaxb2Marshaller = new Jaxb2Marshaller();
            jaxb2Marshaller.setClassesToBeBound(BatchTypes.class);
        }
        BatchTypes batchTypes = new BatchTypes();
        jaxb2Marshaller.unmarshal(new StreamSource(new StringReader(xmlData)));
        return batchTypes;
    }
}
