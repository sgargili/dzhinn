/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author PAV
 */
public class FcenterProduct {

    private int article;
    private String description;
    private String url;
    private String productType;
    private String packageType;
    private String priceRetail;
    private String priceDealer;

    public FcenterProduct() {
    }

    public FcenterProduct(int article, String description, String url, String productType, String packageType, String priceRetail, String priceDealer) {
        this.article = article;
        this.description = description;
        this.url = url;
        this.productType = productType;
        this.packageType = packageType;
        this.priceRetail = priceRetail;
        this.priceDealer = priceDealer;
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getPriceDealer() {
        return priceDealer;
    }

    public void setPriceDealer(String priceDealer) {
        this.priceDealer = priceDealer;
    }

    public String getPriceRetail() {
        return priceRetail;
    }

    public void setPriceRetail(String priceRetail) {
        this.priceRetail = priceRetail;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
