
package com.sitronics.filenet.imports.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}SourceObjectStore"/>
 *         &lt;element ref="{}ContentLocation"/>
 *         &lt;element ref="{}ImportData"/>
 *       &lt;/sequence>
 *       &lt;attribute name="SourceSysVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sourceObjectStore",
    "contentLocation",
    "importData"
})
@XmlRootElement(name = "ExportDescriptor")
public class ExportDescriptor {

    @XmlElement(name = "SourceObjectStore", required = true)
    protected SourceObjectStore sourceObjectStore;
    @XmlElement(name = "ContentLocation", required = true)
    protected ContentLocation contentLocation;
    @XmlElement(name = "ImportData", required = true)
    protected ImportData importData;
    @XmlAttribute(name = "SourceSysVersion")
    protected String sourceSysVersion;

    /**
     * Gets the value of the sourceObjectStore property.
     * 
     * @return
     *     possible object is
     *     {@link SourceObjectStore }
     *     
     */
    public SourceObjectStore getSourceObjectStore() {
        return sourceObjectStore;
    }

    /**
     * Sets the value of the sourceObjectStore property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceObjectStore }
     *     
     */
    public void setSourceObjectStore(SourceObjectStore value) {
        this.sourceObjectStore = value;
    }

    /**
     * Gets the value of the contentLocation property.
     * 
     * @return
     *     possible object is
     *     {@link ContentLocation }
     *     
     */
    public ContentLocation getContentLocation() {
        return contentLocation;
    }

    /**
     * Sets the value of the contentLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentLocation }
     *     
     */
    public void setContentLocation(ContentLocation value) {
        this.contentLocation = value;
    }

    /**
     * Gets the value of the importData property.
     * 
     * @return
     *     possible object is
     *     {@link ImportData }
     *     
     */
    public ImportData getImportData() {
        return importData;
    }

    /**
     * Sets the value of the importData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportData }
     *     
     */
    public void setImportData(ImportData value) {
        this.importData = value;
    }

    /**
     * Gets the value of the sourceSysVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceSysVersion() {
        return sourceSysVersion;
    }

    /**
     * Sets the value of the sourceSysVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceSysVersion(String value) {
        this.sourceSysVersion = value;
    }

}
