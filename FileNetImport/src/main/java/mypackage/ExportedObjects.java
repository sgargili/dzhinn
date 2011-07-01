
package mypackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element ref="{}LifeCycleActions"/>
 *         &lt;element ref="{}LifeCyclePolicies"/>
 *         &lt;element ref="{}ChoiceLists"/>
 *         &lt;element ref="{}PropertyTemplates"/>
 *         &lt;element ref="{}ClassDefinitions"/>
 *       &lt;/sequence>
 *       &lt;attribute name="EMVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "lifeCycleActions",
    "lifeCyclePolicies",
    "choiceLists",
    "propertyTemplates",
    "classDefinitions"
})
@XmlRootElement(name = "ExportedObjects")
public class ExportedObjects {

    @XmlElement(name = "LifeCycleActions", required = true)
    protected String lifeCycleActions;
    @XmlElement(name = "LifeCyclePolicies", required = true)
    protected String lifeCyclePolicies;
    @XmlElement(name = "ChoiceLists", required = true)
    protected ChoiceLists choiceLists;
    @XmlElement(name = "PropertyTemplates", required = true)
    protected PropertyTemplates propertyTemplates;
    @XmlElement(name = "ClassDefinitions", required = true)
    protected ClassDefinitions classDefinitions;
    @XmlAttribute(name = "EMVersion")
    protected String emVersion;

    /**
     * Gets the value of the lifeCycleActions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLifeCycleActions() {
        return lifeCycleActions;
    }

    /**
     * Sets the value of the lifeCycleActions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLifeCycleActions(String value) {
        this.lifeCycleActions = value;
    }

    /**
     * Gets the value of the lifeCyclePolicies property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLifeCyclePolicies() {
        return lifeCyclePolicies;
    }

    /**
     * Sets the value of the lifeCyclePolicies property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLifeCyclePolicies(String value) {
        this.lifeCyclePolicies = value;
    }

    /**
     * Gets the value of the choiceLists property.
     * 
     * @return
     *     possible object is
     *     {@link ChoiceLists }
     *     
     */
    public ChoiceLists getChoiceLists() {
        return choiceLists;
    }

    /**
     * Sets the value of the choiceLists property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChoiceLists }
     *     
     */
    public void setChoiceLists(ChoiceLists value) {
        this.choiceLists = value;
    }

    /**
     * Gets the value of the propertyTemplates property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyTemplates }
     *     
     */
    public PropertyTemplates getPropertyTemplates() {
        return propertyTemplates;
    }

    /**
     * Sets the value of the propertyTemplates property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyTemplates }
     *     
     */
    public void setPropertyTemplates(PropertyTemplates value) {
        this.propertyTemplates = value;
    }

    /**
     * Gets the value of the classDefinitions property.
     * 
     * @return
     *     possible object is
     *     {@link ClassDefinitions }
     *     
     */
    public ClassDefinitions getClassDefinitions() {
        return classDefinitions;
    }

    /**
     * Sets the value of the classDefinitions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassDefinitions }
     *     
     */
    public void setClassDefinitions(ClassDefinitions value) {
        this.classDefinitions = value;
    }

    /**
     * Gets the value of the emVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMVersion() {
        return emVersion;
    }

    /**
     * Sets the value of the emVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMVersion(String value) {
        this.emVersion = value;
    }

}
