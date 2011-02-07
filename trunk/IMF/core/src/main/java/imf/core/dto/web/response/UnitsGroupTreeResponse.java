package imf.core.dto.web.response;

import imf.core.dto.web.response.tree.UnitsGroupTreeNode;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonView;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 05.02.11
 * Time: 0:00
 */
@XmlRootElement
//@JsonIgnoreProperties(value = "nodes")
public class UnitsGroupTreeResponse {
    @JsonView
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
