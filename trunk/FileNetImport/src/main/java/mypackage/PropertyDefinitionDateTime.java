
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
 *         &lt;element ref="{}PropertyMaximumDateTime"/>
 *         &lt;element ref="{}PropertyMinimumDateTime"/>
 *         &lt;element ref="{}CopyToReservation"/>
 *         &lt;element ref="{}Settability"/>
 *         &lt;element ref="{}Name"/>
 *         &lt;element ref="{}ExternalAliases"/>
 *         &lt;element ref="{}ModificationAccessRequired"/>
 *         &lt;element ref="{}IsValueRequired"/>
 *         &lt;element ref="{}PropertyDefaultDateTime"/>
 *         &lt;element ref="{}IsNameProperty"/>
 *         &lt;element ref="{}PrimaryId"/>
 *         &lt;element ref="{}ChoiceList"/>
 *         &lt;element ref="{}AliasIds"/>
 *         &lt;element ref="{}IsHidden"/>
 *         &lt;element ref="{}MaximumLengthString"/>
 *         &lt;element ref="{}PropertyDefaultString"/>
 *         &lt;element ref="{}IsCBREnabled"/>
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
    "objectTypeOrPropertyMaximumDateTimeOrPropertyMinimumDateTime"
})
@XmlRootElement(name = "PropertyDefinitionDateTime")
public class PropertyDefinitionDateTime {

    @XmlElementRefs({
        @XmlElementRef(name = "IsValueRequired", type = JAXBElement.class),
        @XmlElementRef(name = "PropertyMinimumDateTime", type = JAXBElement.class),
        @XmlElementRef(name = "PropertyDefaultString", type = JAXBElement.class),
        @XmlElementRef(name = "IsNameProperty", type = JAXBElement.class),
        @XmlElementRef(name = "AliasIds", type = JAXBElement.class),
        @XmlElementRef(name = "ObjectType", type = JAXBElement.class),
        @XmlElementRef(name = "IsHidden", type = JAXBElement.class),
        @XmlElementRef(name = "Settability", type = JAXBElement.class),
        @XmlElementRef(name = "ExternalAliases", type = JAXBElement.class),
        @XmlElementRef(name = "Name", type = JAXBElement.class),
        @XmlElementRef(name = "PrimaryId", type = JAXBElement.class),
        @XmlElementRef(name = "ModificationAccessRequired", type = JAXBElement.class),
        @XmlElementRef(name = "MaximumLengthString", type = JAXBElement.class),
        @XmlElementRef(name = "ChoiceList", type = ChoiceList.class),
        @XmlElementRef(name = "PropertyDefaultDateTime", type = JAXBElement.class),
        @XmlElementRef(name = "CopyToReservation", type = JAXBElement.class),
        @XmlElementRef(name = "IsCBREnabled", type = JAXBElement.class),
        @XmlElementRef(name = "PropertyMaximumDateTime", type = JAXBElement.class)
    })
    protected List<Object> objectTypeOrPropertyMaximumDateTimeOrPropertyMinimumDateTime;

    /**
     * Gets the value of the objectTypeOrPropertyMaximumDateTimeOrPropertyMinimumDateTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectTypeOrPropertyMaximumDateTimeOrPropertyMinimumDateTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectTypeOrPropertyMaximumDateTimeOrPropertyMinimumDateTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Byte }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Short }{@code >}
     * {@link JAXBElement }{@code <}{@link Byte }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link ChoiceList }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Byte }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<Object> getObjectTypeOrPropertyMaximumDateTimeOrPropertyMinimumDateTime() {
        if (objectTypeOrPropertyMaximumDateTimeOrPropertyMinimumDateTime == null) {
            objectTypeOrPropertyMaximumDateTimeOrPropertyMinimumDateTime = new ArrayList<Object>();
        }
        return this.objectTypeOrPropertyMaximumDateTimeOrPropertyMinimumDateTime;
    }

}
