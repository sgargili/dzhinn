package com.pav4it.imf;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Andrey Popov creates on 18.08.11 (10:36)
 */
@Component
public class CustomDataSerializer extends JsonSerializer<SomeData> {

    private static final Logger log = LoggerFactory.getLogger(CustomDataSerializer.class);

    @Override
    public void serialize(SomeData someData, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        String formattedDate = someData.getName() + someData.getId();
        jsonGenerator.writeString(formattedDate);
    }
}
