package pojo;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 16.11.2010
 * Time: 14:24:26
 * To change this template use File | Settings | File Templates.
 */
public class ProductSpec {
    private String group;
    private String attribute;
    private String value;

    public ProductSpec() {
    }

    public ProductSpec(String group, String attribute, String value) {
        this.group = group;
        this.attribute = attribute;
        this.value = value;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
