
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
 *         &lt;element ref="{}ObjectType"/>
 *         &lt;element ref="{}Name"/>
 *         &lt;element ref="{}ChoiceType"/>
 *         &lt;element ref="{}ChoiceStringValue"/>
 *         &lt;element ref="{}DisplayNames"/>
 *         &lt;element ref="{}ChoiceIntegerValue"/>
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
    "objectType",
    "name",
    "choiceType",
    "choiceStringValue",
    "displayNames",
    "choiceIntegerValue"
})
@XmlRootElement(name = "Choice")
public class Choice {

    @XmlElement(name = "ObjectType")
    protected short objectType;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "ChoiceType")
    protected byte choiceType;
    @XmlElement(name = "ChoiceStringValue", required = true)
    protected String choiceStringValue;
    @XmlElement(name = "DisplayNames", required = true)
    protected DisplayNames displayNames;
    @XmlElement(name = "ChoiceIntegerValue", required = true)
    protected String choiceIntegerValue;

    /**
     * Gets the value of the objectType property.
     * 
     */
    public short getObjectType() {
        return objectType;
    }

    /**
     * Sets the value of the objectType property.
     * 
     */
    public void setObjectType(short value) {
        this.objectType = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the choiceType property.
     * 
     */
    public byte getChoiceType() {
        return choiceType;
    }

    /**
     * Sets the value of the choiceType property.
     * 
     */
    public void setChoiceType(byte value) {
        this.choiceType = value;
    }

    /**
     * Gets the value of the choiceStringValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChoiceStringValue() {
        return choiceStringValue;
    }

    /**
     * Sets the value of the choiceStringValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChoiceStringValue(String value) {
        this.choiceStringValue = value;
    }

    /**
     * Gets the value of the displayNames property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayNames }
     *     
     */
    public DisplayNames getDisplayNames() {
        return displayNames;
    }

    /**
     * Sets the value of the displayNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayNames }
     *     
     */
    public void setDisplayNames(DisplayNames value) {
        this.displayNames = value;
    }

    /**
     * Gets the value of the choiceIntegerValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChoiceIntegerValue() {
        return choiceIntegerValue;
    }

    /**
     * Sets the value of the choiceIntegerValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChoiceIntegerValue(String value) {
        this.choiceIntegerValue = value;
    }

}
