package com.sitronics.filenet.classes.model.property;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 28.04.11 (15:15)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PropertyDefinitionBoolean extends PropertyDefinitionBase {
    @XmlElement(name = "IsNameProperty")
    private String isNameProperty;
    @XmlElement(name = "Settability")
    private String settability;
    @XmlElement(name = "ExternalAliases")
    private String externalAliases;
    @XmlElement(name = "ModificationAccessRequired")
    private String modificationAccessRequired;
    @XmlElement(name = "IsValueRequired")
    private String isValueRequired;
    @XmlElement(name = "CopyToReservation")
    private String copyToReservation;
    @XmlElement(name = "PrimaryId")
    private String primaryId;
    @XmlElement(name = "ChoiceList")
    private String choiceList;
    @XmlElement(name = "AliasIds")
    private String aliasIds;
    @XmlElement(name = "PropertyDefaultBoolean")
    private String propertyDefaultBoolean;
    @XmlElement(name = "IsHidden")
    private String isHidden;

    public PropertyDefinitionBoolean() {
    }

    public String getNameProperty() {
        return isNameProperty;
    }

    public void setNameProperty(String nameProperty) {
        isNameProperty = nameProperty;
    }

    public String getSettability() {
        return settability;
    }

    public void setSettability(String settability) {
        this.settability = settability;
    }

    public String getExternalAliases() {
        return externalAliases;
    }

    public void setExternalAliases(String externalAliases) {
        this.externalAliases = externalAliases;
    }

    public String getModificationAccessRequired() {
        return modificationAccessRequired;
    }

    public void setModificationAccessRequired(String modificationAccessRequired) {
        this.modificationAccessRequired = modificationAccessRequired;
    }

    public String getValueRequired() {
        return isValueRequired;
    }

    public void setValueRequired(String valueRequired) {
        isValueRequired = valueRequired;
    }

    public String getCopyToReservation() {
        return copyToReservation;
    }

    public void setCopyToReservation(String copyToReservation) {
        this.copyToReservation = copyToReservation;
    }

    public String getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(String primaryId) {
        this.primaryId = primaryId;
    }

    public String getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(String choiceList) {
        this.choiceList = choiceList;
    }

    public String getAliasIds() {
        return aliasIds;
    }

    public void setAliasIds(String aliasIds) {
        this.aliasIds = aliasIds;
    }

    public String getPropertyDefaultBoolean() {
        return propertyDefaultBoolean;
    }

    public void setPropertyDefaultBoolean(String propertyDefaultBoolean) {
        this.propertyDefaultBoolean = propertyDefaultBoolean;
    }

    public String getHidden() {
        return isHidden;
    }

    public void setHidden(String hidden) {
        isHidden = hidden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PropertyDefinitionBoolean that = (PropertyDefinitionBoolean) o;

        if (aliasIds != null ? !aliasIds.equals(that.aliasIds) : that.aliasIds != null) return false;
        if (choiceList != null ? !choiceList.equals(that.choiceList) : that.choiceList != null) return false;
        if (copyToReservation != null ? !copyToReservation.equals(that.copyToReservation) : that.copyToReservation != null)
            return false;
        if (externalAliases != null ? !externalAliases.equals(that.externalAliases) : that.externalAliases != null)
            return false;
        if (isHidden != null ? !isHidden.equals(that.isHidden) : that.isHidden != null) return false;
        if (isNameProperty != null ? !isNameProperty.equals(that.isNameProperty) : that.isNameProperty != null)
            return false;
        if (isValueRequired != null ? !isValueRequired.equals(that.isValueRequired) : that.isValueRequired != null)
            return false;
        if (modificationAccessRequired != null ? !modificationAccessRequired.equals(that.modificationAccessRequired) : that.modificationAccessRequired != null)
            return false;
        if (primaryId != null ? !primaryId.equals(that.primaryId) : that.primaryId != null) return false;
        if (propertyDefaultBoolean != null ? !propertyDefaultBoolean.equals(that.propertyDefaultBoolean) : that.propertyDefaultBoolean != null)
            return false;
        if (settability != null ? !settability.equals(that.settability) : that.settability != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isNameProperty != null ? isNameProperty.hashCode() : 0);
        result = 31 * result + (settability != null ? settability.hashCode() : 0);
        result = 31 * result + (externalAliases != null ? externalAliases.hashCode() : 0);
        result = 31 * result + (modificationAccessRequired != null ? modificationAccessRequired.hashCode() : 0);
        result = 31 * result + (isValueRequired != null ? isValueRequired.hashCode() : 0);
        result = 31 * result + (copyToReservation != null ? copyToReservation.hashCode() : 0);
        result = 31 * result + (primaryId != null ? primaryId.hashCode() : 0);
        result = 31 * result + (choiceList != null ? choiceList.hashCode() : 0);
        result = 31 * result + (aliasIds != null ? aliasIds.hashCode() : 0);
        result = 31 * result + (propertyDefaultBoolean != null ? propertyDefaultBoolean.hashCode() : 0);
        result = 31 * result + (isHidden != null ? isHidden.hashCode() : 0);
        return result;
    }
}
