package com.voetballer06.domain.converter.impl;

import com.voetballer06.domain.converter.StringConverter;

public class StringFromStringConverter implements StringConverter<String> {
    @Override
    public String convertFromString(String string) {
        return string;
    }
}
