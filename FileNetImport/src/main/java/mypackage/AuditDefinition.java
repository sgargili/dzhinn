
package mypackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{}ObjectType"/>
 *         &lt;element ref="{}AuditFailure"/>
 *         &lt;element ref="{}IncludeSubclassesRequested"/>
 *         &lt;element ref="{}AuditSuccess"/>
 *         &lt;element ref="{}EventClass"/>
 *         &lt;element ref="{}Id"/>
 *         &lt;element ref="{}ObjectStateRecordingLevel"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "objectType",
    "auditFailure",
    "includeSubclassesRequested",
    "auditSuccess",
    "eventClass",
    "id",
    "objectStateRecordingLevel"
})
@XmlRootElement(name = "AuditDefinition")
public class AuditDefinition {

    @XmlElement(name = "ObjectType")
    protected short objectType;
    @XmlElement(name = "AuditFailure")
    protected byte auditFailure;
    @XmlElement(name = "IncludeSubclassesRequested")
    protected byte includeSubclassesRequested;
    @XmlElement(name = "AuditSuccess")
    protected byte auditSuccess;
    @XmlElement(name = "EventClass", required = true)
    protected EventClass eventClass;
    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "ObjectStateRecordingLevel")
    protected byte objectStateRecordingLevel;

    /**
     * Gets the value of the objectType property.
     * 
     */
    public short getObjectType() {
        return objectType;
    }

    /**
     * Sets the value of the objectType property.
     * 
     */
    public void setObjectType(short value) {
        this.objectType = value;
    }

    /**
     * Gets the value of the auditFailure property.
     * 
     */
    public byte getAuditFailure() {
        return auditFailure;
    }

    /**
     * Sets the value of the auditFailure property.
     * 
     */
    public void setAuditFailure(byte value) {
        this.auditFailure = value;
    }

    /**
     * Gets the value of the includeSubclassesRequested property.
     * 
     */
    public byte getIncludeSubclassesRequested() {
        return includeSubclassesRequested;
    }

    /**
     * Sets the value of the includeSubclassesRequested property.
     * 
     */
    public void setIncludeSubclassesRequested(byte value) {
        this.includeSubclassesRequested = value;
    }

    /**
     * Gets the value of the auditSuccess property.
     * 
     */
    public byte getAuditSuccess() {
        return auditSuccess;
    }

    /**
     * Sets the value of the auditSuccess property.
     * 
     */
    public void setAuditSuccess(byte value) {
        this.auditSuccess = value;
    }

    /**
     * Gets the value of the eventClass property.
     * 
     * @return
     *     possible object is
     *     {@link EventClass }
     *     
     */
    public EventClass getEventClass() {
        return eventClass;
    }

    /**
     * Sets the value of the eventClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventClass }
     *     
     */
    public void setEventClass(EventClass value) {
        this.eventClass = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the objectStateRecordingLevel property.
     * 
     */
    public byte getObjectStateRecordingLevel() {
        return objectStateRecordingLevel;
    }

    /**
     * Sets the value of the objectStateRecordingLevel property.
     * 
     */
    public void setObjectStateRecordingLevel(byte value) {
        this.objectStateRecordingLevel = value;
    }

}
