package imf.core.dto;

import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

import imf.core.entity.Attribute2Group;
import imf.core.entity.SubsGroup;
import imf.core.entity.UnitOfMeasure;
import imf.core.entity.UnitsGroup;

/**
 * Developed by: Andrey Popov
 * Date (time): 21.02.11 (12:40)
 */

public class AttributeDto extends BaseDto {
    private UnitsGroup unitsGroup;
    private SubsGroup subsGroup;
    private UnitOfMeasure unitOfMeasure;
    private Byte type;
    private Byte typeOfValues;
    private List<Attribute2Group> attribute2Groups;

    public UnitsGroup getUnitsGroup() {
        return unitsGroup;
    }

    public void setUnitsGroup(UnitsGroup unitsGroup) {
        this.unitsGroup = unitsGroup;
    }

    public SubsGroup getSubsGroup() {
        return subsGroup;
    }

    public void setSubsGroup(SubsGroup subsGroup) {
        this.subsGroup = subsGroup;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getTypeOfValues() {
        return typeOfValues;
    }

    public void setTypeOfValues(Byte typeOfValues) {
        this.typeOfValues = typeOfValues;
    }

    public List<Attribute2Group> getAttribute2Groups() {
        return attribute2Groups;
    }

    public void setAttribute2Groups(List<Attribute2Group> attribute2Groups) {
        this.attribute2Groups = attribute2Groups;
    }
}
