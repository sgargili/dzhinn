package com.sitronics.filenet.classes.model.property;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 28.04.11 (15:22)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PropertyDefinitionObject extends PropertyDefinitionBase {
    @XmlElement(name = "RequiredClassId")
    private String requiredClassId;
    @XmlElement(name = "ReflectivePropertyId")
    private String reflectivePropertyId;
    @XmlElement(name = "DeletionAction")
    private String deletionAction;
    @XmlElement(name = "PropertyDefaultObject")
    private String propertyDefaultObject;
    @XmlElement(name = "PrimaryId")
    private String primaryId;

    public PropertyDefinitionObject() {
    }

    public String getRequiredClassId() {
        return requiredClassId;
    }

    public void setRequiredClassId(String requiredClassId) {
        this.requiredClassId = requiredClassId;
    }

    public String getReflectivePropertyId() {
        return reflectivePropertyId;
    }

    public void setReflectivePropertyId(String reflectivePropertyId) {
        this.reflectivePropertyId = reflectivePropertyId;
    }

    public String getDeletionAction() {
        return deletionAction;
    }

    public void setDeletionAction(String deletionAction) {
        this.deletionAction = deletionAction;
    }

    public String getPropertyDefaultObject() {
        return propertyDefaultObject;
    }

    public void setPropertyDefaultObject(String propertyDefaultObject) {
        this.propertyDefaultObject = propertyDefaultObject;
    }

    public String getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(String primaryId) {
        this.primaryId = primaryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PropertyDefinitionObject that = (PropertyDefinitionObject) o;

        if (deletionAction != null ? !deletionAction.equals(that.deletionAction) : that.deletionAction != null)
            return false;
        if (primaryId != null ? !primaryId.equals(that.primaryId) : that.primaryId != null) return false;
        if (propertyDefaultObject != null ? !propertyDefaultObject.equals(that.propertyDefaultObject) : that.propertyDefaultObject != null)
            return false;
        if (reflectivePropertyId != null ? !reflectivePropertyId.equals(that.reflectivePropertyId) : that.reflectivePropertyId != null)
            return false;
        if (requiredClassId != null ? !requiredClassId.equals(that.requiredClassId) : that.requiredClassId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (requiredClassId != null ? requiredClassId.hashCode() : 0);
        result = 31 * result + (reflectivePropertyId != null ? reflectivePropertyId.hashCode() : 0);
        result = 31 * result + (deletionAction != null ? deletionAction.hashCode() : 0);
        result = 31 * result + (propertyDefaultObject != null ? propertyDefaultObject.hashCode() : 0);
        result = 31 * result + (primaryId != null ? primaryId.hashCode() : 0);
        return result;
    }
}
