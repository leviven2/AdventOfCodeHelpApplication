package com.voetballer06.domain.converter.impl;

import com.voetballer06.domain.converter.StringConverter;

public class CharFromStringConverter implements StringConverter<Character> {
    @Override
    public Character convertFromString(String string) {
        return string.charAt(0);
    }
}
