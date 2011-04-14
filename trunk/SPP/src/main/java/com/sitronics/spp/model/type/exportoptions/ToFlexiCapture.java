package com.sitronics.spp.model.type.exportoptions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 14.04.11 (11:38)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ToFlexiCapture extends ExportOptionBase {
    @XmlElement(name = "LocalProjectPath")
    private String localProjectPath;
    @XmlElement(name = "BatchTypeID")
    private Integer batchTypeID;
    @XmlElement(name = "BatchName")
    private String batchName;
    @XmlElement(name = "BatchDescription")
    private String batchDescription;
    @XmlElement(name = "SpecifyRegistrationParameters")
    private Boolean specifyRegistrationParameters;

    public ToFlexiCapture() {
    }

    public String getLocalProjectPath() {
        return localProjectPath;
    }

    public void setLocalProjectPath(String localProjectPath) {
        this.localProjectPath = localProjectPath;
    }

    public Integer getBatchTypeID() {
        return batchTypeID;
    }

    public void setBatchTypeID(Integer batchTypeID) {
        this.batchTypeID = batchTypeID;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBatchDescription() {
        return batchDescription;
    }

    public void setBatchDescription(String batchDescription) {
        this.batchDescription = batchDescription;
    }

    public Boolean getSpecifyRegistrationParameters() {
        return specifyRegistrationParameters;
    }

    public void setSpecifyRegistrationParameters(Boolean specifyRegistrationParameters) {
        this.specifyRegistrationParameters = specifyRegistrationParameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ToFlexiCapture that = (ToFlexiCapture) o;

        if (batchDescription != null ? !batchDescription.equals(that.batchDescription) : that.batchDescription != null)
            return false;
        if (batchName != null ? !batchName.equals(that.batchName) : that.batchName != null) return false;
        if (batchTypeID != null ? !batchTypeID.equals(that.batchTypeID) : that.batchTypeID != null) return false;
        if (localProjectPath != null ? !localProjectPath.equals(that.localProjectPath) : that.localProjectPath != null)
            return false;
        if (specifyRegistrationParameters != null ? !specifyRegistrationParameters.equals(that.specifyRegistrationParameters) : that.specifyRegistrationParameters != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (localProjectPath != null ? localProjectPath.hashCode() : 0);
        result = 31 * result + (batchTypeID != null ? batchTypeID.hashCode() : 0);
        result = 31 * result + (batchName != null ? batchName.hashCode() : 0);
        result = 31 * result + (batchDescription != null ? batchDescription.hashCode() : 0);
        result = 31 * result + (specifyRegistrationParameters != null ? specifyRegistrationParameters.hashCode() : 0);
        return result;
    }
}
