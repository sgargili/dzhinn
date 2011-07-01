
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
 *         &lt;element ref="{}PropertyTemplateStringProperties"/>
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
    "propertyTemplateStringProperties"
})
@XmlRootElement(name = "PropertyTemplateString")
public class PropertyTemplateString {

    @XmlElement(name = "PropertyTemplateStringProperties", required = true)
    protected PropertyTemplateStringProperties propertyTemplateStringProperties;

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
