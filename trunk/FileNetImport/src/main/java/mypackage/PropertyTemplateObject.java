
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
 *         &lt;element ref="{}PropertyTemplateObjectProperties" minOccurs="0"/>
 *         &lt;element ref="{}PropertyTemplateStringProperties" minOccurs="0"/>
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
    "propertyTemplateObjectProperties",
    "propertyTemplateStringProperties"
})
@XmlRootElement(name = "PropertyTemplateObject")
public class PropertyTemplateObject {

    @XmlElement(name = "PropertyTemplateObjectProperties")
    protected PropertyTemplateObjectProperties propertyTemplateObjectProperties;
    @XmlElement(name = "PropertyTemplateStringProperties")
    protected PropertyTemplateStringProperties propertyTemplateStringProperties;

    /**
     * Gets the value of the propertyTemplateObjectProperties property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyTemplateObjectProperties }
     *     
     */
    public PropertyTemplateObjectProperties getPropertyTemplateObjectProperties() {
        return propertyTemplateObjectProperties;
    }

    /**
     * Sets the value of the propertyTemplateObjectProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyTemplateObjectProperties }
     *     
     */
    public void setPropertyTemplateObjectProperties(PropertyTemplateObjectProperties value) {
        this.propertyTemplateObjectProperties = value;
    }

    /**
     * Gets the value of the propertyTemplateStringProperties property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyTemplateStringProperties }
     *     
     */
    public PropertyTemplateStringProperties getPropertyTemplateStringProperties() {
        return propertyTemplateStringProperties;
    }

    /**
     * Sets the value of the propertyTemplateStringProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyTemplateStringProperties }
     *     
     */
    public void setPropertyTemplateStringProperties(PropertyTemplateStringProperties value) {
        this.propertyTemplateStringProperties = value;
    }

}
