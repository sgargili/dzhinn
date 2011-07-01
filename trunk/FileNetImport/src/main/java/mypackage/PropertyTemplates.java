
package mypackage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}PropertyTemplateString" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}PropertyTemplateBoolean"/>
 *         &lt;element ref="{}PropertyTemplateObject"/>
 *         &lt;element ref="{}PropertyTemplateInteger32"/>
 *         &lt;element ref="{}PropertyTemplateDateTime" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}PropertyTemplateId"/>
 *         &lt;element ref="{}PropertyTemplateBinary"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "propertyTemplateStringOrPropertyTemplateBooleanOrPropertyTemplateObject"
})
@XmlRootElement(name = "PropertyTemplates")
public class PropertyTemplates {

    @XmlElements({
        @XmlElement(name = "PropertyTemplateDateTime", type = PropertyTemplateDateTime.class),
        @XmlElement(name = "PropertyTemplateInteger32", type = PropertyTemplateInteger32 .class),
        @XmlElement(name = "PropertyTemplateObject", type = PropertyTemplateObject.class),
        @XmlElement(name = "PropertyTemplateBoolean", type = PropertyTemplateBoolean.class),
        @XmlElement(name = "PropertyTemplateBinary", type = PropertyTemplateBinary.class),
        @XmlElement(name = "PropertyTemplateString", type = PropertyTemplateString.class),
        @XmlElement(name = "PropertyTemplateId", type = PropertyTemplateId.class)
    })
    protected List<Object> propertyTemplateStringOrPropertyTemplateBooleanOrPropertyTemplateObject;

    /**
     * Gets the value of the propertyTemplateStringOrPropertyTemplateBooleanOrPropertyTemplateObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyTemplateStringOrPropertyTemplateBooleanOrPropertyTemplateObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyTemplateStringOrPropertyTemplateBooleanOrPropertyTemplateObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyTemplateDateTime }
     * {@link PropertyTemplateInteger32 }
     * {@link PropertyTemplateObject }
     * {@link PropertyTemplateBoolean }
     * {@link PropertyTemplateBinary }
     * {@link PropertyTemplateString }
     * {@link PropertyTemplateId }
     * 
     * 
     */
    public List<Object> getPropertyTemplateStringOrPropertyTemplateBooleanOrPropertyTemplateObject() {
        if (propertyTemplateStringOrPropertyTemplateBooleanOrPropertyTemplateObject == null) {
            propertyTemplateStringOrPropertyTemplateBooleanOrPropertyTemplateObject = new ArrayList<Object>();
        }
        return this.propertyTemplateStringOrPropertyTemplateBooleanOrPropertyTemplateObject;
    }

}
