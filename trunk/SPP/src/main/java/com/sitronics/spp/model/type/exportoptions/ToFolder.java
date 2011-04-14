package com.sitronics.spp.model.type.exportoptions;

import javax.xml.bind.annotation.*;

/**
 * @author Andrey Popov creates on 14.04.11 (11:29)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ToFolder extends ExportOptionBase {
    @XmlElement(name = "Path")
    private String path;
    @XmlElement(name = "ImageSavingOptions")
    private ImageSavingOptions imageSavingOptions;

    public ToFolder() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ImageSavingOptions getImageSavingOptions() {
        return imageSavingOptions;
    }

    public void setImageSavingOptions(ImageSavingOptions imageSavingOptions) {
        this.imageSavingOptions = imageSavingOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ToFolder toFolder = (ToFolder) o;

        if (imageSavingOptions != null ? !imageSavingOptions.equals(toFolder.imageSavingOptions) : toFolder.imageSavingOptions != null)
            return false;
        if (path != null ? !path.equals(toFolder.path) : toFolder.path != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (imageSavingOptions != null ? imageSavingOptions.hashCode() : 0);
        return result;
    }
}
