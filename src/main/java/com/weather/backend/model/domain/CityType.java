package com.weather.backend.model.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import com.weather.backend.util.Displayable;

import java.util.Arrays;
import java.util.List;

public enum CityType implements Displayable {
    BEOGRAD("Beograd"),
    NOVISAD("Novi Sad"),
    NIS("Niš"),
    WASHINGTON("Washington"),
    NEWYORK("New York"),
    LOSANGELES("Los Angeles"),
    LONDON("London"),
    MANCHESTER("Manchester"),
    BIRMINGHAM("Birmingham");

    private final String displayName;

    CityType(String value) {
        this.displayName = value;
    }

    @JsonValue
    @Override
    public String getDisplayName() {
        return displayName;
    }

    public static List<CityType> getValueByCountry(String countryType) {

        switch (CountryType.valueOf(countryType.toUpperCase())) {
            case RS:
                return Arrays.asList(BEOGRAD, NIS, NOVISAD);
            case US:
                return Arrays.asList(WASHINGTON, NEWYORK, LOSANGELES);
            case GB:
                return Arrays.asList(LONDON, MANCHESTER, BIRMINGHAM);
        }

        return null;
    }
}
