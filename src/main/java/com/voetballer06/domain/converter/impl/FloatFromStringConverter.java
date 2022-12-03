package com.voetballer06.domain.converter.impl;

import com.voetballer06.domain.converter.StringConverter;

public class FloatFromStringConverter implements StringConverter<Float> {
    @Override
    public Float convertFromString(String string) {
        try {
            return Float.parseFloat(string);
        } catch (NumberFormatException exception) {
            return null;
        }
    }
}
