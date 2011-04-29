package com.sitronics.filenet.classes.model.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 29.04.11 (12:04)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ReplicableClassDefinitionSecurity implements Cloneable {
    @XmlElement(name = "Owner")
    private Grantee owner;
    @XmlElement(name = "DefaultInstanceOwner")
    private Grantee defaultInstanceOwner;
    @XmlElement(name = "Permissions")
    private Permissions permissions;
    @XmlElement(name = "DefaultInstancePermissions")
    private Permissions defaultInstancePermissions;

    public ReplicableClassDefinitionSecurity() {
    }

    public Grantee getOwner() {
        return owner;
    }

    public void setOwner(Grantee owner) {
        this.owner = owner;
    }

    public Grantee getDefaultInstanceOwner() {
        return defaultInstanceOwner;
    }

    public void setDefaultInstanceOwner(Grantee defaultInstanceOwner) {
        this.defaultInstanceOwner = defaultInstanceOwner;
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    public Permissions getDefaultInstancePermissions() {
        return defaultInstancePermissions;
    }

    public void setDefaultInstancePermissions(Permissions defaultInstancePermissions) {
        this.defaultInstancePermissions = defaultInstancePermissions;
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

        ReplicableClassDefinitionSecurity that = (ReplicableClassDefinitionSecurity) o;

        if (defaultInstanceOwner != null ? !defaultInstanceOwner.equals(that.defaultInstanceOwner) : that.defaultInstanceOwner != null)
            return false;
        if (defaultInstancePermissions != null ? !defaultInstancePermissions.equals(that.defaultInstancePermissions) : that.defaultInstancePermissions != null)
            return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (permissions != null ? !permissions.equals(that.permissions) : that.permissions != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = owner != null ? owner.hashCode() : 0;
        result = 31 * result + (defaultInstanceOwner != null ? defaultInstanceOwner.hashCode() : 0);
        result = 31 * result + (permissions != null ? permissions.hashCode() : 0);
        result = 31 * result + (defaultInstancePermissions != null ? defaultInstancePermissions.hashCode() : 0);
        return result;
    }
}
