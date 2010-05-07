package Pojo;
// Generated 28.04.2010 14:22:54 by Hibernate Tools 3.2.1.GA



/**
 * KeyUploadInfo generated by hbm2java
 */
public class KeyUploadInfo  implements java.io.Serializable {


     private long id;
     private String keyart;
     private String uplKeyart;
     private String vendor;
     private String uplVendor;
     private String pt;
     private String uplPt;
     private String fulln;
     private String uplFulln;

    public KeyUploadInfo() {
    }

	
    public KeyUploadInfo(long id) {
        this.id = id;
    }
    public KeyUploadInfo(long id, String keyart, String uplKeyart, String vendor, String uplVendor, String pt, String uplPt, String fulln, String uplFulln) {
       this.id = id;
       this.keyart = keyart;
       this.uplKeyart = uplKeyart;
       this.vendor = vendor;
       this.uplVendor = uplVendor;
       this.pt = pt;
       this.uplPt = uplPt;
       this.fulln = fulln;
       this.uplFulln = uplFulln;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getKeyart() {
        return this.keyart;
    }
    
    public void setKeyart(String keyart) {
        this.keyart = keyart;
    }
    public String getUplKeyart() {
        return this.uplKeyart;
    }
    
    public void setUplKeyart(String uplKeyart) {
        this.uplKeyart = uplKeyart;
    }
    public String getVendor() {
        return this.vendor;
    }
    
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public String getUplVendor() {
        return this.uplVendor;
    }
    
    public void setUplVendor(String uplVendor) {
        this.uplVendor = uplVendor;
    }
    public String getPt() {
        return this.pt;
    }
    
    public void setPt(String pt) {
        this.pt = pt;
    }
    public String getUplPt() {
        return this.uplPt;
    }
    
    public void setUplPt(String uplPt) {
        this.uplPt = uplPt;
    }
    public String getFulln() {
        return this.fulln;
    }
    
    public void setFulln(String fulln) {
        this.fulln = fulln;
    }
    public String getUplFulln() {
        return this.uplFulln;
    }
    
    public void setUplFulln(String uplFulln) {
        this.uplFulln = uplFulln;
    }




}


