package com.sitronics.filenet.classes.model.property;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 28.04.11 (15:09)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PropertyDefinitionString extends PropertyDefinitionBase {
    @XmlElement(name = "IsNameProperty")
    private String isNameProperty;
    @XmlElement(name = "MaximumLengthString")
    private String maximumLengthString;
    @XmlElement(name = "PropertyDefaultString")
    private String propertyDefaultString;
    @XmlElement(name = "Settability")
    private String settability;
    @XmlElement(name = "ExternalAliases")
    private String externalAliases;
    @XmlElement(name = "IsValueRequired")
    private String isValueRequired;
    @XmlElement(name = "IsCBREnabled")
    private String isCBREnabled;
    @XmlElement(name = "ModificationAccessRequired")
    private String modificationAccessRequired;
    @XmlElement(name = "PrimaryId")
    private String primaryId;
    @XmlElement(name = "CopyToReservation")
    private String copyToReservation;
    @XmlElement(name = "ChoiceList")
    private String choiceList;
    @XmlElement(name = "AliasIds")
    private String aliasIds;
    @XmlElement(name = "IsHidden")
    private String isHidden;

    public PropertyDefinitionString() {
    }

    public String getNameProperty() {
        return isNameProperty;
    }

    public void setNameProperty(String nameProperty) {
        isNameProperty = nameProperty;
    }

    public String getMaximumLengthString() {
        return maximumLengthString;
    }

    public void setMaximumLengthString(String maximumLengthString) {
        this.maximumLengthString = maximumLengthString;
    }

    public String getPropertyDefaultString() {
        return propertyDefaultString;
    }

    public void setPropertyDefaultString(String propertyDefaultString) {
        this.propertyDefaultString = propertyDefaultString;
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

    public String getValueRequired() {
        return isValueRequired;
    }

    public void setValueRequired(String valueRequired) {
        isValueRequired = valueRequired;
    }

    public String getCBREnabled() {
        return isCBREnabled;
    }

    public void setCBREnabled(String CBREnabled) {
        isCBREnabled = CBREnabled;
    }

    public String getModificationAccessRequired() {
        return modificationAccessRequired;
    }

    public void setModificationAccessRequired(String modificationAccessRequired) {
        this.modificationAccessRequired = modificationAccessRequired;
    }

    public String getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(String primaryId) {
        this.primaryId = primaryId;
    }

    public String getCopyToReservation() {
        return copyToReservation;
    }

    public void setCopyToReservation(String copyToReservation) {
        this.copyToReservation = copyToReservation;
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

        PropertyDefinitionString that = (PropertyDefinitionString) o;

        if (aliasIds != null ? !aliasIds.equals(that.aliasIds) : that.aliasIds != null) return false;
        if (choiceList != null ? !choiceList.equals(that.choiceList) : that.choiceList != null) return false;
        if (copyToReservation != null ? !copyToReservation.equals(that.copyToReservation) : that.copyToReservation != null)
            return false;
        if (externalAliases != null ? !externalAliases.equals(that.externalAliases) : that.externalAliases != null)
            return false;
        if (isCBREnabled != null ? !isCBREnabled.equals(that.isCBREnabled) : that.isCBREnabled != null) return false;
        if (isHidden != null ? !isHidden.equals(that.isHidden) : that.isHidden != null) return false;
        if (isNameProperty != null ? !isNameProperty.equals(that.isNameProperty) : that.isNameProperty != null)
            return false;
        if (isValueRequired != null ? !isValueRequired.equals(that.isValueRequired) : that.isValueRequired != null)
            return false;
        if (maximumLengthString != null ? !maximumLengthString.equals(that.maximumLengthString) : that.maximumLengthString != null)
            return false;
        if (modificationAccessRequired != null ? !modificationAccessRequired.equals(that.modificationAccessRequired) : that.modificationAccessRequired != null)
            return false;
        if (primaryId != null ? !primaryId.equals(that.primaryId) : that.primaryId != null) return false;
        if (propertyDefaultString != null ? !propertyDefaultString.equals(that.propertyDefaultString) : that.propertyDefaultString != null)
            return false;
        if (settability != null ? !settability.equals(that.settability) : that.settability != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isNameProperty != null ? isNameProperty.hashCode() : 0);
        result = 31 * result + (maximumLengthString != null ? maximumLengthString.hashCode() : 0);
        result = 31 * result + (propertyDefaultString != null ? propertyDefaultString.hashCode() : 0);
        result = 31 * result + (settability != null ? settability.hashCode() : 0);
        result = 31 * result + (externalAliases != null ? externalAliases.hashCode() : 0);
        result = 31 * result + (isValueRequired != null ? isValueRequired.hashCode() : 0);
        result = 31 * result + (isCBREnabled != null ? isCBREnabled.hashCode() : 0);
        result = 31 * result + (modificationAccessRequired != null ? modificationAccessRequired.hashCode() : 0);
        result = 31 * result + (primaryId != null ? primaryId.hashCode() : 0);
        result = 31 * result + (copyToReservation != null ? copyToReservation.hashCode() : 0);
        result = 31 * result + (choiceList != null ? choiceList.hashCode() : 0);
        result = 31 * result + (aliasIds != null ? aliasIds.hashCode() : 0);
        result = 31 * result + (isHidden != null ? isHidden.hashCode() : 0);
        return result;
    }
}
