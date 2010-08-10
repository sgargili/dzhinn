package pojo;
// Generated 13.04.2010 15:07:42 by Hibernate Tools 3.2.1.GA

/**
 * ParentRelateElement generated by hbm2java
 */
public class ParentRelateElement implements java.io.Serializable {

    public final static String PARENT = "Parent";
    public final static String RELATE = "Relate";
    private Integer parentRelateElementId;
    private String parentRelateElementName;
    private Byte parentRelateElementType;

    public ParentRelateElement() {
    }

    public ParentRelateElement(String parentRelateElementName, Byte parentRelateElementType) {
        this.parentRelateElementName = parentRelateElementName;
        this.parentRelateElementType = parentRelateElementType;
    }

    public Integer getParentRelateElementId() {
        return this.parentRelateElementId;
    }

    public void setParentRelateElementId(Integer parentRelateElementId) {
        this.parentRelateElementId = parentRelateElementId;
    }

    public String getParentRelateElementName() {
        return this.parentRelateElementName;
    }

    public void setParentRelateElementName(String parentRelateElementName) {
        this.parentRelateElementName = parentRelateElementName;
    }

    public Byte getParentRelateElementType() {
        return this.parentRelateElementType;
    }

    public void setParentRelateElementType(Byte parentRelateElementType) {
        this.parentRelateElementType = parentRelateElementType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ParentRelateElement other = (ParentRelateElement) obj;
        if ((this.parentRelateElementName == null) ? (other.parentRelateElementName != null) : !this.parentRelateElementName.equals(other.parentRelateElementName)) {
            return false;
        }
        if (this.parentRelateElementType != other.parentRelateElementType && (this.parentRelateElementType == null || !this.parentRelateElementType.equals(other.parentRelateElementType))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.parentRelateElementName != null ? this.parentRelateElementName.hashCode() : 0);
        hash = 47 * hash + (this.parentRelateElementType != null ? this.parentRelateElementType.hashCode() : 0);
        return hash;
    }
}

