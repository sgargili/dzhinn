package imf.core.dto.web.response;

import imf.core.dto.UnitsOfMeasureDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 05.02.11
 * Time: 16:59
 */
@XmlRootElement(name = "unitsOfMeasure")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnitsOfMeasureResponse {
    @XmlElement(name = "unitOfMeasure")
    private List<UnitsOfMeasureDto> unitsOfMeasureDtos;

    private Long totalRowsCount;

    public UnitsOfMeasureResponse() {

    }

    public UnitsOfMeasureResponse(List<UnitsOfMeasureDto> unitsOfMeasureDtos, Long totalRowsCount) {
        this.unitsOfMeasureDtos = unitsOfMeasureDtos;
        this.totalRowsCount = totalRowsCount;
    }

    public List<UnitsOfMeasureDto> getUnitsOfMeasureDtos() {
        return unitsOfMeasureDtos;
    }

    public void setUnitsOfMeasureDtos(List<UnitsOfMeasureDto> unitsOfMeasureDtos) {
        this.unitsOfMeasureDtos = unitsOfMeasureDtos;
    }

    public Long getTotalRowsCount() {
        return totalRowsCount;
    }

    public void setTotalRowsCount(Long totalRowsCount) {
        this.totalRowsCount = totalRowsCount;
    }
}
