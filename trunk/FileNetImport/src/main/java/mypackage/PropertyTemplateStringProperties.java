
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
 *         &lt;element ref="{}SymbolicName"/>
 *         &lt;element ref="{}MarkingSet"/>
 *         &lt;element ref="{}PersistenceType"/>
 *         &lt;element ref="{}Cardinality"/>
 *         &lt;element ref="{}Creator"/>
 *         &lt;element ref="{}LastModifier"/>
 *         &lt;element ref="{}UsesLongColumn"/>
 *         &lt;element ref="{}Settability"/>
 *         &lt;element ref="{}ModificationAccessRequired"/>
 *         &lt;element ref="{}ReplicationGroup"/>
 *         &lt;element ref="{}DisplayNames"/>
 *         &lt;element ref="{}MaximumLengthString"/>
 *         &lt;element ref="{}AliasIds"/>
 *         &lt;element ref="{}Id"/>
 *         &lt;element ref="{}IsNameProperty"/>
 *         &lt;element ref="{}DateCreated"/>
 *         &lt;element ref="{}DescriptiveTexts"/>
 *         &lt;element ref="{}RequiresUniqueElements"/>
 *         &lt;element ref="{}IsHidden"/>
 *         &lt;element ref="{}ExternalReplicaIdentities"/>
 *         &lt;element ref="{}DateLastModified"/>
 *         &lt;element ref="{}Name"/>
 *         &lt;element ref="{}PropertyDefaultString"/>
 *         &lt;element ref="{}ChoiceList"/>
 *         &lt;element ref="{}PropertyDisplayCategory"/>
 *         &lt;element ref="{}IsValueRequired"/>
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
    "symbolicName",
    "markingSet",
    "persistenceType",
    "cardinality",
    "creator",
    "lastModifier",
    "usesLongColumn",
    "settability",
    "modificationAccessRequired",
    "replicationGroup",
    "displayNames",
    "maximumLengthString",
    "aliasIds",
    "id",
    "isNameProperty",
    "dateCreated",
    "descriptiveTexts",
    "requiresUniqueElements",
    "isHidden",
    "externalReplicaIdentities",
    "dateLastModified",
    "name",
    "propertyDefaultString",
    "choiceList",
    "propertyDisplayCategory",
    "isValueRequired"
})
@XmlRootElement(name = "PropertyTemplateStringProperties")
public class PropertyTemplateStringProperties {

    @XmlElement(name = "ObjectType")
    protected short objectType;
    @XmlElement(name = "SymbolicName", required = true)
    protected String symbolicName;
    @XmlElement(name = "MarkingSet", required = true)
    protected String markingSet;
    @XmlElement(name = "PersistenceType")
    protected byte persistenceType;
    @XmlElement(name = "Cardinality")
    protected byte cardinality;
    @XmlElement(name = "Creator", required = true)
    protected String creator;
    @XmlElement(name = "LastModifier", required = true)
    protected String lastModifier;
    @XmlElement(name = "UsesLongColumn")
    protected byte usesLongColumn;
    @XmlElement(name = "Settability")
    protected byte settability;
    @XmlElement(name = "ModificationAccessRequired", required = true)
    protected String modificationAccessRequired;
    @XmlElement(name = "ReplicationGroup", required = true)
    protected String replicationGroup;
    @XmlElement(name = "DisplayNames", required = true)
    protected DisplayNames displayNames;
    @XmlElement(name = "MaximumLengthString", required = true)
    protected String maximumLengthString;
    @XmlElement(name = "AliasIds", required = true)
    protected String aliasIds;
    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "IsNameProperty")
    protected byte isNameProperty;
    @XmlElement(name = "DateCreated", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreated;
    @XmlElement(name = "DescriptiveTexts", required = true)
    protected DescriptiveTexts descriptiveTexts;
    @XmlElement(name = "RequiresUniqueElements", required = true)
    protected String requiresUniqueElements;
    @XmlElement(name = "IsHidden", required = true)
    protected String isHidden;
    @XmlElement(name = "ExternalReplicaIdentities", required = true)
    protected String externalReplicaIdentities;
    @XmlElement(name = "DateLastModified", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateLastModified;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "PropertyDefaultString", required = true)
    protected String propertyDefaultString;
    @XmlElement(name = "ChoiceList", required = true)
    protected ChoiceList choiceList;
    @XmlElement(name = "PropertyDisplayCategory", required = true)
    protected String propertyDisplayCategory;
    @XmlElement(name = "IsValueRequired", required = true)
    protected String isValueRequired;

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
     * Gets the value of the symbolicName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbolicName() {
        return symbolicName;
    }

    /**
     * Sets the value of the symbolicName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbolicName(String value) {
        this.symbolicName = value;
    }

    /**
     * Gets the value of the markingSet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarkingSet() {
        return markingSet;
    }

    /**
     * Sets the value of the markingSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarkingSet(String value) {
        this.markingSet = value;
    }

    /**
     * Gets the value of the persistenceType property.
     * 
     */
    public byte getPersistenceType() {
        return persistenceType;
    }

    /**
     * Sets the value of the persistenceType property.
     * 
     */
    public void setPersistenceType(byte value) {
        this.persistenceType = value;
    }

    /**
     * Gets the value of the cardinality property.
     * 
     */
    public byte getCardinality() {
        return cardinality;
    }

    /**
     * Sets the value of the cardinality property.
     * 
     */
    public void setCardinality(byte value) {
        this.cardinality = value;
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
     * Gets the value of the usesLongColumn property.
     * 
     */
    public byte getUsesLongColumn() {
        return usesLongColumn;
    }

    /**
     * Sets the value of the usesLongColumn property.
     * 
     */
    public void setUsesLongColumn(byte value) {
        this.usesLongColumn = value;
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
     * Gets the value of the displayNames property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayNames }
     *     
     */
    public DisplayNames getDisplayNames() {
        return displayNames;
    }

    /**
     * Sets the value of the displayNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayNames }
     *     
     */
    public void setDisplayNames(DisplayNames value) {
        this.displayNames = value;
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
     * Gets the value of the descriptiveTexts property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptiveTexts }
     *     
     */
    public DescriptiveTexts getDescriptiveTexts() {
        return descriptiveTexts;
    }

    /**
     * Sets the value of the descriptiveTexts property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptiveTexts }
     *     
     */
    public void setDescriptiveTexts(DescriptiveTexts value) {
        this.descriptiveTexts = value;
    }

    /**
     * Gets the value of the requiresUniqueElements property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequiresUniqueElements() {
        return requiresUniqueElements;
    }

    /**
     * Sets the value of the requiresUniqueElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequiresUniqueElements(String value) {
        this.requiresUniqueElements = value;
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
     * Gets the value of the propertyDisplayCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyDisplayCategory() {
        return propertyDisplayCategory;
    }

    /**
     * Sets the value of the propertyDisplayCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyDisplayCategory(String value) {
        this.propertyDisplayCategory = value;
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

}
