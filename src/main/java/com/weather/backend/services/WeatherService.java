package com.weather.backend.services;

import com.weather.backend.model.FormCity;
import com.weather.backend.model.FormCountry;
import com.weather.backend.model.Weather;
import com.weather.backend.model.domain.CityType;

import java.util.List;


public interface WeatherService {
    Weather forecast(FormCity city);

    List<CityType> sortCities(FormCountry country);
}
