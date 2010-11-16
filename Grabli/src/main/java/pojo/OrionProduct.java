package pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 16.11.2010
 * Time: 14:21:11
 * To change this template use File | Settings | File Templates.
 */
public class OrionProduct {
    private String article;
    private String name;
    private String fullName;
    private Map<String, String> aData;
    private List<ProductSpec> specs = new ArrayList<ProductSpec>();

    public OrionProduct() {
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Map<String, String> getaData() {
        return aData;
    }

    public void setaData(Map<String, String> aData) {
        this.aData = aData;
    }

    public List<ProductSpec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<ProductSpec> specs) {
        this.specs = specs;
    }

    public void addSpec(ProductSpec spec) {
        this.specs.add(spec);
    }
}
