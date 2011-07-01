
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
 *         &lt;element ref="{}PropertyTemplateBinaryProperties" minOccurs="0"/>
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
    "propertyTemplateBinaryProperties",
    "propertyTemplateStringProperties"
})
@XmlRootElement(name = "PropertyTemplateBinary")
public class PropertyTemplateBinary {

    @XmlElement(name = "PropertyTemplateBinaryProperties")
    protected PropertyTemplateBinaryProperties propertyTemplateBinaryProperties;
    @XmlElement(name = "PropertyTemplateStringProperties")
    protected PropertyTemplateStringProperties propertyTemplateStringProperties;

    /**
     * Gets the value of the propertyTemplateBinaryProperties property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyTemplateBinaryProperties }
     *     
     */
    public PropertyTemplateBinaryProperties getPropertyTemplateBinaryProperties() {
        return propertyTemplateBinaryProperties;
    }

    /**
     * Sets the value of the propertyTemplateBinaryProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyTemplateBinaryProperties }
     *     
     */
    public void setPropertyTemplateBinaryProperties(PropertyTemplateBinaryProperties value) {
        this.propertyTemplateBinaryProperties = value;
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
