package com.weather.backend.model.domain;

import com.weather.backend.util.Displayable;

public enum CountryType implements Displayable {
    RS("RS"),
    GB("GB"),
    US("US");

    private final String value;

    CountryType(String value) {
        this.value = value;
    }

    @Override
    public String getDisplayName() {
        return value;
    }
}
