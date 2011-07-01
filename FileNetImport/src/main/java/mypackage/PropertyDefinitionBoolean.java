
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
 *         &lt;element ref="{}RequiredClassId" minOccurs="0"/>
 *         &lt;element ref="{}ReflectivePropertyId" minOccurs="0"/>
 *         &lt;element ref="{}DeletionAction" minOccurs="0"/>
 *         &lt;element ref="{}PropertyDefaultObject" minOccurs="0"/>
 *         &lt;element ref="{}PrimaryId"/>
 *         &lt;element ref="{}PropertyDefaultBoolean" minOccurs="0"/>
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
    "primaryId",
    "propertyDefaultBoolean"
})
@XmlRootElement(name = "PropertyDefinitionBoolean")
public class PropertyDefinitionBoolean {

    @XmlElement(name = "ObjectType")
    protected short objectType;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "RequiredClassId")
    protected String requiredClassId;
    @XmlElement(name = "ReflectivePropertyId")
    protected String reflectivePropertyId;
    @XmlElement(name = "DeletionAction")
    protected String deletionAction;
    @XmlElement(name = "PropertyDefaultObject")
    protected PropertyDefaultObject propertyDefaultObject;
    @XmlElement(name = "PrimaryId", required = true)
    protected String primaryId;
    @XmlElement(name = "PropertyDefaultBoolean")
    protected String propertyDefaultBoolean;

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

    /**
     * Gets the value of the propertyDefaultBoolean property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyDefaultBoolean() {
        return propertyDefaultBoolean;
    }

    /**
     * Sets the value of the propertyDefaultBoolean property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyDefaultBoolean(String value) {
        this.propertyDefaultBoolean = value;
    }

}
