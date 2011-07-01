
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
 *         &lt;element ref="{}PropertyDefinitionObject"/>
 *         &lt;element ref="{}PropertyDefinitionBoolean"/>
 *         &lt;element ref="{}PropertyDefinitionInteger32"/>
 *         &lt;element ref="{}PropertyDefinitionString"/>
 *         &lt;element ref="{}PropertyDefinitionId"/>
 *         &lt;element ref="{}PropertyDefinitionBinary"/>
 *         &lt;element ref="{}PropertyDefinitionDateTime"/>
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
    "propertyDefinitionObjectOrPropertyDefinitionBooleanOrPropertyDefinitionInteger32"
})
@XmlRootElement(name = "PropertyDefinitions")
public class PropertyDefinitions {

    @XmlElements({
        @XmlElement(name = "PropertyDefinitionString", type = PropertyDefinitionString.class),
        @XmlElement(name = "PropertyDefinitionInteger32", type = PropertyDefinitionInteger32 .class),
        @XmlElement(name = "PropertyDefinitionId", type = PropertyDefinitionId.class),
        @XmlElement(name = "PropertyDefinitionDateTime", type = PropertyDefinitionDateTime.class),
        @XmlElement(name = "PropertyDefinitionBinary", type = PropertyDefinitionBinary.class),
        @XmlElement(name = "PropertyDefinitionBoolean", type = PropertyDefinitionBoolean.class),
        @XmlElement(name = "PropertyDefinitionObject", type = PropertyDefinitionObject.class)
    })
    protected List<Object> propertyDefinitionObjectOrPropertyDefinitionBooleanOrPropertyDefinitionInteger32;

    /**
     * Gets the value of the propertyDefinitionObjectOrPropertyDefinitionBooleanOrPropertyDefinitionInteger32 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyDefinitionObjectOrPropertyDefinitionBooleanOrPropertyDefinitionInteger32 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyDefinitionObjectOrPropertyDefinitionBooleanOrPropertyDefinitionInteger32().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyDefinitionString }
     * {@link PropertyDefinitionInteger32 }
     * {@link PropertyDefinitionId }
     * {@link PropertyDefinitionDateTime }
     * {@link PropertyDefinitionBinary }
     * {@link PropertyDefinitionBoolean }
     * {@link PropertyDefinitionObject }
     * 
     * 
     */
    public List<Object> getPropertyDefinitionObjectOrPropertyDefinitionBooleanOrPropertyDefinitionInteger32() {
        if (propertyDefinitionObjectOrPropertyDefinitionBooleanOrPropertyDefinitionInteger32 == null) {
            propertyDefinitionObjectOrPropertyDefinitionBooleanOrPropertyDefinitionInteger32 = new ArrayList<Object>();
        }
        return this.propertyDefinitionObjectOrPropertyDefinitionBooleanOrPropertyDefinitionInteger32;
    }

}
