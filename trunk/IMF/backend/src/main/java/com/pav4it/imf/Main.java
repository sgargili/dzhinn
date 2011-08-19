package com.pav4it.imf;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import imf.core.config.mapper.JaxbJacksonObjectMapper;

/**
 * @author Andrey Popov creates on 18.08.11 (12:00)
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        JaxbJacksonObjectMapper mapper = new JaxbJacksonObjectMapper();
        Page page = new Page();
//        page.setDate(new Date(new java.util.Date().getTime()));
//        SomeData someData = new SomeData();
//        someData.setId(1l);
//        someData.setName("ssss");
//        page.setSomeData(someData);
//        mapper.writeValue(System.out, page);
        String json = "{\"date\":\"2011-18-1\",\"someData\":\"ssss1\"}";
        page = mapper.readValue(json, Page.class);
        System.out.println(page);
//        log.error("LOG00130: {}");
    }
}
