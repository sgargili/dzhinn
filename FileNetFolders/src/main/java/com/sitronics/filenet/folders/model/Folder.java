package com.sitronics.filenet.folders.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 27.04.11 (18:02)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Folder {
    @XmlElement(name = "FolderProperties")
    private FolderProperties folderProperties;

    public Folder() {
    }

    public Folder(FolderProperties folderProperties) {
        this.folderProperties = folderProperties;
    }

    public FolderProperties getFolderProperties() {
        return folderProperties;
    }

    public void setFolderProperties(FolderProperties folderProperties) {
        this.folderProperties = folderProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Folder folder = (Folder) o;

        if (folderProperties != null ? !folderProperties.equals(folder.folderProperties) : folder.folderProperties != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return folderProperties != null ? folderProperties.hashCode() : 0;
    }
}
