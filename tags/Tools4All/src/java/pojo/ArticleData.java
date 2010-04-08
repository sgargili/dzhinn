/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author APopov
 */
public class ArticleData {

    private String article1, article2, sovp;

    public ArticleData(String article1, String article2, String sovp) {
        this.article1 = article1;
        this.article2 = article2;
        this.sovp = sovp;
    }

    public ArticleData() {
    }

    public String getArticle1() {
        return article1;
    }

    public void setArticle1(String article1) {
        this.article1 = article1;
    }

    public String getArticle2() {
        return article2;
    }

    public void setArticle2(String article2) {
        this.article2 = article2;
    }

    public String getSovp() {
        return sovp;
    }

    public void setSovp(String sovp) {
        this.sovp = sovp;
    }
}
