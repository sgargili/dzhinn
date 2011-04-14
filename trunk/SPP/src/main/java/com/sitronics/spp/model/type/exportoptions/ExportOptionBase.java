package com.sitronics.spp.model.type.exportoptions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 14.04.11 (11:26)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportOptionBase {
    @XmlElement(name = "BatchTypeName")
    private String batchTypeName;
    @XmlAttribute(name = "ShowBeforeExport")
    private Boolean showBeforeExport;

    public ExportOptionBase() {
    }

    public String getBatchTypeName() {
        return batchTypeName;
    }

    public void setBatchTypeName(String batchTypeName) {
        this.batchTypeName = batchTypeName;
    }

    public Boolean getShowBeforeExport() {
        return showBeforeExport;
    }

    public void setShowBeforeExport(Boolean showBeforeExport) {
        this.showBeforeExport = showBeforeExport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExportOptionBase that = (ExportOptionBase) o;

        if (batchTypeName != null ? !batchTypeName.equals(that.batchTypeName) : that.batchTypeName != null)
            return false;
        if (showBeforeExport != null ? !showBeforeExport.equals(that.showBeforeExport) : that.showBeforeExport != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = batchTypeName != null ? batchTypeName.hashCode() : 0;
        result = 31 * result + (showBeforeExport != null ? showBeforeExport.hashCode() : 0);
        return result;
    }
}
