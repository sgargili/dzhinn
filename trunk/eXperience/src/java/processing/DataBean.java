/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processing;

/**
 *
 * @author PAV
 */
public class DataBean {
private String Article;
private String Article_Id;
private String Status;

    public DataBean(String Article, String Article_Id, String Status) {
        this.Article = Article;
        this.Article_Id = Article_Id;
        this.Status = Status;
    }

    public String getArticle() {
        return Article;
    }

    public String getArticle_Id() {
        return Article_Id;
    }

    public String getStatus() {
        return Status;
    }

}
