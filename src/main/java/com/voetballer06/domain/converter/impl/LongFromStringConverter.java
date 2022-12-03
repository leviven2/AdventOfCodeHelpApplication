package com.voetballer06.domain.converter.impl;

import com.voetballer06.domain.converter.StringConverter;

public class LongFromStringConverter implements StringConverter<Long> {
    @Override
    public Long convertFromString(String string) {
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException exception) {
            return null;
        }
    }
}
