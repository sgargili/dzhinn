package Pojo;
// Generated 07.04.2010 16:06:22 by Hibernate Tools 3.2.1.GA



/**
 * Newarticles generated by hbm2java
 */
public class Newarticles  implements java.io.Serializable {


     private Long id;
     private String keyart;
     private String vendor;
     private String pt;
     private String searchdesc;
     private String purl;
     private String picurl;
     private String attr;

    public Newarticles() {
    }

	
    public Newarticles(String picurl) {
        this.picurl = picurl;
    }
    public Newarticles(String keyart, String vendor, String pt, String searchdesc, String purl, String picurl, String attr) {
       this.keyart = keyart;
       this.vendor = vendor;
       this.pt = pt;
       this.searchdesc = searchdesc;
       this.purl = purl;
       this.picurl = picurl;
       this.attr = attr;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getKeyart() {
        return this.keyart;
    }
    
    public void setKeyart(String keyart) {
        this.keyart = keyart;
    }
    public String getVendor() {
        return this.vendor;
    }
    
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public String getPt() {
        return this.pt;
    }
    
    public void setPt(String pt) {
        this.pt = pt;
    }
    public String getSearchdesc() {
        return this.searchdesc;
    }
    
    public void setSearchdesc(String searchdesc) {
        this.searchdesc = searchdesc;
    }
    public String getPurl() {
        return this.purl;
    }
    
    public void setPurl(String purl) {
        this.purl = purl;
    }
    public String getPicurl() {
        return this.picurl;
    }
    
    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }
    public String getAttr() {
        return this.attr;
    }
    
    public void setAttr(String attr) {
        this.attr = attr;
    }




}


