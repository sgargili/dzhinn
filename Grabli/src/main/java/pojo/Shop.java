package pojo;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 11.11.2010
 * Time: 11:46:33
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Shop {
    private Integer shopId;

    @Column(name = "shop_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    private String shopName;

    @Column(name = "shop_name")
    @Basic
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    private String shopUrl;

    @Column(name = "shop_url")
    @Basic
    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    private String shopComment;

    @Column(name = "shop_comment")
    @Basic
    public String getShopComment() {
        return shopComment;
    }

    public void setShopComment(String shopComment) {
        this.shopComment = shopComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (shopComment != null ? !shopComment.equals(shop.shopComment) : shop.shopComment != null) return false;
        if (shopId != null ? !shopId.equals(shop.shopId) : shop.shopId != null) return false;
        if (shopName != null ? !shopName.equals(shop.shopName) : shop.shopName != null) return false;
        if (shopUrl != null ? !shopUrl.equals(shop.shopUrl) : shop.shopUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shopId != null ? shopId.hashCode() : 0;
        result = 31 * result + (shopName != null ? shopName.hashCode() : 0);
        result = 31 * result + (shopUrl != null ? shopUrl.hashCode() : 0);
        result = 31 * result + (shopComment != null ? shopComment.hashCode() : 0);
        return result;
    }

    private List<InputData> inputData;

    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
    public List<InputData> getInputData() {
        return inputData;
    }

    public void setInputData(List<InputData> inputData) {
        this.inputData = inputData;
    }
}
