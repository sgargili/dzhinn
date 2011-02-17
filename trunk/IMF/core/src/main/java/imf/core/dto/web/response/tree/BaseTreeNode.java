package imf.core.dto.web.response.tree;

/**
 * User: Andrey Popov
 * Date: 04.02.11
 * Time: 23:53
 */
public class BaseTreeNode {
    private Long id;
    private String text;
    private Boolean leaf;

    public BaseTreeNode() {
    }

    public BaseTreeNode(Long id, Boolean leaf, String text) {
        this.id = id;
        this.leaf = leaf;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }
}
