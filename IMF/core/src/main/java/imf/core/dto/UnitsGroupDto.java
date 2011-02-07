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
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UnitsGroupDto {
    private Long id;
    private String name;
    private String comment;
    @XmlElement(name = "unitOfMeasure")
    private List<UnitsOfMeasureDto> unitOfMeasures = new ArrayList<UnitsOfMeasureDto>();

    public UnitsGroupDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<UnitsOfMeasureDto> getUnitOfMeasures() {
        return unitOfMeasures;
    }

    public void setUnitOfMeasures(List<UnitsOfMeasureDto> unitOfMeasureDtos) {
        this.unitOfMeasures = unitOfMeasureDtos;
    }

    public void addUnitOfMeasureDto(UnitsOfMeasureDto unitOfMeasureDto) {
        unitOfMeasures.add(unitOfMeasureDto);
    }
}
