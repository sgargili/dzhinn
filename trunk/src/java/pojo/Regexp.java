package pojo;
// Generated 27.07.2010 19:19:29 by Hibernate Tools 3.2.1.GA

/**
 * Regexp generated by hbm2java
 */
public class Regexp implements java.io.Serializable {

    private Integer regexpId;
    private AttributeAlternativeName attributeAlternativeName;
    private String regexpType;
    private String regexpPattern;
    private String regexpReplacement;
    private Byte dataUsage;
    private Integer weight;
    private Boolean regexpLast;

    public Regexp() {
    }

    public Regexp(AttributeAlternativeName attributeAlternativeName, String regexpType, String regexpPattern, String regexpReplacement, Byte dataUsage) {
        this.attributeAlternativeName = attributeAlternativeName;
        this.regexpType = regexpType;
        this.regexpPattern = regexpPattern;
        this.regexpReplacement = regexpReplacement;
        this.dataUsage = dataUsage;
    }

    public Integer getRegexpId() {
        return this.regexpId;
    }

    public void setRegexpId(Integer regexpId) {
        this.regexpId = regexpId;
    }

    public AttributeAlternativeName getAttributeAlternativeName() {
        return this.attributeAlternativeName;
    }

    public void setAttributeAlternativeName(AttributeAlternativeName attributeAlternativeName) {
        this.attributeAlternativeName = attributeAlternativeName;
    }

    public String getRegexpType() {
        return this.regexpType;
    }

    public void setRegexpType(String regexpType) {
        this.regexpType = regexpType;
    }

    public String getRegexpPattern() {
        return this.regexpPattern;
    }

    public void setRegexpPattern(String regexpPattern) {
        this.regexpPattern = regexpPattern;
    }

    public String getRegexpReplacement() {
        return this.regexpReplacement;
    }

    public void setRegexpReplacement(String regexpReplacement) {
        this.regexpReplacement = regexpReplacement;
    }

    public Byte getDataUsage() {
        return this.dataUsage;
    }

    public void setDataUsage(Byte dataUsage) {
        this.dataUsage = dataUsage;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getRegexpLast() {
        return regexpLast;
    }

    public void setRegexpLast(Boolean regexpLast) {
        this.regexpLast = regexpLast;
    }
    
}
