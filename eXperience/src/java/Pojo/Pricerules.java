package Pojo;
// Generated 02.09.2009 10:24:26 by Hibernate Tools 3.2.1.GA



/**
 * Pricerules generated by hbm2java
 */
public class Pricerules  implements java.io.Serializable {


     private long id;
     private long shopId;
     private long manufacturerId;
     private long productTypeId;
     private Integer priceRule;

    public Pricerules() {
    }

	
    public Pricerules(long id, long shopId, long manufacturerId, long productTypeId) {
        this.id = id;
        this.shopId = shopId;
        this.manufacturerId = manufacturerId;
        this.productTypeId = productTypeId;
    }
    public Pricerules(long id, long shopId, long manufacturerId, long productTypeId, Integer priceRule) {
       this.id = id;
       this.shopId = shopId;
       this.manufacturerId = manufacturerId;
       this.productTypeId = productTypeId;
       this.priceRule = priceRule;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public long getShopId() {
        return this.shopId;
    }
    
    public void setShopId(long shopId) {
        this.shopId = shopId;
    }
    public long getManufacturerId() {
        return this.manufacturerId;
    }
    
    public void setManufacturerId(long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
    public long getProductTypeId() {
        return this.productTypeId;
    }
    
    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
    }
    public Integer getPriceRule() {
        return this.priceRule;
    }
    
    public void setPriceRule(Integer priceRule) {
        this.priceRule = priceRule;
    }




}

