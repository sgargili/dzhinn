package com.sitronics.filenet.classes.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 28.04.11 (14:51)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SuperclassDefinition {
    @XmlElement(name = "ObjectRef")
    private ObjectRef objectRef;

    public SuperclassDefinition() {
    }

    public SuperclassDefinition(ObjectRef objectRef) {
        this.objectRef = objectRef;
    }

    public ObjectRef getObjectRef() {
        return objectRef;
    }

    public void setObjectRef(ObjectRef objectRef) {
        this.objectRef = objectRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuperclassDefinition that = (SuperclassDefinition) o;

        if (objectRef != null ? !objectRef.equals(that.objectRef) : that.objectRef != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return objectRef != null ? objectRef.hashCode() : 0;
    }
}
