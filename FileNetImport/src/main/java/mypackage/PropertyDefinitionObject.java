
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
 *         &lt;element ref="{}Name"/>
 *         &lt;element ref="{}RequiredClassId"/>
 *         &lt;element ref="{}ReflectivePropertyId"/>
 *         &lt;element ref="{}DeletionAction"/>
 *         &lt;element ref="{}PropertyDefaultObject" minOccurs="0"/>
 *         &lt;element ref="{}PrimaryId"/>
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
    "name",
    "requiredClassId",
    "reflectivePropertyId",
    "deletionAction",
    "propertyDefaultObject",
    "primaryId"
})
@XmlRootElement(name = "PropertyDefinitionObject")
public class PropertyDefinitionObject {

    @XmlElement(name = "ObjectType")
    protected short objectType;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "RequiredClassId", required = true)
    protected String requiredClassId;
    @XmlElement(name = "ReflectivePropertyId", required = true)
    protected String reflectivePropertyId;
    @XmlElement(name = "DeletionAction", required = true)
    protected String deletionAction;
    @XmlElement(name = "PropertyDefaultObject")
    protected PropertyDefaultObject propertyDefaultObject;
    @XmlElement(name = "PrimaryId", required = true)
    protected String primaryId;

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
     * Gets the value of the requiredClassId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequiredClassId() {
        return requiredClassId;
    }

    /**
     * Sets the value of the requiredClassId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequiredClassId(String value) {
        this.requiredClassId = value;
    }

    /**
     * Gets the value of the reflectivePropertyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReflectivePropertyId() {
        return reflectivePropertyId;
    }

    /**
     * Sets the value of the reflectivePropertyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReflectivePropertyId(String value) {
        this.reflectivePropertyId = value;
    }

    /**
     * Gets the value of the deletionAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeletionAction() {
        return deletionAction;
    }

    /**
     * Sets the value of the deletionAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeletionAction(String value) {
        this.deletionAction = value;
    }

    /**
     * Gets the value of the propertyDefaultObject property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyDefaultObject }
     *     
     */
    public PropertyDefaultObject getPropertyDefaultObject() {
        return propertyDefaultObject;
    }

    /**
     * Sets the value of the propertyDefaultObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyDefaultObject }
     *     
     */
    public void setPropertyDefaultObject(PropertyDefaultObject value) {
        this.propertyDefaultObject = value;
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

}
