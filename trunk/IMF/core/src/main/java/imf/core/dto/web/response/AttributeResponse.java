package imf.core.dto.web.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

import imf.core.dto.AttributeDto;

/**
 * Developed by: Andrey Popov
 * Date (time): 21.02.11 (12:47)
 */
@XmlRootElement(name = "attributes")
public class AttributeResponse extends BaseResponse {
    @Override
    @XmlElementWrapper(name = "entities")
    @XmlElement(name = "attribute", type = AttributeDto.class)
    public List getDtos() {
        return super.getDtos();
    }

}
