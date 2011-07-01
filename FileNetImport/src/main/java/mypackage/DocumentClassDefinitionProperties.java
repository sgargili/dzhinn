
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
 *         &lt;element ref="{}Creator"/>
 *         &lt;element ref="{}LastModifier"/>
 *         &lt;element ref="{}PropertyDefinitions"/>
 *         &lt;element ref="{}ReplicationGroup"/>
 *         &lt;element ref="{}IsCBREnabled"/>
 *         &lt;element ref="{}DisplayNames"/>
 *         &lt;element ref="{}AuditDefinitions"/>
 *         &lt;element ref="{}AliasIds"/>
 *         &lt;element ref="{}Id"/>
 *         &lt;element ref="{}DateCreated"/>
 *         &lt;element ref="{}DescriptiveTexts"/>
 *         &lt;element ref="{}ExternalAliases"/>
 *         &lt;element ref="{}IsHidden"/>
 *         &lt;element ref="{}ExternalReplicaIdentities"/>
 *         &lt;element ref="{}SuperclassDefinition"/>
 *         &lt;element ref="{}DateLastModified"/>
 *         &lt;element ref="{}Name"/>
 *         &lt;element ref="{}AllowsInstances"/>
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
    "creator",
    "lastModifier",
    "propertyDefinitions",
    "replicationGroup",
    "isCBREnabled",
    "displayNames",
    "auditDefinitions",
    "aliasIds",
    "id",
    "dateCreated",
    "descriptiveTexts",
    "externalAliases",
    "isHidden",
    "externalReplicaIdentities",
    "superclassDefinition",
    "dateLastModified",
    "name",
    "allowsInstances"
})
@XmlRootElement(name = "DocumentClassDefinitionProperties")
public class DocumentClassDefinitionProperties {

    @XmlElement(name = "ObjectType")
    protected short objectType;
    @XmlElement(name = "SymbolicName", required = true)
    protected String symbolicName;
    @XmlElement(name = "Creator", required = true)
    protected String creator;
    @XmlElement(name = "LastModifier", required = true)
    protected String lastModifier;
    @XmlElement(name = "PropertyDefinitions", required = true)
    protected PropertyDefinitions propertyDefinitions;
    @XmlElement(name = "ReplicationGroup", required = true)
    protected String replicationGroup;
    @XmlElement(name = "IsCBREnabled", required = true)
    protected String isCBREnabled;
    @XmlElement(name = "DisplayNames", required = true)
    protected DisplayNames displayNames;
    @XmlElement(name = "AuditDefinitions", required = true)
    protected AuditDefinitions auditDefinitions;
    @XmlElement(name = "AliasIds", required = true)
    protected String aliasIds;
    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "DateCreated", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreated;
    @XmlElement(name = "DescriptiveTexts", required = true)
    protected DescriptiveTexts descriptiveTexts;
    @XmlElement(name = "ExternalAliases", required = true)
    protected String externalAliases;
    @XmlElement(name = "IsHidden", required = true)
    protected String isHidden;
    @XmlElement(name = "ExternalReplicaIdentities", required = true)
    protected String externalReplicaIdentities;
    @XmlElement(name = "SuperclassDefinition", required = true)
    protected SuperclassDefinition superclassDefinition;
    @XmlElement(name = "DateLastModified", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateLastModified;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "AllowsInstances")
    protected byte allowsInstances;

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
     * Gets the value of the propertyDefinitions property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyDefinitions }
     *     
     */
    public PropertyDefinitions getPropertyDefinitions() {
        return propertyDefinitions;
    }

    /**
     * Sets the value of the propertyDefinitions property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyDefinitions }
     *     
     */
    public void setPropertyDefinitions(PropertyDefinitions value) {
        this.propertyDefinitions = value;
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
     * Gets the value of the auditDefinitions property.
     * 
     * @return
     *     possible object is
     *     {@link AuditDefinitions }
     *     
     */
    public AuditDefinitions getAuditDefinitions() {
        return auditDefinitions;
    }

    /**
     * Sets the value of the auditDefinitions property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditDefinitions }
     *     
     */
    public void setAuditDefinitions(AuditDefinitions value) {
        this.auditDefinitions = value;
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
     * Gets the value of the superclassDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link SuperclassDefinition }
     *     
     */
    public SuperclassDefinition getSuperclassDefinition() {
        return superclassDefinition;
    }

    /**
     * Sets the value of the superclassDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link SuperclassDefinition }
     *     
     */
    public void setSuperclassDefinition(SuperclassDefinition value) {
        this.superclassDefinition = value;
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
     * Gets the value of the allowsInstances property.
     * 
     */
    public byte getAllowsInstances() {
        return allowsInstances;
    }

    /**
     * Sets the value of the allowsInstances property.
     * 
     */
    public void setAllowsInstances(byte value) {
        this.allowsInstances = value;
    }

}
