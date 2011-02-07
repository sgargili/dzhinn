package imf.core.dto;


/**
 * User: Andrey Popov
 * Date: 19.11.2010
 * Time: 10:37:30
 */
public class UnitsOfMeasureDto {
    private Long id;
    private String name;
    private String prefix;
    private float ratio;
    private String comment;
    private boolean defaultValue;

    public UnitsOfMeasureDto() {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(boolean defaultValue) {
        this.defaultValue = defaultValue;
    }
}
