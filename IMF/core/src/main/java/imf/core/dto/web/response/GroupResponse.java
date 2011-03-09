package imf.core.dto.web.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

import imf.core.dto.GroupDto;

/**
 * Developed by: Andrey Popov
 * Date (time): 09.03.11 (18:37)
 */
@XmlRootElement(name = "groups")
public class GroupResponse extends BaseResponse {

    @Override
    @XmlElementWrapper(name = "entities")
    @XmlElement(name = "group", type = GroupDto.class)
    public List getDtos() {
        return super.getDtos();
    }
}
