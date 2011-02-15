package imf.core.dto;


/**
 * User: Andrey Popov
 * Date: 19.11.2010
 * Time: 10:37:30
 */
public class UnitsOfMeasureDto extends BaseDto {

    private String prefix;
    private float ratio;
    private boolean defaultValue;

    public UnitsOfMeasureDto() {
    }


    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    public boolean isDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(boolean defaultValue) {
        this.defaultValue = defaultValue;
    }
}
