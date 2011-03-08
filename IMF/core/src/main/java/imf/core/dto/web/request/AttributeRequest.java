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
}
