package pojo;
// Generated 12.03.2010 15:04:09 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Regexp generated by hbm2java
 */
public class Regexp  implements java.io.Serializable {


     private Integer regexpId;
     private String regexpValue;
     private Set attributeRules = new HashSet(0);

    public Regexp() {
    }

    public Regexp(String regexpValue, Set attributeRules) {
       this.regexpValue = regexpValue;
       this.attributeRules = attributeRules;
    }
   
    public Integer getRegexpId() {
        return this.regexpId;
    }
    
    public void setRegexpId(Integer regexpId) {
        this.regexpId = regexpId;
    }
    public String getRegexpValue() {
        return this.regexpValue;
    }
    
    public void setRegexpValue(String regexpValue) {
        this.regexpValue = regexpValue;
    }
    public Set getAttributeRules() {
        return this.attributeRules;
    }
    
    public void setAttributeRules(Set attributeRules) {
        this.attributeRules = attributeRules;
    }




}


