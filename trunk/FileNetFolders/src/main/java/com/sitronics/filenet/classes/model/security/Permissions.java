package com.sitronics.filenet.classes.model.security;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.sitronics.filenet.classes.model.ReplicableClassDefinition;

/**
 * @author Andrey Popov creates on 29.04.11 (11:59)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Permissions {
    @XmlElement(name = "AccessPermission")
    private List<AccessPermission> accessPermissions = new ArrayList<AccessPermission>();

    public Permissions() {
    }

    public List<AccessPermission> getAccessPermissions() {
        return accessPermissions;
    }

    public void setAccessPermissions(List<AccessPermission> accessPermissions) {
        this.accessPermissions = accessPermissions;
    }

    public void addAccessPermission(AccessPermission accessPermission) {
        this.accessPermissions.add(accessPermission);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permissions that = (Permissions) o;

        if (accessPermissions != null ? !accessPermissions.equals(that.accessPermissions) : that.accessPermissions != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return accessPermissions != null ? accessPermissions.hashCode() : 0;
    }
}
