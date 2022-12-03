package com.voetballer06.domain.converter.impl;

import com.voetballer06.domain.converter.StringConverter;

public class BooleanFromStringConverter implements StringConverter<Boolean> {
    @Override
    public Boolean convertFromString(String string) {
        if (string.equalsIgnoreCase("false") || string.equalsIgnoreCase("true")) {
            return Boolean.parseBoolean(string);
        }

        return null;
    }
}
