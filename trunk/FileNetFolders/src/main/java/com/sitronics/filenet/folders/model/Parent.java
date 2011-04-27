package com.sitronics.filenet.folders.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 27.04.11 (18:03)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Parent {
    @XmlElement(name = "ObjectRef")
    private ObjectRef objectRef;

    public Parent() {
    }

    public Parent(ObjectRef objectRef) {
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

        Parent parent = (Parent) o;

        if (objectRef != null ? !objectRef.equals(parent.objectRef) : parent.objectRef != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return objectRef != null ? objectRef.hashCode() : 0;
    }
}
