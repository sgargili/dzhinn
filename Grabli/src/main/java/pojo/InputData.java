package pojo;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 11.11.2010
 * Time: 11:46:30
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "input_data", catalog = "grablidb")
@Entity
public class InputData {
    private Integer id;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Long sessionId;

    @Column(name = "session_id")
    @Basic
    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    private String fullName;

    @Column(name = "full_name")
    @Basic
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private String manufacturer;

    @Column(name = "manufacturer")
    @Basic
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    private String article;

    @Column(name = "article")
    @Basic
    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    private String productType;

    @Column(name = "product_type")
    @Basic
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    private String picUrl;

    @Column(name = "pic_url")
    @Basic
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    private String groupe;

    @Column(name = "groupe")
    @Basic
    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    private String attribute;

    @Column(name = "attribute")
    @Basic
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    private String attributeValue;

    @Column(name = "attribute_value")
    @Basic
    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    private String priceRetail;

    @Column(name = "price_retail")
    @Basic
    public String getPriceRetail() {
        return priceRetail;
    }

    public void setPriceRetail(String priceRetail) {
        this.priceRetail = priceRetail;
    }

    private String priceBulk;

    @Column(name = "price_bulk")
    @Basic
    public String getPriceBulk() {
        return priceBulk;
    }

    public void setPriceBulk(String priceBulk) {
        this.priceBulk = priceBulk;
    }

    private String priceDealer;

    @Column(name = "price_dealer")
    @Basic
    public String getPriceDealer() {
        return priceDealer;
    }

    public void setPriceDealer(String priceDealer) {
        this.priceDealer = priceDealer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InputData inputData = (InputData) o;

        if (article != null ? !article.equals(inputData.article) : inputData.article != null) return false;
        if (attribute != null ? !attribute.equals(inputData.attribute) : inputData.attribute != null) return false;
        if (attributeValue != null ? !attributeValue.equals(inputData.attributeValue) : inputData.attributeValue != null)
            return false;
        if (fullName != null ? !fullName.equals(inputData.fullName) : inputData.fullName != null) return false;
        if (groupe != null ? !groupe.equals(inputData.groupe) : inputData.groupe != null) return false;
        if (id != null ? !id.equals(inputData.id) : inputData.id != null) return false;
        if (manufacturer != null ? !manufacturer.equals(inputData.manufacturer) : inputData.manufacturer != null)
            return false;
        if (picUrl != null ? !picUrl.equals(inputData.picUrl) : inputData.picUrl != null) return false;
        if (priceBulk != null ? !priceBulk.equals(inputData.priceBulk) : inputData.priceBulk != null) return false;
        if (priceDealer != null ? !priceDealer.equals(inputData.priceDealer) : inputData.priceDealer != null)
            return false;
        if (priceRetail != null ? !priceRetail.equals(inputData.priceRetail) : inputData.priceRetail != null)
            return false;
        if (productType != null ? !productType.equals(inputData.productType) : inputData.productType != null)
            return false;
        if (sessionId != null ? !sessionId.equals(inputData.sessionId) : inputData.sessionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (article != null ? article.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (picUrl != null ? picUrl.hashCode() : 0);
        result = 31 * result + (groupe != null ? groupe.hashCode() : 0);
        result = 31 * result + (attribute != null ? attribute.hashCode() : 0);
        result = 31 * result + (attributeValue != null ? attributeValue.hashCode() : 0);
        result = 31 * result + (priceRetail != null ? priceRetail.hashCode() : 0);
        result = 31 * result + (priceBulk != null ? priceBulk.hashCode() : 0);
        result = 31 * result + (priceDealer != null ? priceDealer.hashCode() : 0);
        return result;
    }

    private Shop shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id", nullable = false, insertable = true, updatable = true)
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
