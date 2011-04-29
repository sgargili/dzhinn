package com.sitronics.filenet.classes.model;

import javax.xml.bind.annotation.*;

/**
 * @author Andrey Popov creates on 28.04.11 (15:40)
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ExportedObjects")
public class ExportedObjects {
    @XmlAttribute(name = "EMVersion")
    private String eMVersion;
    @XmlElement(name = "LifeCycleActions")
    private String lifeCycleActions;
    @XmlElement(name = "LifeCyclePolicies")
    private String lifeCyclePolicies;
    @XmlElement(name = "ChoiceLists")
    private String choiceLists;
    @XmlElement(name = "PropertyTemplates")
    private String propertyTemplates;
    @XmlElement(name = "ClassDefinitions")
    private ClassDefinitions classDefinitions;

    public ExportedObjects() {
    }

    public String geteMVersion() {
        return eMVersion;
    }

    public void seteMVersion(String eMVersion) {
        this.eMVersion = eMVersion;
    }

    public String getLifeCycleActions() {
        return lifeCycleActions;
    }

    public void setLifeCycleActions(String lifeCycleActions) {
        this.lifeCycleActions = lifeCycleActions;
    }

    public String getLifeCyclePolicies() {
        return lifeCyclePolicies;
    }

    public void setLifeCyclePolicies(String lifeCyclePolicies) {
        this.lifeCyclePolicies = lifeCyclePolicies;
    }

    public String getChoiceLists() {
        return choiceLists;
    }

    public void setChoiceLists(String choiceLists) {
        this.choiceLists = choiceLists;
    }

    public String getPropertyTemplates() {
        return propertyTemplates;
    }

    public void setPropertyTemplates(String propertyTemplates) {
        this.propertyTemplates = propertyTemplates;
    }

    public ClassDefinitions getClassDefinitions() {
        return classDefinitions;
    }

    public void setClassDefinitions(ClassDefinitions classDefinitions) {
        this.classDefinitions = classDefinitions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExportedObjects that = (ExportedObjects) o;

        if (choiceLists != null ? !choiceLists.equals(that.choiceLists) : that.choiceLists != null) return false;
        if (classDefinitions != null ? !classDefinitions.equals(that.classDefinitions) : that.classDefinitions != null)
            return false;
        if (eMVersion != null ? !eMVersion.equals(that.eMVersion) : that.eMVersion != null) return false;
        if (lifeCycleActions != null ? !lifeCycleActions.equals(that.lifeCycleActions) : that.lifeCycleActions != null)
            return false;
        if (lifeCyclePolicies != null ? !lifeCyclePolicies.equals(that.lifeCyclePolicies) : that.lifeCyclePolicies != null)
            return false;
        if (propertyTemplates != null ? !propertyTemplates.equals(that.propertyTemplates) : that.propertyTemplates != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eMVersion != null ? eMVersion.hashCode() : 0;
        result = 31 * result + (lifeCycleActions != null ? lifeCycleActions.hashCode() : 0);
        result = 31 * result + (lifeCyclePolicies != null ? lifeCyclePolicies.hashCode() : 0);
        result = 31 * result + (choiceLists != null ? choiceLists.hashCode() : 0);
        result = 31 * result + (propertyTemplates != null ? propertyTemplates.hashCode() : 0);
        result = 31 * result + (classDefinitions != null ? classDefinitions.hashCode() : 0);
        return result;
    }
}
