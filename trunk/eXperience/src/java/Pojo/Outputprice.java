package Pojo;
// Generated 02.09.2009 10:24:26 by Hibernate Tools 3.2.1.GA



/**
 * Outputprice generated by hbm2java
 */
public class Outputprice  implements java.io.Serializable {


     private long id;
     private long shopId;
     private String it4profitArticleName;
     private Double it4profitArticlePrice;
     private Integer currencyId;

    public Outputprice() {
    }

	
    public Outputprice(long id, long shopId, String it4profitArticleName) {
        this.id = id;
        this.shopId = shopId;
        this.it4profitArticleName = it4profitArticleName;
    }
    public Outputprice(long id, long shopId, String it4profitArticleName, Double it4profitArticlePrice, Integer currencyId) {
       this.id = id;
       this.shopId = shopId;
       this.it4profitArticleName = it4profitArticleName;
       this.it4profitArticlePrice = it4profitArticlePrice;
       this.currencyId = currencyId;
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
    public String getIt4profitArticleName() {
        return this.it4profitArticleName;
    }
    
    public void setIt4profitArticleName(String it4profitArticleName) {
        this.it4profitArticleName = it4profitArticleName;
    }
    public Double getIt4profitArticlePrice() {
        return this.it4profitArticlePrice;
    }
    
    public void setIt4profitArticlePrice(Double it4profitArticlePrice) {
        this.it4profitArticlePrice = it4profitArticlePrice;
    }
    public Integer getCurrencyId() {
        return this.currencyId;
    }
    
    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }




}

