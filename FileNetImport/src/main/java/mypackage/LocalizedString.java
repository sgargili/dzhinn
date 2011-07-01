
package mypackage;

import java.io.Serializable;
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
 *         &lt;element ref="{}LocalizedText"/>
 *         &lt;element ref="{}LocaleName"/>
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
    "objectTypeOrLocalizedTextOrLocaleName"
})
@XmlRootElement(name = "LocalizedString")
public class LocalizedString {

    @XmlElementRefs({
        @XmlElementRef(name = "LocalizedText", type = JAXBElement.class),
        @XmlElementRef(name = "ObjectType", type = JAXBElement.class),
        @XmlElementRef(name = "LocaleName", type = JAXBElement.class)
    })
    protected List<JAXBElement<? extends Serializable>> objectTypeOrLocalizedTextOrLocaleName;

    /**
     * Gets the value of the objectTypeOrLocalizedTextOrLocaleName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectTypeOrLocalizedTextOrLocaleName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectTypeOrLocalizedTextOrLocaleName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Short }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends Serializable>> getObjectTypeOrLocalizedTextOrLocaleName() {
        if (objectTypeOrLocalizedTextOrLocaleName == null) {
            objectTypeOrLocalizedTextOrLocaleName = new ArrayList<JAXBElement<? extends Serializable>>();
        }
        return this.objectTypeOrLocalizedTextOrLocaleName;
    }

}
