
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
 *         &lt;element ref="{}DocumentClassDefinitionProperties"/>
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
    "documentClassDefinitionProperties"
})
@XmlRootElement(name = "DocumentClassDefinition")
public class DocumentClassDefinition {

    @XmlElement(name = "DocumentClassDefinitionProperties", required = true)
    protected DocumentClassDefinitionProperties documentClassDefinitionProperties;

    /**
     * Gets the value of the documentClassDefinitionProperties property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentClassDefinitionProperties }
     *     
     */
    public DocumentClassDefinitionProperties getDocumentClassDefinitionProperties() {
        return documentClassDefinitionProperties;
    }

    /**
     * Sets the value of the documentClassDefinitionProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentClassDefinitionProperties }
     *     
     */
    public void setDocumentClassDefinitionProperties(DocumentClassDefinitionProperties value) {
        this.documentClassDefinitionProperties = value;
    }

}
