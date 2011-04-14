package com.sitronics.spp.model.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 14.04.11 (11:12)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SeparationOptions {
    @XmlAttribute(name = "BatchSeparationType")
    private String batchSeparationType;
    @XmlAttribute(name = "BatchSeparationEvent")
    private String batchSeparationEvent;
    @XmlAttribute(name = "DocSeparationType")
    private String docSeparationType;
    @XmlAttribute(name = "DocSeparationEvent")
    private String docSeparationEvent;

    @XmlElement(name = "BatchNamingSchema")
    private String batchNamingSchema;
    @XmlElement(name = "PagesInBatchCount")
    private Integer pagesInBatchCount;
    @XmlElement(name = "DocumentNamingSchema")
    private String documentNamingSchema;
    @XmlElement(name = "PagesInDocCount")
    private Integer pagesInDocCount;
    @XmlElement(name = "DeleteSeparationPages")
    private Boolean deleteSeparationPages;
    @XmlElement(name = "BarcodeType")
    private String barcodeType;
    @XmlElement(name = "BarcodeValue")
    private String barcodeValue;
    @XmlElement(name = "AutodetectKernelRect")
    private Boolean autodetectKernelRect;
    @XmlElement(name = "SeparationOptions")
    private SeparationOptions separationOptions;

    public SeparationOptions() {
    }

    public String getBatchSeparationType() {
        return batchSeparationType;
    }

    public void setBatchSeparationType(String batchSeparationType) {
        this.batchSeparationType = batchSeparationType;
    }

    public String getBatchSeparationEvent() {
        return batchSeparationEvent;
    }

    public void setBatchSeparationEvent(String batchSeparationEvent) {
        this.batchSeparationEvent = batchSeparationEvent;
    }

    public String getDocSeparationType() {
        return docSeparationType;
    }

    public void setDocSeparationType(String docSeparationType) {
        this.docSeparationType = docSeparationType;
    }

    public String getDocSeparationEvent() {
        return docSeparationEvent;
    }

    public void setDocSeparationEvent(String docSeparationEvent) {
        this.docSeparationEvent = docSeparationEvent;
    }

    public String getBatchNamingSchema() {
        return batchNamingSchema;
    }

    public void setBatchNamingSchema(String batchNamingSchema) {
        this.batchNamingSchema = batchNamingSchema;
    }

    public Integer getPagesInBatchCount() {
        return pagesInBatchCount;
    }

    public void setPagesInBatchCount(Integer pagesInBatchCount) {
        this.pagesInBatchCount = pagesInBatchCount;
    }

    public String getDocumentNamingSchema() {
        return documentNamingSchema;
    }

    public void setDocumentNamingSchema(String documentNamingSchema) {
        this.documentNamingSchema = documentNamingSchema;
    }

    public Integer getPagesInDocCount() {
        return pagesInDocCount;
    }

    public void setPagesInDocCount(Integer pagesInDocCount) {
        this.pagesInDocCount = pagesInDocCount;
    }

    public Boolean getDeleteSeparationPages() {
        return deleteSeparationPages;
    }

    public void setDeleteSeparationPages(Boolean deleteSeparationPages) {
        this.deleteSeparationPages = deleteSeparationPages;
    }

    public String getBarcodeType() {
        return barcodeType;
    }

    public void setBarcodeType(String barcodeType) {
        this.barcodeType = barcodeType;
    }

    public String getBarcodeValue() {
        return barcodeValue;
    }

    public void setBarcodeValue(String barcodeValue) {
        this.barcodeValue = barcodeValue;
    }

    public Boolean getAutodetectKernelRect() {
        return autodetectKernelRect;
    }

    public void setAutodetectKernelRect(Boolean autodetectKernelRect) {
        this.autodetectKernelRect = autodetectKernelRect;
    }

    public SeparationOptions getSeparationOptions() {
        return separationOptions;
    }

    public void setSeparationOptions(SeparationOptions separationOptions) {
        this.separationOptions = separationOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeparationOptions that = (SeparationOptions) o;

        if (autodetectKernelRect != null ? !autodetectKernelRect.equals(that.autodetectKernelRect) : that.autodetectKernelRect != null)
            return false;
        if (barcodeType != null ? !barcodeType.equals(that.barcodeType) : that.barcodeType != null) return false;
        if (barcodeValue != null ? !barcodeValue.equals(that.barcodeValue) : that.barcodeValue != null) return false;
        if (batchNamingSchema != null ? !batchNamingSchema.equals(that.batchNamingSchema) : that.batchNamingSchema != null)
            return false;
        if (batchSeparationEvent != null ? !batchSeparationEvent.equals(that.batchSeparationEvent) : that.batchSeparationEvent != null)
            return false;
        if (batchSeparationType != null ? !batchSeparationType.equals(that.batchSeparationType) : that.batchSeparationType != null)
            return false;
        if (deleteSeparationPages != null ? !deleteSeparationPages.equals(that.deleteSeparationPages) : that.deleteSeparationPages != null)
            return false;
        if (docSeparationEvent != null ? !docSeparationEvent.equals(that.docSeparationEvent) : that.docSeparationEvent != null)
            return false;
        if (docSeparationType != null ? !docSeparationType.equals(that.docSeparationType) : that.docSeparationType != null)
            return false;
        if (documentNamingSchema != null ? !documentNamingSchema.equals(that.documentNamingSchema) : that.documentNamingSchema != null)
            return false;
        if (pagesInBatchCount != null ? !pagesInBatchCount.equals(that.pagesInBatchCount) : that.pagesInBatchCount != null)
            return false;
        if (pagesInDocCount != null ? !pagesInDocCount.equals(that.pagesInDocCount) : that.pagesInDocCount != null)
            return false;
        if (separationOptions != null ? !separationOptions.equals(that.separationOptions) : that.separationOptions != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = batchSeparationType != null ? batchSeparationType.hashCode() : 0;
        result = 31 * result + (batchSeparationEvent != null ? batchSeparationEvent.hashCode() : 0);
        result = 31 * result + (docSeparationType != null ? docSeparationType.hashCode() : 0);
        result = 31 * result + (docSeparationEvent != null ? docSeparationEvent.hashCode() : 0);
        result = 31 * result + (batchNamingSchema != null ? batchNamingSchema.hashCode() : 0);
        result = 31 * result + (pagesInBatchCount != null ? pagesInBatchCount.hashCode() : 0);
        result = 31 * result + (documentNamingSchema != null ? documentNamingSchema.hashCode() : 0);
        result = 31 * result + (pagesInDocCount != null ? pagesInDocCount.hashCode() : 0);
        result = 31 * result + (deleteSeparationPages != null ? deleteSeparationPages.hashCode() : 0);
        result = 31 * result + (barcodeType != null ? barcodeType.hashCode() : 0);
        result = 31 * result + (barcodeValue != null ? barcodeValue.hashCode() : 0);
        result = 31 * result + (autodetectKernelRect != null ? autodetectKernelRect.hashCode() : 0);
        result = 31 * result + (separationOptions != null ? separationOptions.hashCode() : 0);
        return result;
    }
}
