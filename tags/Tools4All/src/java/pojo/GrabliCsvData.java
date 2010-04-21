/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author APopov
 */
public class GrabliCsvData {

    private String article;
    private String description;
    private String pt;
    private String url;

    public GrabliCsvData(String article, String description, String pt, String url) {
        this.article = article;
        this.description = description;
        this.pt = pt;
        this.url = url;
    }

    public GrabliCsvData() {
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
