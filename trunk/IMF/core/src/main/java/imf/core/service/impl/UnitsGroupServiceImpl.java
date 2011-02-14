package imf.core.service.impl;

import imf.core.dao.UnitOfMeasureDao;
import imf.core.dao.UnitsGroupDao;
import imf.core.dto.UnitsGroupDto;
import imf.core.dto.UnitsOfMeasureDto;
import imf.core.dto.web.request.UnitsGroupAddRequest;
import imf.core.dto.web.response.TreeResponse;
import imf.core.dto.web.response.UnitsGroupResponse;
import imf.core.dto.web.response.UnitsOfMeasureResponse;
import imf.core.dto.web.response.tree.TreeNode;
import imf.core.entity.UnitOfMeasure;
import imf.core.entity.UnitsGroup;
import imf.core.service.UnitsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 18:03:19
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Service("unitsGroupService")
public class UnitsGroupServiceImpl implements UnitsGroupService {
    @Autowired
    private UnitsGroupDao unitsGroupDao;
    @Autowired
    private UnitOfMeasureDao unitOfMeasureDao;

    private UnitsGroup unitsGroup;
    private List<UnitOfMeasure> units;
    private UnitsGroupDto unitsGroupDto;
    private UnitsOfMeasureDto unitOfMeasureDto;

    private UnitsOfMeasureDto convertUnitOfMeasureToDto(UnitOfMeasure unit) {
        UnitsOfMeasureDto dto = new UnitsOfMeasureDto();
        dto.setComment(unit.getComment());
        dto.setDefaultValue(unit.isDefaultValue());
        dto.setId(unit.getId());
        dto.setName(unit.getName());
        dto.setPrefix(unit.getPrefix());
        dto.setRatio(unit.getRatio());
        return dto;
    }

    private UnitsGroupDto convertUnitsGroupToDto(UnitsGroup ug) {
        UnitsGroupDto dto = new UnitsGroupDto();
        dto.setComment(ug.getComment());
        dto.setId(ug.getId());
        dto.setName(ug.getName());
        return dto;
    }

    private List<UnitsGroupDto> convertUnitsGroupListToDtoList(List<UnitsGroup> unitsGroups) {
        List<UnitsGroupDto> unitsGroupDtos = new ArrayList<UnitsGroupDto>();
        UnitsGroupDto dto;
        for (UnitsGroup unitsGroup : unitsGroups) {
            dto = new UnitsGroupDto();
            dto.setComment(unitsGroup.getComment());
            dto.setId(unitsGroup.getId());
            dto.setName(unitsGroup.getName());
            unitsGroupDtos.add(dto);
        }
        return unitsGroupDtos;
    }

    private List<TreeNode> convertUnitsGroupListToTreeNodes(List<UnitsGroup> unitsGroups) {
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        TreeNode node;
        for (UnitsGroup unitsGroup : unitsGroups) {
            node = new TreeNode();
            node.setId(unitsGroup.getId());
            node.setText(unitsGroup.getName());
            node.setLeaf(true);
            treeNodes.add(node);
        }
        return treeNodes;
    }

    private List<UnitsOfMeasureDto> convertUnitsOfMeasureListToDtoList(List<UnitOfMeasure> unitOfMeasures) {
        List<UnitsOfMeasureDto> unitsOfMeasureDtos = new ArrayList<UnitsOfMeasureDto>();
        UnitsOfMeasureDto dto;
        for (UnitOfMeasure unitOfMeasure : unitOfMeasures) {
            dto = new UnitsOfMeasureDto();
            dto.setComment(unitOfMeasure.getComment());
            dto.setId(unitOfMeasure.getId());
            dto.setName(unitOfMeasure.getName());
            dto.setDefaultValue(unitOfMeasure.isDefaultValue());
            dto.setPrefix(unitOfMeasure.getPrefix());
            dto.setRatio(unitOfMeasure.getRatio());
            unitsOfMeasureDtos.add(dto);
        }
        return unitsOfMeasureDtos;
    }

    @Override
    public void addUnitsGroup(UnitsGroupAddRequest request) {
        unitsGroup = new UnitsGroup();
        unitsGroup.setName(request.getName());
        unitsGroup.setComment(request.getComment());
        unitsGroupDao.saveUnitsGroup(unitsGroup);
    }

    @Override
    public void updateUnitsGroup(UnitsGroupAddRequest request) {
        unitsGroup = new UnitsGroup();
        unitsGroup.setId(request.getId());
        unitsGroup.setName(request.getName());
        unitsGroup.setComment(request.getComment());
        unitsGroupDao.updateUnitsGroup(unitsGroup);
    }

    @Override
    public void deleteUnitsGroup(UnitsGroupAddRequest request) {
        unitsGroupDao.deleteUnitsGroupById(request.getId());
    }

    @Override
    public UnitsGroupDto getUnitsGroupWithUnitsById(Long id) {
        unitsGroup = unitsGroupDao.getUnitsGroupById(id);
        unitsGroupDto = convertUnitsGroupToDto(unitsGroup);

        units = unitOfMeasureDao.getUnitOfMeasuresByUnitsGroup(unitsGroup);
        for (UnitOfMeasure um : units) {
            unitOfMeasureDto = convertUnitOfMeasureToDto(um);
            unitsGroupDto.addUnitOfMeasureDto(unitOfMeasureDto);
        }

        return unitsGroupDto;
    }

    @Override
    public List<UnitsGroupDto> getAllUnitsGroup() {
        return convertUnitsGroupListToDtoList(unitsGroupDao.getAllUnitsGroups());
    }

    @Override
    public List<UnitsGroupDto> getUnitsGroup(int firstResult, int maxResult) {
        return convertUnitsGroupListToDtoList(unitsGroupDao.getUnitsGroups(firstResult, maxResult));
    }

    @Override
    public UnitsGroupResponse getUnitsGroupResponse(int firstResult, int maxResult) {
        UnitsGroupResponse response = new UnitsGroupResponse();
        response.setTotalRowsCount(unitsGroupDao.getTotalRowsCount());
        response.setUnitsGroupDtos(convertUnitsGroupListToDtoList(unitsGroupDao.getUnitsGroups(firstResult, maxResult)));
        return response;
    }

    @Override
    public TreeResponse getUnitsGroupTreeResponse() {
        TreeResponse response = new TreeResponse();
        response.setNodes(convertUnitsGroupListToTreeNodes(unitsGroupDao.getAllUnitsGroups()));
        return response;
    }

    @Override
    public UnitsOfMeasureResponse getUnitsOfMeasureResponse(Long id) {
        UnitsGroup ug = new UnitsGroup();
        ug.setId(id);
        UnitsOfMeasureResponse response = new UnitsOfMeasureResponse();
        response.setTotalRowsCount(unitOfMeasureDao.getTotalRowsById(id));
        response.setUnitsOfMeasureDtos(convertUnitsOfMeasureListToDtoList(unitOfMeasureDao.getUnitOfMeasuresByUnitsGroup(ug)));
        return response;
    }


}
