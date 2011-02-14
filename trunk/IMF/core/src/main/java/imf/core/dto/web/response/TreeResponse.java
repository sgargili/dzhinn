package imf.core.dto.web.response;

import imf.core.dto.web.response.tree.TreeNode;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 05.02.11
 * Time: 0:00
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "tree")
public class TreeResponse {
    @XmlElement(name = "nodes")
    private List<TreeNode> nodes;

    public TreeResponse() {
    }

    public TreeResponse(List<TreeNode> nodes) {
        this.nodes = nodes;
    }

    public List<TreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeNode> nodes) {
        this.nodes = nodes;
    }
}
