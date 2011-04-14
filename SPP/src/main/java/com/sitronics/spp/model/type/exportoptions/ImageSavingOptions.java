package com.sitronics.spp.model.type.exportoptions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Andrey Popov creates on 14.04.11 (11:29)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageSavingOptions {
    @XmlAttribute(name = "Format")
    private String format;
    @XmlAttribute(name = "Color")
    private String color;
    @XmlAttribute(name = "Quality")
    private String quality;
    @XmlAttribute(name = "AsMultipageFile")
    private String asMultipageFile;

    public ImageSavingOptions() {
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getAsMultipageFile() {
        return asMultipageFile;
    }

    public void setAsMultipageFile(String asMultipageFile) {
        this.asMultipageFile = asMultipageFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageSavingOptions that = (ImageSavingOptions) o;

        if (asMultipageFile != null ? !asMultipageFile.equals(that.asMultipageFile) : that.asMultipageFile != null)
            return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (format != null ? !format.equals(that.format) : that.format != null) return false;
        if (quality != null ? !quality.equals(that.quality) : that.quality != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = format != null ? format.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (quality != null ? quality.hashCode() : 0);
        result = 31 * result + (asMultipageFile != null ? asMultipageFile.hashCode() : 0);
        return result;
    }
}
