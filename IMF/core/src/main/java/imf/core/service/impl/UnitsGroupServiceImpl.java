package imf.core.service.impl;

import imf.core.dao.UnitOfMeasureDao;
import imf.core.dao.UnitsGroupDao;
import imf.core.dto.UnitsGroupDto;
import imf.core.dto.UnitsOfMeasureDto;
import imf.core.dto.web.request.BaseRequest;
import imf.core.dto.web.response.TreeResponse;
import imf.core.dto.web.response.UnitsGroupResponse;
import imf.core.dto.web.response.UnitsOfMeasureResponse;
import imf.core.dto.web.response.tree.BaseTreeNode;
import imf.core.entity.UnitOfMeasure;
import imf.core.entity.UnitsGroup;
import imf.core.service.UnitsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 18:03:19
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

    private List<BaseTreeNode> convertUnitsGroupListToTreeNodes(List<UnitsGroup> unitsGroups) {
        List<BaseTreeNode> treeNodes = new ArrayList<BaseTreeNode>();
        BaseTreeNode node;
        for (UnitsGroup unitsGroup : unitsGroups) {
            node = new BaseTreeNode();
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
    @Transactional
    public void addUnitsGroup(BaseRequest request) {
        unitsGroup = new UnitsGroup();
        unitsGroup.setName(request.getName());
        unitsGroup.setComment(request.getComment());
        unitsGroupDao.saveUnitsGroup(unitsGroup);
    }

    @Override
    @Transactional
    public void updateUnitsGroup(BaseRequest request) {
        unitsGroup = new UnitsGroup();
        unitsGroup.setId(request.getId());
        unitsGroup.setName(request.getName());
        unitsGroup.setComment(request.getComment());
        unitsGroupDao.updateUnitsGroup(unitsGroup);
    }

    @Override
    @Transactional
    public void deleteUnitsGroup(BaseRequest request) {
        unitsGroupDao.deleteUnitsGroupById(request.getId());
    }

    @Override
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public List<UnitsGroupDto> getAllUnitsGroup() {
        return convertUnitsGroupListToDtoList(unitsGroupDao.getAllUnitsGroups());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UnitsGroupDto> getUnitsGroup(int firstResult, int maxResult) {
        return convertUnitsGroupListToDtoList(unitsGroupDao.getUnitsGroups(firstResult, maxResult));
    }

    @Override
    @Transactional(readOnly = true)
    public UnitsGroupResponse getUnitsGroupResponse(int firstResult, int maxResult) {
        UnitsGroupResponse response = new UnitsGroupResponse();
        response.setTotalRowsCount(unitsGroupDao.getTotalRowsCount());
        response.setDtos(convertUnitsGroupListToDtoList(unitsGroupDao.getUnitsGroups(firstResult, maxResult)));
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public TreeResponse getUnitsGroupTreeResponse() {
        TreeResponse response = new TreeResponse();
        response.setDtos(convertUnitsGroupListToTreeNodes(unitsGroupDao.getAllUnitsGroups()));
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public UnitsOfMeasureResponse getUnitsOfMeasureResponse(Long id) {
        UnitsGroup ug = new UnitsGroup();
        ug.setId(id);
        UnitsOfMeasureResponse response = new UnitsOfMeasureResponse();
        response.setTotalRowsCount(unitOfMeasureDao.getTotalRowsByGroupId(id));
        response.setDtos(convertUnitsOfMeasureListToDtoList(unitOfMeasureDao.getUnitOfMeasuresByUnitsGroup(ug)));
        return response;
    }
}
