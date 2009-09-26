/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author APopov
 */
public class SupplierPriceSearch {

    private String Supplier, Article, Description, Currency;
    private Double Price;

    public SupplierPriceSearch(String Supplier, String Article, String Description, Double Price) {
        this.Supplier = Supplier;
        this.Article = Article;
        this.Description = Description;
        this.Price = Price;
    }

    public SupplierPriceSearch(String Supplier, String Article, String Description, Double Price, String Currency) {
        this.Supplier = Supplier;
        this.Article = Article;
        this.Description = Description;
        this.Currency = Currency;
        this.Price = Price;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String Currency) {
        this.Currency = Currency;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String Supplier) {
        this.Supplier = Supplier;
    }

    public String getArticle() {
        return Article;
    }

    public void setArticle(String Article) {
        this.Article = Article;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }
}
