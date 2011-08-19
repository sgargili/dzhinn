package com.pav4it.imf;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Andrey Popov creates on 18.08.11 (12:21)
 */
public class Dess extends JsonDeserializer<SomeData> {

    private static final Logger log = LoggerFactory.getLogger(Dess.class);

    @Override
    public SomeData deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        log.error("LOG00150: {}", jp.getText());
        return null;
    }
}
