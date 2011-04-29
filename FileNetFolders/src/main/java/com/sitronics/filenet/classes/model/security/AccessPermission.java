package com.sitronics.filenet.classes.model.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 29.04.11 (11:56)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessPermission {
    @XmlElement(name = "Grantee")
    private Grantee grantee;
    @XmlElement(name = "AccessType")
    private String accessType;
    @XmlElement(name = "InheritableDepth")
    private String inheritableDepth;
    @XmlElement(name = "AccessMask")
    private String accessMask;
    @XmlElement(name = "PermissionSource")
    private String permissionSource;

    public AccessPermission() {
    }

    public Grantee getGrantee() {
        return grantee;
    }

    public void setGrantee(Grantee grantee) {
        this.grantee = grantee;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getInheritableDepth() {
        return inheritableDepth;
    }

    public void setInheritableDepth(String inheritableDepth) {
        this.inheritableDepth = inheritableDepth;
    }

    public String getAccessMask() {
        return accessMask;
    }

    public void setAccessMask(String accessMask) {
        this.accessMask = accessMask;
    }

    public String getPermissionSource() {
        return permissionSource;
    }

    public void setPermissionSource(String permissionSource) {
        this.permissionSource = permissionSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccessPermission that = (AccessPermission) o;

        if (accessMask != null ? !accessMask.equals(that.accessMask) : that.accessMask != null) return false;
        if (accessType != null ? !accessType.equals(that.accessType) : that.accessType != null) return false;
        if (grantee != null ? !grantee.equals(that.grantee) : that.grantee != null) return false;
        if (inheritableDepth != null ? !inheritableDepth.equals(that.inheritableDepth) : that.inheritableDepth != null)
            return false;
        if (permissionSource != null ? !permissionSource.equals(that.permissionSource) : that.permissionSource != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = grantee != null ? grantee.hashCode() : 0;
        result = 31 * result + (accessType != null ? accessType.hashCode() : 0);
        result = 31 * result + (inheritableDepth != null ? inheritableDepth.hashCode() : 0);
        result = 31 * result + (accessMask != null ? accessMask.hashCode() : 0);
        result = 31 * result + (permissionSource != null ? permissionSource.hashCode() : 0);
        return result;
    }
}
