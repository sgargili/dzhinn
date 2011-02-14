package imf.core.service.impl;

import imf.core.dao.SubsGroupDao;
import imf.core.dao.UnitsGroupDao;
import imf.core.dto.web.response.TreeResponse;
import imf.core.dto.web.response.tree.TreeNode;
import imf.core.entity.SubsGroup;
import imf.core.entity.UnitsGroup;
import imf.core.service.SubsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by: Andrey Popov
 * Date (time): 14.02.11 (16:52)
 */
@Repository
@Service("subsGroupService")
public class SubsGroupServiceImpl implements SubsGroupService {
    @Autowired
    private SubsGroupDao subsGroupDao;

    private List<TreeNode> convertSubsGroupListToTreeNodes(List<SubsGroup> subsGroups) {
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        TreeNode node;
        for (SubsGroup subsGroup : subsGroups) {
            node = new TreeNode();
            node.setId(subsGroup.getId());
            node.setText(subsGroup.getName());
            node.setLeaf(true);
            treeNodes.add(node);
        }
        return treeNodes;
    }

    @Override
    @Transactional(readOnly = true)
    public TreeResponse getSubsGroupTreeResponse() {
        SubsGroup subsGroup =  subsGroupDao.getSubsGroupWithSubstitutesById(1L);
        System.out.println(subsGroup.getSubstitutes().size());
        TreeResponse response = new TreeResponse();
        response.setNodes(convertSubsGroupListToTreeNodes(subsGroupDao.getAllSubsGroups()));
        return response;
    }
}
