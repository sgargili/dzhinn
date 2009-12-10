/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author APopov
 */
public class Match {

    String it4Article, nixArticle, nixDesc;

    public Match(String it4Article, String nixArticle, String nixDesc) {
        this.it4Article = it4Article;
        this.nixArticle = nixArticle;
        this.nixDesc = nixDesc;
    }

    public Match(String nixArticle, String nixDesc) {
        this.nixArticle = nixArticle;
        this.nixDesc = nixDesc;
    }

    public Match(String it4Article) {
        this.it4Article = it4Article;
    }

    public String getNixDesc() {
        return nixDesc;
    }

    public void setNixDesc(String nixDesc) {
        this.nixDesc = nixDesc;
    }

    public String getNixArticle() {
        return nixArticle;
    }

    public void setNixArticle(String NixArticle) {
        this.nixArticle = NixArticle;
    }

    public String getIt4Article() {
        return it4Article;
    }

    public void setIt4Article(String it4Article) {
        this.it4Article = it4Article;
    }
}
