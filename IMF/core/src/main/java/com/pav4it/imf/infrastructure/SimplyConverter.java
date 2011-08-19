package com.pav4it.imf.infrastructure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pav4it.imf.BaseEntity;

import ar.com.fdvs.bean2bean.conversion.SpecializedTypeConverter;
import ar.com.fdvs.bean2bean.exceptions.CannotConvertException;

/**
 * @author Andrey Popov creates on 26.07.11 (18:50)
 */
public class SimplyConverter implements SpecializedTypeConverter<BaseEntity, BaseEntity> {
    private final Logger logger = LoggerFactory.getLogger(SimplyConverter.class);

//    @Override
//    public String convertTo(Type expectedType, String sourceObject, Annotation[] contextAnnotations) throws CannotConvertException {
//        if (expectedType.equals(String.class)) {
//            logger.error("true");
//        }
//        return sourceObject + "ssssssssssssssssssssssssssssss";
//    }

    @Override
    public BaseEntity convertTo(Type expectedType, BaseEntity sourceObject, Annotation[] contextAnnotations) throws CannotConvertException {
        if (expectedType.equals(String.class)) {
            logger.error("true");
        }
        return sourceObject;
    }
}
