package com.pav4it.imf.infrastructure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import ar.com.fdvs.bean2bean.conversion.SpecializedTypeConverter;
import ar.com.fdvs.bean2bean.exceptions.CannotConvertException;

/**
 * @author Andrey Popov creates on 26.07.11 (18:50)
 */
public class SimplyConverter implements SpecializedTypeConverter<String, String> {
    @Override
    public String convertTo(Type expectedType, String sourceObject, Annotation[] contextAnnotations) throws CannotConvertException {
        System.out.println();
        return sourceObject + "ssssssssssssssssssssssssssssss";
    }
}
