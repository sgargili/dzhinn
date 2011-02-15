package imf.core.dto.web.response;

import imf.core.dto.UnitsGroupDto;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * User: Andrey Popov
 * Date: 29.01.11
 * Time: 15:00
 */

@XmlRootElement(name = "unitsGroups")
public class UnitsGroupResponse extends BaseResponse {

    @Override
    @XmlElementWrapper(name="entities")
    @XmlElement(name = "unitsGroup", type = UnitsGroupDto.class)
    public List getDtos() {
        return super.getDtos();
    }
}
