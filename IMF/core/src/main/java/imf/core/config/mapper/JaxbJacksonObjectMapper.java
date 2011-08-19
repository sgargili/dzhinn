package imf.core.config.mapper;

/**
 * User: Andrey Popov
 * Date: 07.02.11
 * Time: 18:51
 */

import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

//Промежуточный класс для Spring-настройки Json-маппера с помощью Jaxb аннотаций.
public class JaxbJacksonObjectMapper extends ObjectMapper {

    public JaxbJacksonObjectMapper() {
        final AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
        super.getDeserializationConfig().withAnnotationIntrospector(introspector);
        super.getSerializationConfig().withAnnotationIntrospector(introspector);
        super.getSerializationConfig().withDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SZ"));
//        super.getDeserializationConfig().set(DeserializationConfig.Feature.WRAP_ROOT_VALUE, true);
//        super.getSerializationConfig().set(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
//        super.configure(SerializationConfig.Feature.USE_ANNOTATIONS, false);
//        super.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);

    }

}
