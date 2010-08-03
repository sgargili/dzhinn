/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Apopov
 */
public class ValueArticle {

    private String Article, ArticleId;

    public ValueArticle() {
    }

    public ValueArticle(String Article, String ArticleId) {
        this.Article = Article;
        this.ArticleId = ArticleId;
    }

    public String getArticle() {
        return Article;
    }

    public void setArticle(String Article) {
        this.Article = Article;
    }

    public String getArticleId() {
        return ArticleId;
    }

    public void setArticleId(String ArticleId) {
        this.ArticleId = ArticleId;
    }
}
