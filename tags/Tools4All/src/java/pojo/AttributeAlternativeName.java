package pojo;
// Generated 19.04.2010 15:05:11 by Hibernate Tools 3.2.1.GA



/**
 * AttributeAlternativeName generated by hbm2java
 */
public class AttributeAlternativeName  implements java.io.Serializable {


     private Integer attributeAlernativeNameId;
     private Attribute attribute;
     private String attributeAlernativeNameValue;

    public AttributeAlternativeName() {
    }

	
    public AttributeAlternativeName(Attribute attribute) {
        this.attribute = attribute;
    }
    public AttributeAlternativeName(Attribute attribute, String attributeAlernativeNameValue) {
       this.attribute = attribute;
       this.attributeAlernativeNameValue = attributeAlernativeNameValue;
    }
   
    public Integer getAttributeAlernativeNameId() {
        return this.attributeAlernativeNameId;
    }
    
    public void setAttributeAlernativeNameId(Integer attributeAlernativeNameId) {
        this.attributeAlernativeNameId = attributeAlernativeNameId;
    }
    public Attribute getAttribute() {
        return this.attribute;
    }
    
    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
    public String getAttributeAlernativeNameValue() {
        return this.attributeAlernativeNameValue;
    }
    
    public void setAttributeAlernativeNameValue(String attributeAlernativeNameValue) {
        this.attributeAlernativeNameValue = attributeAlernativeNameValue;
    }




}


