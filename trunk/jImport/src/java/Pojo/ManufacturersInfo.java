package Pojo;
// Generated 14.10.2009 15:47:44 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * ManufacturersInfo generated by hbm2java
 */
public class ManufacturersInfo  implements java.io.Serializable {


     private ManufacturersInfoId id;
     private String manufacturersName;
     private String manufacturersDescription;
     private String manufacturersMetaTitle;
     private String manufacturersMetaKeywords;
     private String manufacturersMetaDescription;
     private String manufacturersUrl;
     private int urlClicked;
     private Date dateLastClick;

    public ManufacturersInfo() {
    }

	
    public ManufacturersInfo(ManufacturersInfoId id, String manufacturersName, String manufacturersDescription, String manufacturersMetaTitle, String manufacturersMetaKeywords, String manufacturersMetaDescription, String manufacturersUrl, int urlClicked) {
        this.id = id;
        this.manufacturersName = manufacturersName;
        this.manufacturersDescription = manufacturersDescription;
        this.manufacturersMetaTitle = manufacturersMetaTitle;
        this.manufacturersMetaKeywords = manufacturersMetaKeywords;
        this.manufacturersMetaDescription = manufacturersMetaDescription;
        this.manufacturersUrl = manufacturersUrl;
        this.urlClicked = urlClicked;
    }
    public ManufacturersInfo(ManufacturersInfoId id, String manufacturersName, String manufacturersDescription, String manufacturersMetaTitle, String manufacturersMetaKeywords, String manufacturersMetaDescription, String manufacturersUrl, int urlClicked, Date dateLastClick) {
       this.id = id;
       this.manufacturersName = manufacturersName;
       this.manufacturersDescription = manufacturersDescription;
       this.manufacturersMetaTitle = manufacturersMetaTitle;
       this.manufacturersMetaKeywords = manufacturersMetaKeywords;
       this.manufacturersMetaDescription = manufacturersMetaDescription;
       this.manufacturersUrl = manufacturersUrl;
       this.urlClicked = urlClicked;
       this.dateLastClick = dateLastClick;
    }
   
    public ManufacturersInfoId getId() {
        return this.id;
    }
    
    public void setId(ManufacturersInfoId id) {
        this.id = id;
    }
    public String getManufacturersName() {
        return this.manufacturersName;
    }
    
    public void setManufacturersName(String manufacturersName) {
        this.manufacturersName = manufacturersName;
    }
    public String getManufacturersDescription() {
        return this.manufacturersDescription;
    }
    
    public void setManufacturersDescription(String manufacturersDescription) {
        this.manufacturersDescription = manufacturersDescription;
    }
    public String getManufacturersMetaTitle() {
        return this.manufacturersMetaTitle;
    }
    
    public void setManufacturersMetaTitle(String manufacturersMetaTitle) {
        this.manufacturersMetaTitle = manufacturersMetaTitle;
    }
    public String getManufacturersMetaKeywords() {
        return this.manufacturersMetaKeywords;
    }
    
    public void setManufacturersMetaKeywords(String manufacturersMetaKeywords) {
        this.manufacturersMetaKeywords = manufacturersMetaKeywords;
    }
    public String getManufacturersMetaDescription() {
        return this.manufacturersMetaDescription;
    }
    
    public void setManufacturersMetaDescription(String manufacturersMetaDescription) {
        this.manufacturersMetaDescription = manufacturersMetaDescription;
    }
    public String getManufacturersUrl() {
        return this.manufacturersUrl;
    }
    
    public void setManufacturersUrl(String manufacturersUrl) {
        this.manufacturersUrl = manufacturersUrl;
    }
    public int getUrlClicked() {
        return this.urlClicked;
    }
    
    public void setUrlClicked(int urlClicked) {
        this.urlClicked = urlClicked;
    }
    public Date getDateLastClick() {
        return this.dateLastClick;
    }
    
    public void setDateLastClick(Date dateLastClick) {
        this.dateLastClick = dateLastClick;
    }




}


