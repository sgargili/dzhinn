package com.sitronics.spp.model.type.registrationparameters;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 14.04.11 (11:22)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class RegParam implements Cloneable {
    @XmlAttribute(name = "Type")
    private String type;
    @XmlAttribute(name = "IsReadOnly")
    private Boolean isReadOnly;
    @XmlAttribute(name = "IsRequired")
    private Boolean isRequired;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Value")
    private String value;

    public RegParam() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getReadOnly() {
        return isReadOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        isReadOnly = readOnly;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegParam regParam = (RegParam) o;

        if (isReadOnly != null ? !isReadOnly.equals(regParam.isReadOnly) : regParam.isReadOnly != null) return false;
        if (isRequired != null ? !isRequired.equals(regParam.isRequired) : regParam.isRequired != null) return false;
        if (name != null ? !name.equals(regParam.name) : regParam.name != null) return false;
        if (type != null ? !type.equals(regParam.type) : regParam.type != null) return false;
        if (value != null ? !value.equals(regParam.value) : regParam.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (isReadOnly != null ? isReadOnly.hashCode() : 0);
        result = 31 * result + (isRequired != null ? isRequired.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
