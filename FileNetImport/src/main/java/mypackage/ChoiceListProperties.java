
package mypackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{}ChoiceValues"/>
 *         &lt;element ref="{}DataType"/>
 *         &lt;element ref="{}Creator"/>
 *         &lt;element ref="{}DateCreated"/>
 *         &lt;element ref="{}Name"/>
 *         &lt;element ref="{}ReplicationGroup"/>
 *         &lt;element ref="{}Id"/>
 *         &lt;element ref="{}LastModifier"/>
 *         &lt;element ref="{}ExternalReplicaIdentities"/>
 *         &lt;element ref="{}DisplayName"/>
 *         &lt;element ref="{}DescriptiveText"/>
 *         &lt;element ref="{}DateLastModified"/>
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
    "choiceValues",
    "dataType",
    "creator",
    "dateCreated",
    "name",
    "replicationGroup",
    "id",
    "lastModifier",
    "externalReplicaIdentities",
    "displayName",
    "descriptiveText",
    "dateLastModified"
})
@XmlRootElement(name = "ChoiceListProperties")
public class ChoiceListProperties {

    @XmlElement(name = "ObjectType")
    protected short objectType;
    @XmlElement(name = "ChoiceValues", required = true)
    protected ChoiceValues choiceValues;
    @XmlElement(name = "DataType")
    protected byte dataType;
    @XmlElement(name = "Creator", required = true)
    protected String creator;
    @XmlElement(name = "DateCreated", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreated;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "ReplicationGroup", required = true)
    protected String replicationGroup;
    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "LastModifier", required = true)
    protected String lastModifier;
    @XmlElement(name = "ExternalReplicaIdentities", required = true)
    protected String externalReplicaIdentities;
    @XmlElement(name = "DisplayName", required = true)
    protected String displayName;
    @XmlElement(name = "DescriptiveText", required = true)
    protected String descriptiveText;
    @XmlElement(name = "DateLastModified", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateLastModified;

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
     * Gets the value of the choiceValues property.
     * 
     * @return
     *     possible object is
     *     {@link ChoiceValues }
     *     
     */
    public ChoiceValues getChoiceValues() {
        return choiceValues;
    }

    /**
     * Sets the value of the choiceValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChoiceValues }
     *     
     */
    public void setChoiceValues(ChoiceValues value) {
        this.choiceValues = value;
    }

    /**
     * Gets the value of the dataType property.
     * 
     */
    public byte getDataType() {
        return dataType;
    }

    /**
     * Sets the value of the dataType property.
     * 
     */
    public void setDataType(byte value) {
        this.dataType = value;
    }

    /**
     * Gets the value of the creator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Sets the value of the creator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreator(String value) {
        this.creator = value;
    }

    /**
     * Gets the value of the dateCreated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the value of the dateCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreated(XMLGregorianCalendar value) {
        this.dateCreated = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the replicationGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplicationGroup() {
        return replicationGroup;
    }

    /**
     * Sets the value of the replicationGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplicationGroup(String value) {
        this.replicationGroup = value;
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
     * Gets the value of the lastModifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastModifier() {
        return lastModifier;
    }

    /**
     * Sets the value of the lastModifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastModifier(String value) {
        this.lastModifier = value;
    }

    /**
     * Gets the value of the externalReplicaIdentities property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalReplicaIdentities() {
        return externalReplicaIdentities;
    }

    /**
     * Sets the value of the externalReplicaIdentities property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalReplicaIdentities(String value) {
        this.externalReplicaIdentities = value;
    }

    /**
     * Gets the value of the displayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * Gets the value of the descriptiveText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescriptiveText() {
        return descriptiveText;
    }

    /**
     * Sets the value of the descriptiveText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescriptiveText(String value) {
        this.descriptiveText = value;
    }

    /**
     * Gets the value of the dateLastModified property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateLastModified() {
        return dateLastModified;
    }

    /**
     * Sets the value of the dateLastModified property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateLastModified(XMLGregorianCalendar value) {
        this.dateLastModified = value;
    }

}
