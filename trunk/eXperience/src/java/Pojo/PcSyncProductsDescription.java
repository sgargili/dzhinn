package Pojo;
// Generated 05.10.2009 11:25:48 by Hibernate Tools 3.2.1.GA



/**
 * PcSyncProductsDescription generated by hbm2java
 */
public class PcSyncProductsDescription  implements java.io.Serializable {


     private PcSyncProductsDescriptionId id;
     private String productsName;
     private String productsDescription;

    public PcSyncProductsDescription() {
    }

	
    public PcSyncProductsDescription(PcSyncProductsDescriptionId id, String productsName) {
        this.id = id;
        this.productsName = productsName;
    }
    public PcSyncProductsDescription(PcSyncProductsDescriptionId id, String productsName, String productsDescription) {
       this.id = id;
       this.productsName = productsName;
       this.productsDescription = productsDescription;
    }
   
    public PcSyncProductsDescriptionId getId() {
        return this.id;
    }
    
    public void setId(PcSyncProductsDescriptionId id) {
        this.id = id;
    }
    public String getProductsName() {
        return this.productsName;
    }
    
    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }
    public String getProductsDescription() {
        return this.productsDescription;
    }
    
    public void setProductsDescription(String productsDescription) {
        this.productsDescription = productsDescription;
    }




}


