package imf.core.config.mapper;

/**
 * User: Andrey Popov
 * Date: 07.02.11
 * Time: 18:51
 */

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

//Промежуточный класс для Spring-настройки Json-маппера с помощью Jaxb аннотаций.
public class JaxbJacksonObjectMapper extends ObjectMapper {

    public JaxbJacksonObjectMapper() {
        final AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
        super.getDeserializationConfig().setAnnotationIntrospector(introspector);
        super.getSerializationConfig().setAnnotationIntrospector(introspector);
//        super.getDeserializationConfig().set(DeserializationConfig.Feature.WRAP_ROOT_VALUE, true);
//        super.configure(SerializationConfig.Feature.USE_ANNOTATIONS, false);
//        super.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);

    }

}
