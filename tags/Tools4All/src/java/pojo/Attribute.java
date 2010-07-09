package pojo;
// Generated 05.04.2010 14:56:34 by Hibernate Tools 3.2.1.GA

import java.util.ArrayList;
import java.util.List;

/**
 * Attribute generated by hbm2java
 */
public class Attribute implements java.io.Serializable {

    private Integer attributeId;
    private String attributeName;
    private String attributeAlternative;
    private List<Value> values = new ArrayList(0);
    private List<ProductType> productTypes = new ArrayList(0);
    private List<Groupe> groupes = new ArrayList(0);
    private List<AttributeAlternativeName> attributeAlternativeNames = new ArrayList(0);

    public Attribute() {
    }

    public Attribute(String attributeName, String attributeAlternative, List<Value> values, List<ProductType> productTypes) {
        this.attributeName = attributeName;
        this.attributeAlternative = attributeAlternative;
        this.values = values;
        this.productTypes = productTypes;
    }

    public List<AttributeAlternativeName> getAttributeAlternativeNames() {
        return attributeAlternativeNames;
    }

    public void setAttributeAlternativeNames(List<AttributeAlternativeName> attributeAlternativeNames) {
        this.attributeAlternativeNames = attributeAlternativeNames;
    }

    public Integer getAttributeId() {
        return this.attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeAlternative() {
        return this.attributeAlternative;
    }

    public void setAttributeAlternative(String attributeAlternative) {
        this.attributeAlternative = attributeAlternative;
    }

    public List<Value> getValues() {
        return this.values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public List<ProductType> getProductTypes() {
        return this.productTypes;
    }

    public void setProductTypes(List<ProductType> productTypes) {
        this.productTypes = productTypes;
    }

    public List<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(List<Groupe> groupes) {
        this.groupes = groupes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Attribute other = (Attribute) obj;
        if ((this.attributeName == null) ? (other.attributeName != null) : !this.attributeName.equals(other.attributeName)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.attributeId != null ? this.attributeId.hashCode() : 0);
        return hash;
    }
}
