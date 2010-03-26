/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author APopov
 */
public class UploadModel {

    private String article, groupe, attribute, value, measure, compositeFactor, status;

    public UploadModel() {
    }

    public UploadModel(String article, String groupe, String attribute, String value, String status) {
        this.article = article;
        this.groupe = groupe;
        this.attribute = attribute;
        this.value = value;
        this.measure = "";
        this.compositeFactor = "";
        this.status = status;
    }

    public UploadModel(String article, String groupe, String attribute, String value, String measure, String compositeFactor, String status) {
        this.article = article;
        this.groupe = groupe;
        this.attribute = attribute;
        this.value = value;
        this.measure = measure;
        this.compositeFactor = compositeFactor;
        this.status = status;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getCompositeFactor() {
        return compositeFactor;
    }

    public void setCompositeFactor(String compositeFactor) {
        this.compositeFactor = compositeFactor;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
