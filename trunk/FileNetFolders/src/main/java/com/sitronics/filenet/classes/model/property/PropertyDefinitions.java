package com.sitronics.filenet.classes.model.property;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

/**
 * @author Andrey Popov creates on 28.04.11 (15:25)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PropertyDefinitions {
    @XmlElements(value = {
            @XmlElement(name = "PropertyDefinitionObject", type = PropertyDefinitionObject.class),
            @XmlElement(name = "PropertyDefinitionBoolean", type = PropertyDefinitionBoolean.class),
            @XmlElement(name = "PropertyDefinitionString", type = PropertyDefinitionString.class)
    })
    private List<PropertyDefinitionBase> propertyDefinitions = new ArrayList<PropertyDefinitionBase>();

    public PropertyDefinitions() {
    }

    public PropertyDefinitions(List<PropertyDefinitionBase> propertyDefinitions) {
        this.propertyDefinitions = propertyDefinitions;
    }

    public List<PropertyDefinitionBase> getPropertyDefinitions() {
        return propertyDefinitions;
    }

    public void setPropertyDefinitions(List<PropertyDefinitionBase> propertyDefinitions) {
        this.propertyDefinitions = propertyDefinitions;
    }

    public void addPropertyDefinition(PropertyDefinitionBase propertyDefinition) {
        this.propertyDefinitions.add(propertyDefinition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyDefinitions that = (PropertyDefinitions) o;

        if (propertyDefinitions != null ? !propertyDefinitions.equals(that.propertyDefinitions) : that.propertyDefinitions != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return propertyDefinitions != null ? propertyDefinitions.hashCode() : 0;
    }

}
