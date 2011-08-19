package com.pav4it.imf;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;

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
public class CustomDateSerializer extends JsonSerializer<Date> {

    private static final Logger log = LoggerFactory.getLogger(CustomDateSerializer.class);

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        String formattedDate = formatter.format(date);
        jsonGenerator.writeString(formattedDate);
    }
}
