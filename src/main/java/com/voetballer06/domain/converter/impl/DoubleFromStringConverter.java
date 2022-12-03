package com.voetballer06.domain.converter.impl;

import com.voetballer06.domain.converter.StringConverter;

public class DoubleFromStringConverter implements StringConverter<Double> {
    @Override
    public Double convertFromString(String string) {
        try {
            return Double.parseDouble(string);
        } catch (NumberFormatException exception) {
            return null;
        }
    }
}
