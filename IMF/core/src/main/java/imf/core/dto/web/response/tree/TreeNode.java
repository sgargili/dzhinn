package imf.core.dto.web.response.tree;

import javax.xml.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 04.02.11
 * Time: 23:53
 */
@XmlRootElement
public class TreeNode {
    private Long id;
    private String text;
    private Boolean leaf;

    public TreeNode() {
    }

    public TreeNode(Long id, Boolean leaf, String text) {
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
