package imf.core.dto.web.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import imf.core.dto.TemplateDto;

/**
 * Developed by: Администратор
 * Date (time): 06.03.11 (19:23)
 */
@XmlRootElement(name = "templates")
public class TemplateResponse extends BaseResponse {
    @Override
    @XmlElementWrapper(name = "entities")
    @XmlElement(name = "template", type = TemplateDto.class)
    public List getDtos() {
        return super.getDtos();
    }
}
