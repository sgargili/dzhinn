package imf.core.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 17:59:53
 */
public class UnitsGroupDto extends BaseDto {

    private List<UnitsOfMeasureDto> unitOfMeasures = new ArrayList<UnitsOfMeasureDto>();

    public UnitsGroupDto() {
    }

    public List<UnitsOfMeasureDto> getUnitOfMeasures() {
        return unitOfMeasures;
    }

    public void setUnitOfMeasures(List<UnitsOfMeasureDto> unitOfMeasureDtos) {
        this.unitOfMeasures = unitOfMeasureDtos;
    }

    public void addUnitOfMeasureDto(UnitsOfMeasureDto unitOfMeasureDto) {
        this.unitOfMeasures.add(unitOfMeasureDto);
    }
}
