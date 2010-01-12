/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author APopov
 */
public class ValueLink {

    private String article, classcatId, linkType, link;

    public ValueLink(String article, String classcatId, String linkType, String link) {
        this.article = article;
        this.classcatId = classcatId;
        this.linkType = linkType;
        this.link = link;
    }

    public ValueLink() {
    }

    public ValueLink(String article, String classcatId, String link) {
        this.article = article;
        this.classcatId = classcatId;
        this.link = link;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getClasscatId() {
        return classcatId;
    }

    public void setClasscatId(String classcatId) {
        this.classcatId = classcatId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
