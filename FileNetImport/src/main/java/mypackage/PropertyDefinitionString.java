
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
 *         &lt;element ref="{}IsNameProperty"/>
 *         &lt;element ref="{}MaximumLengthString"/>
 *         &lt;element ref="{}PropertyDefaultString"/>
 *         &lt;element ref="{}Settability"/>
 *         &lt;element ref="{}Name"/>
 *         &lt;element ref="{}ExternalAliases"/>
 *         &lt;element ref="{}IsValueRequired"/>
 *         &lt;element ref="{}IsCBREnabled"/>
 *         &lt;element ref="{}ModificationAccessRequired"/>
 *         &lt;element ref="{}PrimaryId"/>
 *         &lt;element ref="{}CopyToReservation"/>
 *         &lt;element ref="{}ChoiceList"/>
 *         &lt;element ref="{}AliasIds"/>
 *         &lt;element ref="{}IsHidden"/>
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
    "isNameProperty",
    "maximumLengthString",
    "propertyDefaultString",
    "settability",
    "name",
    "externalAliases",
    "isValueRequired",
    "isCBREnabled",
    "modificationAccessRequired",
    "primaryId",
    "copyToReservation",
    "choiceList",
    "aliasIds",
    "isHidden"
})
@XmlRootElement(name = "PropertyDefinitionString")
public class PropertyDefinitionString {

    @XmlElement(name = "ObjectType")
    protected short objectType;
    @XmlElement(name = "IsNameProperty")
    protected byte isNameProperty;
    @XmlElement(name = "MaximumLengthString", required = true)
    protected String maximumLengthString;
    @XmlElement(name = "PropertyDefaultString", required = true)
    protected String propertyDefaultString;
    @XmlElement(name = "Settability")
    protected byte settability;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "ExternalAliases", required = true)
    protected String externalAliases;
    @XmlElement(name = "IsValueRequired", required = true)
    protected String isValueRequired;
    @XmlElement(name = "IsCBREnabled", required = true)
    protected String isCBREnabled;
    @XmlElement(name = "ModificationAccessRequired", required = true)
    protected String modificationAccessRequired;
    @XmlElement(name = "PrimaryId", required = true)
    protected String primaryId;
    @XmlElement(name = "CopyToReservation")
    protected byte copyToReservation;
    @XmlElement(name = "ChoiceList", required = true)
    protected ChoiceList choiceList;
    @XmlElement(name = "AliasIds", required = true)
    protected String aliasIds;
    @XmlElement(name = "IsHidden", required = true)
    protected String isHidden;

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
     * Gets the value of the isNameProperty property.
     * 
     */
    public byte getIsNameProperty() {
        return isNameProperty;
    }

    /**
     * Sets the value of the isNameProperty property.
     * 
     */
    public void setIsNameProperty(byte value) {
        this.isNameProperty = value;
    }

    /**
     * Gets the value of the maximumLengthString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaximumLengthString() {
        return maximumLengthString;
    }

    /**
     * Sets the value of the maximumLengthString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaximumLengthString(String value) {
        this.maximumLengthString = value;
    }

    /**
     * Gets the value of the propertyDefaultString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyDefaultString() {
        return propertyDefaultString;
    }

    /**
     * Sets the value of the propertyDefaultString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyDefaultString(String value) {
        this.propertyDefaultString = value;
    }

    /**
     * Gets the value of the settability property.
     * 
     */
    public byte getSettability() {
        return settability;
    }

    /**
     * Sets the value of the settability property.
     * 
     */
    public void setSettability(byte value) {
        this.settability = value;
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
     * Gets the value of the externalAliases property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalAliases() {
        return externalAliases;
    }

    /**
     * Sets the value of the externalAliases property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalAliases(String value) {
        this.externalAliases = value;
    }

    /**
     * Gets the value of the isValueRequired property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsValueRequired() {
        return isValueRequired;
    }

    /**
     * Sets the value of the isValueRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsValueRequired(String value) {
        this.isValueRequired = value;
    }

    /**
     * Gets the value of the isCBREnabled property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsCBREnabled() {
        return isCBREnabled;
    }

    /**
     * Sets the value of the isCBREnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsCBREnabled(String value) {
        this.isCBREnabled = value;
    }

    /**
     * Gets the value of the modificationAccessRequired property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModificationAccessRequired() {
        return modificationAccessRequired;
    }

    /**
     * Sets the value of the modificationAccessRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModificationAccessRequired(String value) {
        this.modificationAccessRequired = value;
    }

    /**
     * Gets the value of the primaryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryId() {
        return primaryId;
    }

    /**
     * Sets the value of the primaryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryId(String value) {
        this.primaryId = value;
    }

    /**
     * Gets the value of the copyToReservation property.
     * 
     */
    public byte getCopyToReservation() {
        return copyToReservation;
    }

    /**
     * Sets the value of the copyToReservation property.
     * 
     */
    public void setCopyToReservation(byte value) {
        this.copyToReservation = value;
    }

    /**
     * Gets the value of the choiceList property.
     * 
     * @return
     *     possible object is
     *     {@link ChoiceList }
     *     
     */
    public ChoiceList getChoiceList() {
        return choiceList;
    }

    /**
     * Sets the value of the choiceList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChoiceList }
     *     
     */
    public void setChoiceList(ChoiceList value) {
        this.choiceList = value;
    }

    /**
     * Gets the value of the aliasIds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasIds() {
        return aliasIds;
    }

    /**
     * Sets the value of the aliasIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasIds(String value) {
        this.aliasIds = value;
    }

    /**
     * Gets the value of the isHidden property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsHidden() {
        return isHidden;
    }

    /**
     * Sets the value of the isHidden property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsHidden(String value) {
        this.isHidden = value;
    }

}
