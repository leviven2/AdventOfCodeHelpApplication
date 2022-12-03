package com.voetballer06.domain.converter.impl;

import com.voetballer06.domain.converter.StringConverter;

public class IntegerFromStringConverter implements StringConverter<Integer> {
    @Override
    public Integer convertFromString(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException exception) {
            return null;
        }
    }
}
