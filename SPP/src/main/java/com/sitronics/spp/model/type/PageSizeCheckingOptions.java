package com.sitronics.spp.model.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 14.04.11 (11:20)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PageSizeCheckingOptions {
    @XmlAttribute(name = "CheckResolution")
    private Boolean checkResolution;
    @XmlAttribute(name = "CheckWidth")
    private Boolean checkWidth;
    @XmlAttribute(name = "CheckHeight")
    private Boolean checkHeight;

    @XmlElement(name = "MinResolution")
    private Integer minResolution;
    @XmlElement(name = "MaxResolution")
    private Integer maxResolution;
    @XmlElement(name = "MinWidth")
    private Integer minWidth;
    @XmlElement(name = "MaxWidth")
    private Integer maxWidth;
    @XmlElement(name = "MinHeight")
    private Integer minHeight;
    @XmlElement(name = "MaxHeight")
    private Integer maxHeight;

    public PageSizeCheckingOptions() {
    }

    public Boolean getCheckResolution() {
        return checkResolution;
    }

    public void setCheckResolution(Boolean checkResolution) {
        this.checkResolution = checkResolution;
    }

    public Boolean getCheckWidth() {
        return checkWidth;
    }

    public void setCheckWidth(Boolean checkWidth) {
        this.checkWidth = checkWidth;
    }

    public Boolean getCheckHeight() {
        return checkHeight;
    }

    public void setCheckHeight(Boolean checkHeight) {
        this.checkHeight = checkHeight;
    }

    public Integer getMinResolution() {
        return minResolution;
    }

    public void setMinResolution(Integer minResolution) {
        this.minResolution = minResolution;
    }

    public Integer getMaxResolution() {
        return maxResolution;
    }

    public void setMaxResolution(Integer maxResolution) {
        this.maxResolution = maxResolution;
    }

    public Integer getMinWidth() {
        return minWidth;
    }

    public void setMinWidth(Integer minWidth) {
        this.minWidth = minWidth;
    }

    public Integer getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
    }

    public Integer getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(Integer minHeight) {
        this.minHeight = minHeight;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageSizeCheckingOptions that = (PageSizeCheckingOptions) o;

        if (checkHeight != null ? !checkHeight.equals(that.checkHeight) : that.checkHeight != null) return false;
        if (checkResolution != null ? !checkResolution.equals(that.checkResolution) : that.checkResolution != null)
            return false;
        if (checkWidth != null ? !checkWidth.equals(that.checkWidth) : that.checkWidth != null) return false;
        if (maxHeight != null ? !maxHeight.equals(that.maxHeight) : that.maxHeight != null) return false;
        if (maxResolution != null ? !maxResolution.equals(that.maxResolution) : that.maxResolution != null)
            return false;
        if (maxWidth != null ? !maxWidth.equals(that.maxWidth) : that.maxWidth != null) return false;
        if (minHeight != null ? !minHeight.equals(that.minHeight) : that.minHeight != null) return false;
        if (minResolution != null ? !minResolution.equals(that.minResolution) : that.minResolution != null)
            return false;
        if (minWidth != null ? !minWidth.equals(that.minWidth) : that.minWidth != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = checkResolution != null ? checkResolution.hashCode() : 0;
        result = 31 * result + (checkWidth != null ? checkWidth.hashCode() : 0);
        result = 31 * result + (checkHeight != null ? checkHeight.hashCode() : 0);
        result = 31 * result + (minResolution != null ? minResolution.hashCode() : 0);
        result = 31 * result + (maxResolution != null ? maxResolution.hashCode() : 0);
        result = 31 * result + (minWidth != null ? minWidth.hashCode() : 0);
        result = 31 * result + (maxWidth != null ? maxWidth.hashCode() : 0);
        result = 31 * result + (minHeight != null ? minHeight.hashCode() : 0);
        result = 31 * result + (maxHeight != null ? maxHeight.hashCode() : 0);
        return result;
    }
}
