package com.sitronics.filenet.folders.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 27.04.11 (18:03)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FolderProperties {
    @XmlElement(name = "ObjectType")
    private String objectType;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "SecurityPolicy")
    private String securityPolicy;
    @XmlElement(name = "Creator")
    private String creator;
    @XmlElement(name = "DateLastModified")
    private String dateLastModified;
    @XmlElement(name = "DateCreated")
    private String dateCreated;
    @XmlElement(name = "FolderName")
    private String folderName;
    @XmlElement(name = "ReplicationGroup")
    private String replicationGroup;
    @XmlElement(name = "Id")
    private String id;
    @XmlElement(name = "ContainerType")
    private String containerType;
    @XmlElement(name = "ExternalReplicaIdentities")
    private String externalReplicaIdentities;
    @XmlElement(name = "LastModifier")
    private String lastModifier;
    @XmlElement(name = "IsHiddenContainer")
    private String isHiddenContainer;
    @XmlElement(name = "InheritParentPermissions")
    private String inheritParentPermissions;
    @XmlElement(name = "Parent")
    private Parent parent;

    public FolderProperties() {
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecurityPolicy() {
        return securityPolicy;
    }

    public void setSecurityPolicy(String securityPolicy) {
        this.securityPolicy = securityPolicy;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(String dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getReplicationGroup() {
        return replicationGroup;
    }

    public void setReplicationGroup(String replicationGroup) {
        this.replicationGroup = replicationGroup;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getExternalReplicaIdentities() {
        return externalReplicaIdentities;
    }

    public void setExternalReplicaIdentities(String externalReplicaIdentities) {
        this.externalReplicaIdentities = externalReplicaIdentities;
    }

    public String getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(String lastModifier) {
        this.lastModifier = lastModifier;
    }

    public String getHiddenContainer() {
        return isHiddenContainer;
    }

    public void setHiddenContainer(String hiddenContainer) {
        isHiddenContainer = hiddenContainer;
    }

    public String getInheritParentPermissions() {
        return inheritParentPermissions;
    }

    public void setInheritParentPermissions(String inheritParentPermissions) {
        this.inheritParentPermissions = inheritParentPermissions;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FolderProperties that = (FolderProperties) o;

        if (containerType != null ? !containerType.equals(that.containerType) : that.containerType != null)
            return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        if (dateLastModified != null ? !dateLastModified.equals(that.dateLastModified) : that.dateLastModified != null)
            return false;
        if (externalReplicaIdentities != null ? !externalReplicaIdentities.equals(that.externalReplicaIdentities) : that.externalReplicaIdentities != null)
            return false;
        if (folderName != null ? !folderName.equals(that.folderName) : that.folderName != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (inheritParentPermissions != null ? !inheritParentPermissions.equals(that.inheritParentPermissions) : that.inheritParentPermissions != null)
            return false;
        if (isHiddenContainer != null ? !isHiddenContainer.equals(that.isHiddenContainer) : that.isHiddenContainer != null)
            return false;
        if (lastModifier != null ? !lastModifier.equals(that.lastModifier) : that.lastModifier != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (objectType != null ? !objectType.equals(that.objectType) : that.objectType != null) return false;
        if (parent != null ? !parent.equals(that.parent) : that.parent != null) return false;
        if (replicationGroup != null ? !replicationGroup.equals(that.replicationGroup) : that.replicationGroup != null)
            return false;
        if (securityPolicy != null ? !securityPolicy.equals(that.securityPolicy) : that.securityPolicy != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectType != null ? objectType.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (securityPolicy != null ? securityPolicy.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (dateLastModified != null ? dateLastModified.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (folderName != null ? folderName.hashCode() : 0);
        result = 31 * result + (replicationGroup != null ? replicationGroup.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (containerType != null ? containerType.hashCode() : 0);
        result = 31 * result + (externalReplicaIdentities != null ? externalReplicaIdentities.hashCode() : 0);
        result = 31 * result + (lastModifier != null ? lastModifier.hashCode() : 0);
        result = 31 * result + (isHiddenContainer != null ? isHiddenContainer.hashCode() : 0);
        result = 31 * result + (inheritParentPermissions != null ? inheritParentPermissions.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }
}
