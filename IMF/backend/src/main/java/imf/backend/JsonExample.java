package imf.backend;

import java.io.IOException;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import imf.core.entity.UnitsGroup;

public class JsonExample {
    public static void main(String argv[]) {
        try {
            JsonExample jsonExample = new JsonExample();
            jsonExample.testJackson();
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    public void testJackson() throws IOException {
        JsonFactory factory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper(factory);
        final AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
        mapper.getDeserializationConfig().setAnnotationIntrospector(introspector);
        mapper.getSerializationConfig().setAnnotationIntrospector(introspector);
        mapper.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, false);
        UnitsGroup group = new UnitsGroup();
        group.setId(1L);
        group.setComment("Comment");
        group.setName("Name");
//        group.setUnitOfMeasures(null);

        System.out.println(mapper.writeValueAsString(group));
    }
}
