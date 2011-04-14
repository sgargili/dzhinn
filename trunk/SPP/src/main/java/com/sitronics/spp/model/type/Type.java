package com.sitronics.spp.model.type;

import java.util.List;

import javax.xml.bind.annotation.*;

import com.sitronics.spp.model.type.exportoptions.*;
import com.sitronics.spp.model.type.registrationparameters.RegParam;

/**
 * @author Andrey Popov creates on 14.04.11 (11:49)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Type implements Cloneable {
    @XmlAttribute(name = "UID")
    private String uID;
    @XmlAttribute(name = "SourceType")
    private String sourceType;
    @XmlAttribute(name = "ExportType")
    private String exportType;
    @XmlAttribute(name = "UseTypeExportOptions")
    private Boolean useTypeExportOptions;

    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "SourceName")
    private String sourceName;
    @XmlElement(name = "RemoveLoadedFiles")
    private Boolean removeLoadedFiles;

    @XmlElement(name = "SeparationOptions")
    private SeparationOptions separationOptions;
    @XmlElement(name = "ImageProcessingOptions")
    private ImageProcessingOptions imageProcessingOptions;
    @XmlElementWrapper(name = "ExportOptions")
    @XmlElements(value = {
            @XmlElement(name = "ToFolder", type = ToFolder.class),
            @XmlElement(name = "ToRecognitionServer", type = ToRecognitionServer.class),
            @XmlElement(name = "ToFlexiCapture", type = ToFlexiCapture.class),
            @XmlElement(name = "ToFTP", type = ToFTP.class)
    })
    private List<ExportOptionBase> exportOptions;
    @XmlElementWrapper(name = "RegistrationParameters")
    @XmlElement(name = "RegParam")
    private List<RegParam> registrationParameters;
    @XmlElement(name = "PageSizeCheckingOptions")
    private PageSizeCheckingOptions PageSizeCheckingOptions;

    public Type() {
    }

    public String getUID() {
        return uID;
    }

    public void setUID(String uID) {
        this.uID = uID;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getExportType() {
        return exportType;
    }

    public void setExportType(String exportType) {
        this.exportType = exportType;
    }

    public Boolean getUseTypeExportOptions() {
        return useTypeExportOptions;
    }

    public void setUseTypeExportOptions(Boolean useTypeExportOptions) {
        this.useTypeExportOptions = useTypeExportOptions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Boolean getRemoveLoadedFiles() {
        return removeLoadedFiles;
    }

    public void setRemoveLoadedFiles(Boolean removeLoadedFiles) {
        this.removeLoadedFiles = removeLoadedFiles;
    }

    public SeparationOptions getSeparationOptions() {
        return separationOptions;
    }

    public void setSeparationOptions(SeparationOptions separationOptions) {
        this.separationOptions = separationOptions;
    }

    public ImageProcessingOptions getImageProcessingOptions() {
        return imageProcessingOptions;
    }

    public void setImageProcessingOptions(ImageProcessingOptions imageProcessingOptions) {
        this.imageProcessingOptions = imageProcessingOptions;
    }

    public List<ExportOptionBase> getExportOptions() {
        return exportOptions;
    }

    public void setExportOptions(List<ExportOptionBase> exportOptions) {
        this.exportOptions = exportOptions;
    }

    public List<RegParam> getRegistrationParameters() {
        return registrationParameters;
    }

    public void setRegistrationParameters(List<RegParam> registrationParameters) {
        this.registrationParameters = registrationParameters;
    }

    public PageSizeCheckingOptions getPageSizeCheckingOptions() {
        return PageSizeCheckingOptions;
    }

    public void setPageSizeCheckingOptions(PageSizeCheckingOptions pageSizeCheckingOptions) {
        PageSizeCheckingOptions = pageSizeCheckingOptions;
    }

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

        Type type = (Type) o;

        if (imageProcessingOptions != null ? !imageProcessingOptions.equals(type.imageProcessingOptions) : type.imageProcessingOptions != null)
            return false;
        if (PageSizeCheckingOptions != null ? !PageSizeCheckingOptions.equals(type.PageSizeCheckingOptions) : type.PageSizeCheckingOptions != null)
            return false;
        if (separationOptions != null ? !separationOptions.equals(type.separationOptions) : type.separationOptions != null)
            return false;
        if (exportOptions != null ? !exportOptions.equals(type.exportOptions) : type.exportOptions != null)
            return false;
        if (exportType != null ? !exportType.equals(type.exportType) : type.exportType != null) return false;
        if (name != null ? !name.equals(type.name) : type.name != null) return false;
        if (registrationParameters != null ? !registrationParameters.equals(type.registrationParameters) : type.registrationParameters != null)
            return false;
        if (removeLoadedFiles != null ? !removeLoadedFiles.equals(type.removeLoadedFiles) : type.removeLoadedFiles != null)
            return false;
        if (sourceName != null ? !sourceName.equals(type.sourceName) : type.sourceName != null) return false;
        if (sourceType != null ? !sourceType.equals(type.sourceType) : type.sourceType != null) return false;
        if (uID != null ? !uID.equals(type.uID) : type.uID != null) return false;
        if (useTypeExportOptions != null ? !useTypeExportOptions.equals(type.useTypeExportOptions) : type.useTypeExportOptions != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uID != null ? uID.hashCode() : 0;
        result = 31 * result + (sourceType != null ? sourceType.hashCode() : 0);
        result = 31 * result + (exportType != null ? exportType.hashCode() : 0);
        result = 31 * result + (useTypeExportOptions != null ? useTypeExportOptions.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sourceName != null ? sourceName.hashCode() : 0);
        result = 31 * result + (removeLoadedFiles != null ? removeLoadedFiles.hashCode() : 0);
        result = 31 * result + (separationOptions != null ? separationOptions.hashCode() : 0);
        result = 31 * result + (imageProcessingOptions != null ? imageProcessingOptions.hashCode() : 0);
        result = 31 * result + (exportOptions != null ? exportOptions.hashCode() : 0);
        result = 31 * result + (registrationParameters != null ? registrationParameters.hashCode() : 0);
        result = 31 * result + (PageSizeCheckingOptions != null ? PageSizeCheckingOptions.hashCode() : 0);
        return result;
    }
}
