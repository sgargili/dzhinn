package Pojo;
// Generated 05.10.2009 11:25:48 by Hibernate Tools 3.2.1.GA



/**
 * PcSyncProductsDescriptionId generated by hbm2java
 */
public class PcSyncProductsDescriptionId  implements java.io.Serializable {


     private int productsId;
     private int languageId;

    public PcSyncProductsDescriptionId() {
    }

    public PcSyncProductsDescriptionId(int productsId, int languageId) {
       this.productsId = productsId;
       this.languageId = languageId;
    }
   
    public int getProductsId() {
        return this.productsId;
    }
    
    public void setProductsId(int productsId) {
        this.productsId = productsId;
    }
    public int getLanguageId() {
        return this.languageId;
    }
    
    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PcSyncProductsDescriptionId) ) return false;
		 PcSyncProductsDescriptionId castOther = ( PcSyncProductsDescriptionId ) other; 
         
		 return (this.getProductsId()==castOther.getProductsId())
 && (this.getLanguageId()==castOther.getLanguageId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getProductsId();
         result = 37 * result + this.getLanguageId();
         return result;
   }   


}

