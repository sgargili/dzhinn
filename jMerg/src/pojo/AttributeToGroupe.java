package pojo;
// Generated 12.03.2010 15:04:09 by Hibernate Tools 3.2.1.GA



/**
 * AttributeToGroupe generated by hbm2java
 */
public class AttributeToGroupe  implements java.io.Serializable {


     private Integer attributeToGroupeId;
     private Attribute attribute;
     private Groupe groupe;

    public AttributeToGroupe() {
    }

    public AttributeToGroupe(Attribute attribute, Groupe groupe) {
       this.attribute = attribute;
       this.groupe = groupe;
    }
   
    public Integer getAttributeToGroupeId() {
        return this.attributeToGroupeId;
    }
    
    public void setAttributeToGroupeId(Integer attributeToGroupeId) {
        this.attributeToGroupeId = attributeToGroupeId;
    }
    public Attribute getAttribute() {
        return this.attribute;
    }
    
    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
    public Groupe getGroupe() {
        return this.groupe;
    }
    
    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }




}

