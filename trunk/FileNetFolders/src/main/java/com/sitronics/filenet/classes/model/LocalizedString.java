package com.sitronics.filenet.classes.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 28.04.11 (14:54)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalizedString implements Cloneable {
    @XmlElement(name = "ObjectType")
    private String objectType;
    @XmlElement(name = "LocaleName")
    private String localeName;
    @XmlElement(name = "LocalizedText")
    private String localizedText;

    public LocalizedString() {
    }

    public LocalizedString(String objectType, String localeName, String localizedText) {
        this.objectType = objectType;
        this.localeName = localeName;
        this.localizedText = localizedText;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getLocaleName() {
        return localeName;
    }

    public void setLocaleName(String localeName) {
        this.localeName = localeName;
    }

    public String getLocalizedText() {
        return localizedText;
    }

    public void setLocalizedText(String localizedText) {
        this.localizedText = localizedText;
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

        LocalizedString that = (LocalizedString) o;

        if (localeName != null ? !localeName.equals(that.localeName) : that.localeName != null) return false;
        if (localizedText != null ? !localizedText.equals(that.localizedText) : that.localizedText != null)
            return false;
        if (objectType != null ? !objectType.equals(that.objectType) : that.objectType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectType != null ? objectType.hashCode() : 0;
        result = 31 * result + (localeName != null ? localeName.hashCode() : 0);
        result = 31 * result + (localizedText != null ? localizedText.hashCode() : 0);
        return result;
    }
}
