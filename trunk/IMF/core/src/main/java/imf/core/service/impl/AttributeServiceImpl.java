package imf.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import imf.core.dao.AttributeDao;
import imf.core.dto.AttributeDto;
import imf.core.dto.web.request.AttributeRequest;
import imf.core.dto.web.response.AttributeResponse;
import imf.core.entity.*;
import imf.core.service.AttributeService;

/**
 * Developed by: Andrey Popov
 * Date (time): 21.02.11 (12:50)
 */
@Service("attributeService")
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    private AttributeDao attributeDao;

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
//                dto.setSubsGroupId(attribute.getSubsGroupId().getId());
//                dto.setUnitOfMeasureId(attribute.getUnitOfMeasureId().getId());
//                dto.setUnitsGroupId(attribute.getUnitsGroupId().getId());
//            } catch (NullPointerException ex) {
//            }
//            dto.setSubsGroupId(attribute.getSubsGroupId());
//            dto.setUnitsGroupId(attribute.getUnitsGroupId());
//            dto.setUnitOfMeasureId(attribute.getUnitOfMeasureId());
//            dto.setAttribute2Groups(attribute.getAttribute2Groups());
            dto.setType(attribute.getType());
            dto.setTypeOfValues(attribute.getType());
            attributeDtos.add(dto);
        }
        return attributeDtos;
    }

    private Attribute convertAttributeRequestToAttribute(AttributeRequest attributeRequest) {
        Attribute attribute = new Attribute();

        attribute.setId(attributeRequest.getId());
        attribute.setName(attributeRequest.getName());
        attribute.setComment(attributeRequest.getComment());
        attribute.setType(attributeRequest.getType());
        attribute.setTypeOfValues(attributeRequest.getTypeOfValues());


        UnitsGroup unitsGroup = new UnitsGroup();
        unitsGroup.setId(attributeRequest.getUnitsGroupId());
        attribute.setUnitsGroup(unitsGroup);

        SubsGroup subsGroup = new SubsGroup();
        subsGroup.setId(attributeRequest.getSubsGroupId());
        attribute.setSubsGroup(subsGroup);

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(attributeRequest.getUnitOfMeasureId());
        attribute.setUnitOfMeasure(unitOfMeasure);

        return attribute;
    }

    private AttributeResponse convertAttributesToAttributeResponse(List<Attribute> attributes) {
        AttributeResponse response = new AttributeResponse();
        AttributeDto dto;
        for (Attribute attribute : attributes) {
            dto = new AttributeDto();
            dto.setId(attribute.getId());
            dto.setName(attribute.getName());
            dto.setComment(attribute.getComment());
            dto.setType(attribute.getType());
            dto.setTypeOfValues(attribute.getTypeOfValues());
            if (attribute.getSubsGroup() != null) {
                dto.setSubsGroup(attribute.getSubsGroup().getId());
            }
            if (attribute.getUnitOfMeasure() != null) {
                dto.setUnitOfMeasure(attribute.getUnitOfMeasure().getId());
            }
            if (attribute.getUnitsGroup() != null) {
                dto.setUnitsGroup(attribute.getUnitsGroup().getId());
            }

            response.addDto(dto);
        }
        return response;
    }

    @Override
    public Attribute addAttribute(AttributeRequest attributeRequest) {
        return attributeDao.saveAttribute(convertAttributeRequestToAttribute(attributeRequest));
    }

    @Override
    public void updateAttribute(AttributeRequest attributeRequest) {
        attributeDao.updateAttribute(convertAttributeRequestToAttribute(attributeRequest));
    }

    @Override
    public void deleteAttribute(AttributeRequest attributeRequest) {
        attributeDao.deleteAttribute(convertAttributeRequestToAttribute(attributeRequest));
    }

    @Override
    @Transactional
    public Boolean isAttributePresentByName(String attributeName) {
        return attributeDao.isAttributePresentByName(attributeName);
    }

    @Override
    @Transactional
    public AttributeResponse getAttributesByName(String attributeName) {
        AttributeResponse response = convertAttributesToAttributeResponse(attributeDao.getAllAttributesByName(attributeName));
        response.setTotalRowsCount(attributeDao.getTotalRowsByAttributeName(attributeName));
        return response;
    }

    @Override
    @Transactional
    public AttributeResponse getAttributesByName(String attributeName, Integer firstResult) {
        AttributeResponse response = convertAttributesToAttributeResponse(attributeDao.getAttributesByName(attributeName, firstResult));
        response.setTotalRowsCount(attributeDao.getTotalRowsByAttributeName(attributeName));
        return response;
    }

    @Override
    @Transactional
    public AttributeResponse getAttributesByName(String attributeName, Integer firstResult, Integer maxResult) {
        AttributeResponse response = convertAttributesToAttributeResponse(attributeDao.getAttributesByName(attributeName, firstResult, maxResult));
        response.setTotalRowsCount(attributeDao.getTotalRowsByAttributeName(attributeName));
        return response;
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
