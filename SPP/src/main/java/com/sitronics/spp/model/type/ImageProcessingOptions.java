package com.sitronics.spp.model.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 14.04.11 (11:16)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageProcessingOptions {
    @XmlAttribute(name = "ImageRotationType")
    private String imageRotationType;
    @XmlElement(name = "Despeckle")
    private Boolean despeckle;
    @XmlElement(name = "Deskew")
    private Boolean deskew;
    @XmlElement(name = "DeskewBySeparators")
    private Boolean deskewBySeparators;
    @XmlElement(name = "DeskewBySquares")
    private Boolean deskewBySquares;
    @XmlElement(name = "RotateImages")
    private Boolean rotateImages;
    @XmlElement(name = "ConvertToBW")
    private Boolean convertToBW;

    public ImageProcessingOptions() {
    }

    public String getImageRotationType() {
        return imageRotationType;
    }

    public void setImageRotationType(String imageRotationType) {
        this.imageRotationType = imageRotationType;
    }

    public Boolean getDespeckle() {
        return despeckle;
    }

    public void setDespeckle(Boolean despeckle) {
        this.despeckle = despeckle;
    }

    public Boolean getDeskew() {
        return deskew;
    }

    public void setDeskew(Boolean deskew) {
        this.deskew = deskew;
    }

    public Boolean getDeskewBySeparators() {
        return deskewBySeparators;
    }

    public void setDeskewBySeparators(Boolean deskewBySeparators) {
        this.deskewBySeparators = deskewBySeparators;
    }

    public Boolean getDeskewBySquares() {
        return deskewBySquares;
    }

    public void setDeskewBySquares(Boolean deskewBySquares) {
        this.deskewBySquares = deskewBySquares;
    }

    public Boolean getRotateImages() {
        return rotateImages;
    }

    public void setRotateImages(Boolean rotateImages) {
        this.rotateImages = rotateImages;
    }

    public Boolean getConvertToBW() {
        return convertToBW;
    }

    public void setConvertToBW(Boolean convertToBW) {
        this.convertToBW = convertToBW;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageProcessingOptions that = (ImageProcessingOptions) o;

        if (convertToBW != null ? !convertToBW.equals(that.convertToBW) : that.convertToBW != null) return false;
        if (deskew != null ? !deskew.equals(that.deskew) : that.deskew != null) return false;
        if (deskewBySeparators != null ? !deskewBySeparators.equals(that.deskewBySeparators) : that.deskewBySeparators != null)
            return false;
        if (deskewBySquares != null ? !deskewBySquares.equals(that.deskewBySquares) : that.deskewBySquares != null)
            return false;
        if (despeckle != null ? !despeckle.equals(that.despeckle) : that.despeckle != null) return false;
        if (imageRotationType != null ? !imageRotationType.equals(that.imageRotationType) : that.imageRotationType != null)
            return false;
        if (rotateImages != null ? !rotateImages.equals(that.rotateImages) : that.rotateImages != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imageRotationType != null ? imageRotationType.hashCode() : 0;
        result = 31 * result + (despeckle != null ? despeckle.hashCode() : 0);
        result = 31 * result + (deskew != null ? deskew.hashCode() : 0);
        result = 31 * result + (deskewBySeparators != null ? deskewBySeparators.hashCode() : 0);
        result = 31 * result + (deskewBySquares != null ? deskewBySquares.hashCode() : 0);
        result = 31 * result + (rotateImages != null ? rotateImages.hashCode() : 0);
        result = 31 * result + (convertToBW != null ? convertToBW.hashCode() : 0);
        return result;
    }
}
