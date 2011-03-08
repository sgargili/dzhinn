package imf.core.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Developed by: Администратор
 * Date (time): 06.03.11 (19:10)
 */

public class GroupDto extends BaseDto {
    private List<AttributeDto> attributeDtos = new ArrayList<AttributeDto>();
    private String comment4Template;
    private Integer weight;

    @XmlElementWrapper(name = "attributes")
    @XmlElement(name = "attribute", type = AttributeDto.class)
    public List<AttributeDto> getAttributeDtos() {
        return attributeDtos;
    }

    public void setAttributeDtos(List<AttributeDto> attributeDtos) {
        this.attributeDtos = attributeDtos;
    }

    public String getComment4Template() {
        return comment4Template;
    }

    public void setComment4Template(String comment4Template) {
        this.comment4Template = comment4Template;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void addAttributeDto(AttributeDto attributeDto) {
        this.attributeDtos.add(attributeDto);
    }

}
