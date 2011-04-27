package com.sitronics.filenet.folders.model;

import javax.xml.bind.annotation.*;

/**
 * @author Andrey Popov creates on 27.04.11 (18:04)
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ExportedObjects")
public class ExportedObjects {
    @XmlElement(name = "Folders")
    private Folders folders;
    @XmlAttribute(name = "EMVersion")
    private String eMVersion;

    public ExportedObjects() {
    }

    public ExportedObjects(Folders folders) {
        this.folders = folders;
    }

    public ExportedObjects(String eMVersion) {
        this.eMVersion = eMVersion;
    }

    public ExportedObjects(Folders folders, String eMVersion) {
        this.folders = folders;
        this.eMVersion = eMVersion;
    }

    public Folders getFolders() {
        return folders;
    }

    public void setFolders(Folders folders) {
        this.folders = folders;
    }

    public String geteMVersion() {
        return eMVersion;
    }

    public void seteMVersion(String eMVersion) {
        this.eMVersion = eMVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExportedObjects that = (ExportedObjects) o;

        if (eMVersion != null ? !eMVersion.equals(that.eMVersion) : that.eMVersion != null) return false;
        if (folders != null ? !folders.equals(that.folders) : that.folders != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = folders != null ? folders.hashCode() : 0;
        result = 31 * result + (eMVersion != null ? eMVersion.hashCode() : 0);
        return result;
    }
}
