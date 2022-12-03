package com.voetballer06.domain.converter;

import com.voetballer06.domain.converter.impl.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

@SuppressWarnings("unchecked")
public class StringConverterFactory {

    private static HashMap<Class<?>, Class<? extends StringConverter<?>>> TYPE_TO_CONVERTER_MAP = new HashMap<>() {{
        put(Boolean.class, BooleanFromStringConverter.class);
        put(Character.class, CharFromStringConverter.class);
        put(Double.class, DoubleFromStringConverter.class);
        put(Float.class, FloatFromStringConverter.class);
        put(Integer.class, IntegerFromStringConverter.class);
        put(Long.class, LongFromStringConverter.class);
        put(String.class, StringFromStringConverter.class);
    }};

    public <T> StringConverter<T> createStringConverterFromType(Class<T> type) {
        try {
            Constructor<? extends StringConverter<?>> constructor = TYPE_TO_CONVERTER_MAP.get(type).getConstructor();
            return (StringConverter<T>) constructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
