package com.sitronics.filenet.classes.model.property;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.sitronics.filenet.classes.model.DescriptiveTexts;
import com.sitronics.filenet.classes.model.DisplayNames;
import com.sitronics.filenet.classes.model.SuperclassDefinition;

/**
 * @author Andrey Popov creates on 28.04.11 (15:25)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ReplicableClassDefinitionProperties implements Cloneable {
    @XmlElement(name = "ObjectType")
    private String objectType;
    @XmlElement(name = "SymbolicName")
    private String symbolicName;
    @XmlElement(name = "Creator")
    private String creator;
    @XmlElement(name = "LastModifier")
    private String lastModifier;
    @XmlElement(name = "PropertyDefinitions")
    private PropertyDefinitions propertyDefinitions;
    @XmlElement(name = "ReplicationGroup")
    private String replicationGroup;
    @XmlElement(name = "IsCBREnabled")
    private String isCBREnabled;
    @XmlElement(name = "DisplayNames")
    private DisplayNames displayNames;
    @XmlElement(name = "AuditDefinitions")
    private String auditDefinitions;
    @XmlElement(name = "AliasIds")
    private String aliasIds;
    @XmlElement(name = "Id")
    private String id;
    @XmlElement(name = "DateCreated")
    private String dateCreated;
    @XmlElement(name = "DescriptiveTexts")
    private DescriptiveTexts descriptiveTexts;
    @XmlElement(name = "ExternalAliases")
    private String externalAliases;
    @XmlElement(name = "IsHidden")
    private String isHidden;
    @XmlElement(name = "ExternalReplicaIdentities")
    private String externalReplicaIdentities;
    @XmlElement(name = "SuperclassDefinition")
    private SuperclassDefinition superclassDefinition;
    @XmlElement(name = "DateLastModified")
    private String dateLastModified;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "AllowsInstances")
    private String allowsInstances;

    public ReplicableClassDefinitionProperties() {
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getSymbolicName() {
        return symbolicName;
    }

    public void setSymbolicName(String symbolicName) {
        this.symbolicName = symbolicName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(String lastModifier) {
        this.lastModifier = lastModifier;
    }

    public PropertyDefinitions getPropertyDefinitions() {
        return propertyDefinitions;
    }

    public void setPropertyDefinitions(PropertyDefinitions propertyDefinitions) {
        this.propertyDefinitions = propertyDefinitions;
    }

    public String getReplicationGroup() {
        return replicationGroup;
    }

    public void setReplicationGroup(String replicationGroup) {
        this.replicationGroup = replicationGroup;
    }

    public String getCBREnabled() {
        return isCBREnabled;
    }

    public void setCBREnabled(String CBREnabled) {
        isCBREnabled = CBREnabled;
    }

    public DisplayNames getDisplayNames() {
        return displayNames;
    }

    public void setDisplayNames(DisplayNames displayNames) {
        this.displayNames = displayNames;
    }

    public String getAuditDefinitions() {
        return auditDefinitions;
    }

    public void setAuditDefinitions(String auditDefinitions) {
        this.auditDefinitions = auditDefinitions;
    }

    public String getAliasIds() {
        return aliasIds;
    }

    public void setAliasIds(String aliasIds) {
        this.aliasIds = aliasIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public DescriptiveTexts getDescriptiveTexts() {
        return descriptiveTexts;
    }

    public void setDescriptiveTexts(DescriptiveTexts descriptiveTexts) {
        this.descriptiveTexts = descriptiveTexts;
    }

    public String getExternalAliases() {
        return externalAliases;
    }

    public void setExternalAliases(String externalAliases) {
        this.externalAliases = externalAliases;
    }

    public String getHidden() {
        return isHidden;
    }

    public void setHidden(String hidden) {
        isHidden = hidden;
    }

    public String getExternalReplicaIdentities() {
        return externalReplicaIdentities;
    }

    public void setExternalReplicaIdentities(String externalReplicaIdentities) {
        this.externalReplicaIdentities = externalReplicaIdentities;
    }

    public SuperclassDefinition getSuperclassDefinition() {
        return superclassDefinition;
    }

    public void setSuperclassDefinition(SuperclassDefinition superclassDefinition) {
        this.superclassDefinition = superclassDefinition;
    }

    public String getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(String dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAllowsInstances() {
        return allowsInstances;
    }

    public void setAllowsInstances(String allowsInstances) {
        this.allowsInstances = allowsInstances;
    }

    // Паблик Морозов..........
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReplicableClassDefinitionProperties that = (ReplicableClassDefinitionProperties) o;

        if (aliasIds != null ? !aliasIds.equals(that.aliasIds) : that.aliasIds != null) return false;
        if (allowsInstances != null ? !allowsInstances.equals(that.allowsInstances) : that.allowsInstances != null)
            return false;
        if (auditDefinitions != null ? !auditDefinitions.equals(that.auditDefinitions) : that.auditDefinitions != null)
            return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        if (dateLastModified != null ? !dateLastModified.equals(that.dateLastModified) : that.dateLastModified != null)
            return false;
        if (descriptiveTexts != null ? !descriptiveTexts.equals(that.descriptiveTexts) : that.descriptiveTexts != null)
            return false;
        if (displayNames != null ? !displayNames.equals(that.displayNames) : that.displayNames != null) return false;
        if (externalAliases != null ? !externalAliases.equals(that.externalAliases) : that.externalAliases != null)
            return false;
        if (externalReplicaIdentities != null ? !externalReplicaIdentities.equals(that.externalReplicaIdentities) : that.externalReplicaIdentities != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (isCBREnabled != null ? !isCBREnabled.equals(that.isCBREnabled) : that.isCBREnabled != null) return false;
        if (isHidden != null ? !isHidden.equals(that.isHidden) : that.isHidden != null) return false;
        if (lastModifier != null ? !lastModifier.equals(that.lastModifier) : that.lastModifier != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (objectType != null ? !objectType.equals(that.objectType) : that.objectType != null) return false;
        if (propertyDefinitions != null ? !propertyDefinitions.equals(that.propertyDefinitions) : that.propertyDefinitions != null)
            return false;
        if (replicationGroup != null ? !replicationGroup.equals(that.replicationGroup) : that.replicationGroup != null)
            return false;
        if (superclassDefinition != null ? !superclassDefinition.equals(that.superclassDefinition) : that.superclassDefinition != null)
            return false;
        if (symbolicName != null ? !symbolicName.equals(that.symbolicName) : that.symbolicName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectType != null ? objectType.hashCode() : 0;
        result = 31 * result + (symbolicName != null ? symbolicName.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (lastModifier != null ? lastModifier.hashCode() : 0);
        result = 31 * result + (propertyDefinitions != null ? propertyDefinitions.hashCode() : 0);
        result = 31 * result + (replicationGroup != null ? replicationGroup.hashCode() : 0);
        result = 31 * result + (isCBREnabled != null ? isCBREnabled.hashCode() : 0);
        result = 31 * result + (displayNames != null ? displayNames.hashCode() : 0);
        result = 31 * result + (auditDefinitions != null ? auditDefinitions.hashCode() : 0);
        result = 31 * result + (aliasIds != null ? aliasIds.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (descriptiveTexts != null ? descriptiveTexts.hashCode() : 0);
        result = 31 * result + (externalAliases != null ? externalAliases.hashCode() : 0);
        result = 31 * result + (isHidden != null ? isHidden.hashCode() : 0);
        result = 31 * result + (externalReplicaIdentities != null ? externalReplicaIdentities.hashCode() : 0);
        result = 31 * result + (superclassDefinition != null ? superclassDefinition.hashCode() : 0);
        result = 31 * result + (dateLastModified != null ? dateLastModified.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (allowsInstances != null ? allowsInstances.hashCode() : 0);
        return result;
    }
}
