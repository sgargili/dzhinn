package pojo;
// Generated 30.09.2010 0:13:36 by Hibernate Tools 3.2.1.GA


/**
 * InputData generated by hbm2java
 */
public class InputData implements java.io.Serializable {


    private Integer id;
    private Shop shop;
    private Long sessionId;
    private String fullName;
    private String manufacturer;
    private String article;
    private String productType;
    private String picUrl;
    private String groupe;
    private String attribute;
    private String attributeValue;
    private String priceRetail;
    private String priceBulk;
    private String priceDealer;

    public InputData() {
    }

    public InputData(Shop shop, Long sessionId, String fullName, String manufacturer, String article, String productType, String picUrl, String groupe, String attribute, String attributeValue, String priceRetail, String priceBulk, String priceDealer) {
        this.shop = shop;
        this.sessionId = sessionId;
        this.fullName = fullName;
        this.manufacturer = manufacturer;
        this.article = article;
        this.productType = productType;
        this.picUrl = picUrl;
        this.groupe = groupe;
        this.attribute = attribute;
        this.attributeValue = attributeValue;
        this.priceRetail = priceRetail;
        this.priceBulk = priceBulk;
        this.priceDealer = priceDealer;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Shop getShop() {
        return this.shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Long getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getArticle() {
        return this.article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getProductType() {
        return this.productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getGroupe() {
        return this.groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttributeValue() {
        return this.attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public String getPriceRetail() {
        return this.priceRetail;
    }

    public void setPriceRetail(String priceRetail) {
        this.priceRetail = priceRetail;
    }

    public String getPriceBulk() {
        return this.priceBulk;
    }

    public void setPriceBulk(String priceBulk) {
        this.priceBulk = priceBulk;
    }

    public String getPriceDealer() {
        return this.priceDealer;
    }

    public void setPriceDealer(String priceDealer) {
        this.priceDealer = priceDealer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("InputData");
        sb.append("{article='").append(article).append('\'');
        sb.append(", id=").append(id);
        sb.append(", shop=").append(shop);
        sb.append(", sessionId=").append(sessionId);
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", manufacturer='").append(manufacturer).append('\'');
        sb.append(", productType='").append(productType).append('\'');
        sb.append(", picUrl='").append(picUrl).append('\'');
        sb.append(", groupe='").append(groupe).append('\'');
        sb.append(", attribute='").append(attribute).append('\'');
        sb.append(", attributeValue='").append(attributeValue).append('\'');
        sb.append(", priceRetail='").append(priceRetail).append('\'');
        sb.append(", priceBulk='").append(priceBulk).append('\'');
        sb.append(", priceDealer='").append(priceDealer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


