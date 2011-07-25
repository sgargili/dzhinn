package com.pav4it.imf;

import java.lang.reflect.ParameterizedType;

/**
 * @author Администратор creates on 23.07.11 (14:26)
 */
public class Value<T> {
    private T value;

    @SuppressWarnings("unchecked")
    protected Class<Object> getClazz() {
        return (Class<Object>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
