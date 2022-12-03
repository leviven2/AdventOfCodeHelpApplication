package com.voetballer06.domain.converter;

public interface StringConverter<T> {
    T convertFromString(String string);
}
