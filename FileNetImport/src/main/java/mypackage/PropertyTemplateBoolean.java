
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
 *         &lt;element ref="{}PropertyTemplateBooleanProperties" minOccurs="0"/>
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
    "propertyTemplateBooleanProperties",
    "propertyTemplateStringProperties"
})
@XmlRootElement(name = "PropertyTemplateBoolean")
public class PropertyTemplateBoolean {

    @XmlElement(name = "PropertyTemplateBooleanProperties")
    protected PropertyTemplateBooleanProperties propertyTemplateBooleanProperties;
    @XmlElement(name = "PropertyTemplateStringProperties")
    protected PropertyTemplateStringProperties propertyTemplateStringProperties;

    /**
     * Gets the value of the propertyTemplateBooleanProperties property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyTemplateBooleanProperties }
     *     
     */
    public PropertyTemplateBooleanProperties getPropertyTemplateBooleanProperties() {
        return propertyTemplateBooleanProperties;
    }

    /**
     * Sets the value of the propertyTemplateBooleanProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyTemplateBooleanProperties }
     *     
     */
    public void setPropertyTemplateBooleanProperties(PropertyTemplateBooleanProperties value) {
        this.propertyTemplateBooleanProperties = value;
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
