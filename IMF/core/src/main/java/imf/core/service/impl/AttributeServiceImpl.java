package imf.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import imf.core.dao.AttributeDao;
import imf.core.dto.AttributeDto;
import imf.core.dto.web.response.AttributeResponse;
import imf.core.entity.Attribute;
import imf.core.entity.Group;
import imf.core.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Developed by: Andrey Popov
 * Date (time): 21.02.11 (12:50)
 */
@Repository
@Service("attributeService")
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    AttributeDao attributeDao;

    private List<AttributeDto> convertAttributeListToDto(List<Attribute> attributes) {
        List<AttributeDto> attributeDtos = new ArrayList<AttributeDto>();
        AttributeDto dto;
        for (Attribute attribute : attributes) {

            dto = new AttributeDto();
            dto.setComment(attribute.getComment());
            dto.setId(attribute.getId());
            dto.setName(attribute.getName());
//            System.out.println(attribute.getAttribute2Groups());
//            dto.setRequire(attribute.getAttribute2Groups().get(0).isRequare());
//            dto.setComposite(attribute.getAttribute2Groups().get(0).isComposite());
//            try {
//                dto.setSubsGroup(attribute.getSubsGroup().getId());
//                dto.setUnitOfMeasure(attribute.getUnitOfMeasure().getId());
//                dto.setUnitsGroup(attribute.getUnitsGroup().getId());
//            } catch (NullPointerException ex) {
//            }
//            dto.setSubsGroup(attribute.getSubsGroup());
//            dto.setUnitsGroup(attribute.getUnitsGroup());
//            dto.setUnitOfMeasure(attribute.getUnitOfMeasure());
//            dto.setAttribute2Groups(attribute.getAttribute2Groups());
            dto.setType(attribute.getType());
            dto.setTypeOfValues(attribute.getType());
            attributeDtos.add(dto);
        }
        return attributeDtos;
    }

    @Override
    @Transactional
    public AttributeResponse getAttributesByGroupId(Long groupId) {
        Group group = new Group();
        group.setId(groupId);
        AttributeResponse response = new AttributeResponse();
        response.setDtos(attributeDao.getAllAttributesDtoByGroup(group));
        response.setTotalRowsCount(attributeDao.getTotalRowsByGroupId(groupId));
        return response;
    }

    @Override
    @Transactional
    public AttributeResponse getAttributesByGroupId(Long groupId, Integer firstResult) {
        Group group = new Group();
        group.setId(groupId);

        AttributeResponse response = new AttributeResponse();
        response.setDtos(attributeDao.getAttributesDtoByGroup(group, firstResult));
        response.setTotalRowsCount(attributeDao.getTotalRowsByGroupId(groupId));

        return response;
    }

    @Override
    @Transactional
    public AttributeResponse getAttributesByGroupId(Long groupId, Integer firstResult, Integer maxResult) {
        Group group = new Group();
        group.setId(groupId);

        AttributeResponse response = new AttributeResponse();
        response.setDtos(attributeDao.getAttributesDtoByGroup(group, firstResult, maxResult));
        response.setTotalRowsCount(attributeDao.getTotalRowsByGroupId(groupId));

        return response;
    }
}
