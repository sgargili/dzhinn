package imf.core.dto;

import imf.core.entity.UnitsGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 17:59:53
 */
public class UnitsGroupDto {
    private Long id;
    private String name;
    private String comment;
    private List<UnitOfMeasureDto> unitOfMeasures = new ArrayList<UnitOfMeasureDto>();

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

    public List<UnitOfMeasureDto> getUnitOfMeasures() {
        return unitOfMeasures;
    }

    public void setUnitOfMeasures(List<UnitOfMeasureDto> unitOfMeasureDtos) {
        this.unitOfMeasures = unitOfMeasureDtos;
    }

    public void addUnitOfMeasureDto(UnitOfMeasureDto unitOfMeasureDto) {
        unitOfMeasures.add(unitOfMeasureDto);
    }
}
