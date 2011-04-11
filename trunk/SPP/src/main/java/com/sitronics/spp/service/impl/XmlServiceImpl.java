package com.sitronics.spp.service.impl;

import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import com.sitronics.spp.service.XmlService;

/**
 * @author Andrey Popov creates on 11.04.11 (16:02)
 */
@Service("marshallerService")
public class XmlServiceImpl implements XmlService {
    Logger logger = LoggerFactory.getLogger(XmlServiceImpl.class);

    @Autowired(required = false)
    Jaxb2Marshaller jaxb2Marshaller;

    public StringBuffer marshal(Object o) {
        if (jaxb2Marshaller == null) {
            logger.debug("Jaxb2Marshaller is null... Please set Jaxb2Marshaller in context with name jaxb2Marshaller for more flexible.");
            logger.debug("Create Jaxb2Marshaller by default for {}...", o.getClass());
            jaxb2Marshaller = new Jaxb2Marshaller();
            jaxb2Marshaller.setClassesToBeBound(o.getClass());
        }
        final StringWriter out = new StringWriter();
        return out.getBuffer();
    }
}
