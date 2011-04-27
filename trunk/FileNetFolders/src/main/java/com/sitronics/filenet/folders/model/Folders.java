package com.sitronics.filenet.folders.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 27.04.11 (18:03)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Folders {
    @XmlElement(name = "Folder")
    private List<Folder> folders = new ArrayList<Folder>();

    public Folders() {
    }

    public Folders(List<Folder> folders) {
        this.folders = folders;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public void addFolder(Folder folder) {
        this.folders.add(folder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Folders folders1 = (Folders) o;

        if (folders != null ? !folders.equals(folders1.folders) : folders1.folders != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return folders != null ? folders.hashCode() : 0;
    }
}
