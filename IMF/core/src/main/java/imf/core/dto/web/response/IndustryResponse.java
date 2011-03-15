package imf.core.dto.web.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import imf.core.dto.IndustryDto;

/**
 * Developed by: Andrey Popov
 * Date (time): 15.03.11 (16:35)
 */
@XmlRootElement(name = "industries")
public class IndustryResponse extends BaseResponse {
    @Override
    @XmlElementWrapper(name = "entities")
    @XmlElement(name = "industry", type = IndustryDto.class)
    public List getDtos() {
        return super.getDtos();
    }
}
