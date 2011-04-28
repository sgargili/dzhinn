package com.sitronics.filenet.classes.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 27.04.11 (18:02)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ObjectRef {
    @XmlElement(name = "ObjectId")
    private String objectId;
    @XmlElement(name = "ClassId")
    private String classId;

    public ObjectRef() {
    }

    public ObjectRef(String objectId, String classId) {
        this.objectId = objectId;
        this.classId = classId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectRef objectRef = (ObjectRef) o;

        if (classId != null ? !classId.equals(objectRef.classId) : objectRef.classId != null) return false;
        if (objectId != null ? !objectId.equals(objectRef.objectId) : objectRef.objectId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectId != null ? objectId.hashCode() : 0;
        result = 31 * result + (classId != null ? classId.hashCode() : 0);
        return result;
    }
}
