package pojo;
// Generated 09.06.2010 15:56:25 by Hibernate Tools 3.2.1.GA



/**
 * InputData generated by hbm2java
 */
public class InputData_1  implements java.io.Serializable {


     private Integer inputDataId;
     private Long sessionId;
     private String article;
     private String description;
     private String productType;
     private String url;

    public InputData_1() {
    }

    public InputData_1(Long sessionId, String article, String description, String productType, String url) {
       this.sessionId = sessionId;
       this.article = article;
       this.description = description;
       this.productType = productType;
       this.url = url;
    }
   
    public Integer getInputDataId() {
        return this.inputDataId;
    }
    
    public void setInputDataId(Integer inputDataId) {
        this.inputDataId = inputDataId;
    }
    public Long getSessionId() {
        return this.sessionId;
    }
    
    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }
    public String getArticle() {
        return this.article;
    }
    
    public void setArticle(String article) {
        this.article = article;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getProductType() {
        return this.productType;
    }
    
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }




}


