
package mypackage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
 *         &lt;element ref="{}ObjectType"/>
 *         &lt;element ref="{}IsNameProperty"/>
 *         &lt;element ref="{}MaximumLengthBinary"/>
 *         &lt;element ref="{}CopyToReservation"/>
 *         &lt;element ref="{}Settability"/>
 *         &lt;element ref="{}Name"/>
 *         &lt;element ref="{}PropertyDefaultBinary"/>
 *         &lt;element ref="{}ExternalAliases"/>
 *         &lt;element ref="{}IsValueRequired"/>
 *         &lt;element ref="{}ModificationAccessRequired"/>
 *         &lt;element ref="{}PrimaryId"/>
 *         &lt;element ref="{}ChoiceList"/>
 *         &lt;element ref="{}AliasIds"/>
 *         &lt;element ref="{}IsHidden"/>
 *         &lt;element ref="{}TargetAccessRequired"/>
 *         &lt;element ref="{}RequiredClassId"/>
 *         &lt;element ref="{}ReflectivePropertyId"/>
 *         &lt;element ref="{}DeletionAction"/>
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
    "objectTypeOrIsNamePropertyOrMaximumLengthBinary"
})
@XmlRootElement(name = "PropertyDefinitionBinary")
public class PropertyDefinitionBinary {

    @XmlElementRefs({
        @XmlElementRef(name = "IsValueRequired", type = JAXBElement.class),
        @XmlElementRef(name = "ReflectivePropertyId", type = JAXBElement.class),
        @XmlElementRef(name = "IsNameProperty", type = JAXBElement.class),
        @XmlElementRef(name = "AliasIds", type = JAXBElement.class),
        @XmlElementRef(name = "IsHidden", type = JAXBElement.class),
        @XmlElementRef(name = "RequiredClassId", type = JAXBElement.class),
        @XmlElementRef(name = "ObjectType", type = JAXBElement.class),
        @XmlElementRef(name = "Settability", type = JAXBElement.class),
        @XmlElementRef(name = "ExternalAliases", type = JAXBElement.class),
        @XmlElementRef(name = "Name", type = JAXBElement.class),
        @XmlElementRef(name = "PrimaryId", type = JAXBElement.class),
        @XmlElementRef(name = "ModificationAccessRequired", type = JAXBElement.class),
        @XmlElementRef(name = "PropertyDefaultBinary", type = JAXBElement.class),
        @XmlElementRef(name = "ChoiceList", type = ChoiceList.class),
        @XmlElementRef(name = "DeletionAction", type = JAXBElement.class),
        @XmlElementRef(name = "CopyToReservation", type = JAXBElement.class),
        @XmlElementRef(name = "TargetAccessRequired", type = JAXBElement.class),
        @XmlElementRef(name = "MaximumLengthBinary", type = JAXBElement.class)
    })
    protected List<Object> objectTypeOrIsNamePropertyOrMaximumLengthBinary;

    /**
     * Gets the value of the objectTypeOrIsNamePropertyOrMaximumLengthBinary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectTypeOrIsNamePropertyOrMaximumLengthBinary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectTypeOrIsNamePropertyOrMaximumLengthBinary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Byte }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Short }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Byte }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link ChoiceList }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Byte }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<Object> getObjectTypeOrIsNamePropertyOrMaximumLengthBinary() {
        if (objectTypeOrIsNamePropertyOrMaximumLengthBinary == null) {
            objectTypeOrIsNamePropertyOrMaximumLengthBinary = new ArrayList<Object>();
        }
        return this.objectTypeOrIsNamePropertyOrMaximumLengthBinary;
    }

}
