package imf.core.dto.web.request;

/**
 * Developed by: Администратор
 * Date (time): 07.03.11 (13:53)
 */

public class AttributeRequest extends BaseRequest {
    private Long unitsGroupId;
    private Long subsGroupId;
    private Long unitOfMeasureId;
    private Byte type;
    private Byte typeOfValues;
    private Integer weight;
    private Boolean composite;
    private Boolean require;

    public Long getUnitsGroupId() {
        return unitsGroupId;
    }

    public void setUnitsGroupId(Long unitsGroupId) {
        this.unitsGroupId = unitsGroupId;
    }

    public Long getSubsGroupId() {
        return subsGroupId;
    }

    public void setSubsGroupId(Long subsGroupId) {
        this.subsGroupId = subsGroupId;
    }

    public Long getUnitOfMeasureId() {
        return unitOfMeasureId;
    }

    public void setUnitOfMeasureId(Long unitOfMeasureId) {
        this.unitOfMeasureId = unitOfMeasureId;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getComposite() {
        return composite;
    }

    public void setComposite(Boolean composite) {
        this.composite = composite;
    }

    public Boolean getRequire() {
        return require;
    }

    public void setRequire(Boolean require) {
        this.require = require;
    }
}
