package pojo;
// Generated 12.03.2010 15:04:09 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Bank generated by hbm2java
 */
public class Bank  implements java.io.Serializable {


     private Integer bankId;
     private String bankName;
     private Set groupes = new HashSet(0);
     private Set matchingsForBankIdFrom = new HashSet(0);
     private Set matchingsForBankIdTo = new HashSet(0);
     private Set models = new HashSet(0);
     private Set attributes = new HashSet(0);
     private Set articles = new HashSet(0);

    public Bank() {
    }

    public Bank(String bankName, Set groupes, Set matchingsForBankIdFrom, Set matchingsForBankIdTo, Set models, Set attributes, Set articles) {
       this.bankName = bankName;
       this.groupes = groupes;
       this.matchingsForBankIdFrom = matchingsForBankIdFrom;
       this.matchingsForBankIdTo = matchingsForBankIdTo;
       this.models = models;
       this.attributes = attributes;
       this.articles = articles;
    }
   
    public Integer getBankId() {
        return this.bankId;
    }
    
    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }
    public String getBankName() {
        return this.bankName;
    }
    
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public Set getGroupes() {
        return this.groupes;
    }
    
    public void setGroupes(Set groupes) {
        this.groupes = groupes;
    }
    public Set getMatchingsForBankIdFrom() {
        return this.matchingsForBankIdFrom;
    }
    
    public void setMatchingsForBankIdFrom(Set matchingsForBankIdFrom) {
        this.matchingsForBankIdFrom = matchingsForBankIdFrom;
    }
    public Set getMatchingsForBankIdTo() {
        return this.matchingsForBankIdTo;
    }
    
    public void setMatchingsForBankIdTo(Set matchingsForBankIdTo) {
        this.matchingsForBankIdTo = matchingsForBankIdTo;
    }
    public Set getModels() {
        return this.models;
    }
    
    public void setModels(Set models) {
        this.models = models;
    }
    public Set getAttributes() {
        return this.attributes;
    }
    
    public void setAttributes(Set attributes) {
        this.attributes = attributes;
    }
    public Set getArticles() {
        return this.articles;
    }
    
    public void setArticles(Set articles) {
        this.articles = articles;
    }




}


