package com.sitronics.filenet.classes.model.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 29.04.11 (11:52)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Grantee {
    @XmlElement(name = "SID")
    private String sID;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "ShortName")
    private String shortName;
    @XmlElement(name = "DisplayName")
    private String displayName;
    @XmlElement(name = "PrincipalType")
    private String principalType;

    public Grantee() {
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPrincipalType() {
        return principalType;
    }

    public void setPrincipalType(String principalType) {
        this.principalType = principalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grantee grantee = (Grantee) o;

        if (displayName != null ? !displayName.equals(grantee.displayName) : grantee.displayName != null) return false;
        if (name != null ? !name.equals(grantee.name) : grantee.name != null) return false;
        if (principalType != null ? !principalType.equals(grantee.principalType) : grantee.principalType != null)
            return false;
        if (sID != null ? !sID.equals(grantee.sID) : grantee.sID != null) return false;
        if (shortName != null ? !shortName.equals(grantee.shortName) : grantee.shortName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sID != null ? sID.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (principalType != null ? principalType.hashCode() : 0);
        return result;
    }
}
