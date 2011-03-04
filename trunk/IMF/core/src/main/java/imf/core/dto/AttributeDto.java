package imf.core.dto;


/**
 * Developed by: Andrey Popov
 * Date (time): 21.02.11 (12:40)
 */

public class AttributeDto extends BaseDto {
    private Long unitsGroup;
    private Long subsGroup;
    private Long unitOfMeasure;
    private Byte type;
    private Byte typeOfValues;
    private Boolean require;
    private Boolean composite;
    private String comment4Group;
    private Integer weight;

    public Long getUnitsGroup() {
        return unitsGroup;
    }

    public void setUnitsGroup(Long unitsGroup) {
        this.unitsGroup = unitsGroup;
    }

    public Long getSubsGroup() {
        return subsGroup;
    }

    public void setSubsGroup(Long subsGroup) {
        this.subsGroup = subsGroup;
    }

    public Long getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(Long unitOfMeasure) {
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

    public Boolean getRequire() {
        return require;
    }

    public void setRequire(Boolean require) {
        this.require = require;
    }

    public Boolean getComposite() {
        return composite;
    }

    public void setComposite(Boolean composite) {
        this.composite = composite;
    }

    public String getComment4Group() {
        return comment4Group;
    }

    public void setComment4Group(String comment4Group) {
        this.comment4Group = comment4Group;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
