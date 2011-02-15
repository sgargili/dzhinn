package imf.core.dto.web.response;

import imf.core.dto.UnitsOfMeasureDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * User: Andrey Popov
 * Date: 05.02.11
 * Time: 16:59
 */
@XmlRootElement(name = "unitsOfMeasure")
public class UnitsOfMeasureResponse extends BaseResponse {

    @Override
    @XmlElementWrapper(name="entities")
    @XmlElement(name = "unitOfMeasure", type = UnitsOfMeasureDto.class)
    public List getDtos() {
        return super.getDtos();
    }
}
