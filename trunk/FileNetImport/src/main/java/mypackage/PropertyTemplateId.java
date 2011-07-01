
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
 *         &lt;element ref="{}PropertyTemplateIdProperties" minOccurs="0"/>
 *         &lt;element ref="{}PropertyTemplateInteger32Properties" minOccurs="0"/>
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
    "propertyTemplateIdProperties",
    "propertyTemplateInteger32Properties"
})
@XmlRootElement(name = "PropertyTemplateId")
public class PropertyTemplateId {

    @XmlElement(name = "PropertyTemplateIdProperties")
    protected PropertyTemplateIdProperties propertyTemplateIdProperties;
    @XmlElement(name = "PropertyTemplateInteger32Properties")
    protected PropertyTemplateInteger32Properties propertyTemplateInteger32Properties;

    /**
     * Gets the value of the propertyTemplateIdProperties property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyTemplateIdProperties }
     *     
     */
    public PropertyTemplateIdProperties getPropertyTemplateIdProperties() {
        return propertyTemplateIdProperties;
    }

    /**
     * Sets the value of the propertyTemplateIdProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyTemplateIdProperties }
     *     
     */
    public void setPropertyTemplateIdProperties(PropertyTemplateIdProperties value) {
        this.propertyTemplateIdProperties = value;
    }

    /**
     * Gets the value of the propertyTemplateInteger32Properties property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyTemplateInteger32Properties }
     *     
     */
    public PropertyTemplateInteger32Properties getPropertyTemplateInteger32Properties() {
        return propertyTemplateInteger32Properties;
    }

    /**
     * Sets the value of the propertyTemplateInteger32Properties property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyTemplateInteger32Properties }
     *     
     */
    public void setPropertyTemplateInteger32Properties(PropertyTemplateInteger32Properties value) {
        this.propertyTemplateInteger32Properties = value;
    }

}
