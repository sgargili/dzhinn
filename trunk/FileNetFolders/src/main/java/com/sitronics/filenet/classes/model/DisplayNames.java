package com.sitronics.filenet.classes.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 28.04.11 (14:58)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DisplayNames {
    @XmlElement(name = "LocalizedString")
    private LocalizedString localizedString;

    public DisplayNames() {
    }

    public DisplayNames(LocalizedString localizedString) {
        this.localizedString = localizedString;
    }

    public LocalizedString getLocalizedString() {
        return localizedString;
    }

    public void setLocalizedString(LocalizedString localizedString) {
        this.localizedString = localizedString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DisplayNames that = (DisplayNames) o;

        if (localizedString != null ? !localizedString.equals(that.localizedString) : that.localizedString != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return localizedString != null ? localizedString.hashCode() : 0;
    }

}
