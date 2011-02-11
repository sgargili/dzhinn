package imf.core.dto.web.response;

import imf.core.dto.web.response.tree.UnitsGroupTreeNode;

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
public class UnitsGroupTreeResponse {
    @XmlElement(name = "node")
    private List<UnitsGroupTreeNode> nodes;

    public UnitsGroupTreeResponse() {
    }

    public UnitsGroupTreeResponse(List<UnitsGroupTreeNode> nodes) {
        this.nodes = nodes;
    }

    public List<UnitsGroupTreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<UnitsGroupTreeNode> nodes) {
        this.nodes = nodes;
    }
}
