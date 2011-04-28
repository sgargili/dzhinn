package com.sitronics.filenet.classes.model.property;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 28.04.11 (15:05)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PropertyDefinitionBase {
    @XmlElement(name = "ObjectType")
    private String objectType;
    @XmlElement(name = "Name")
    private String name;

    public PropertyDefinitionBase() {
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyDefinitionBase that = (PropertyDefinitionBase) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (objectType != null ? !objectType.equals(that.objectType) : that.objectType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectType != null ? objectType.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
