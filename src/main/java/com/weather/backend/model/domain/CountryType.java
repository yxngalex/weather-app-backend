package com.weather.backend.model.domain;

import com.weather.backend.util.Displayable;

public enum CountryType implements Displayable {
    RS("RS"),
    UK("UK"),
    US("US");

    private final String value;

    CountryType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
