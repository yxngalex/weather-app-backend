package com.weather.backend.services;

import com.weather.backend.model.dto.Weather;
import com.weather.backend.model.dto.WeatherDTO;


public interface WeatherService {
    Weather forecast(String city, String country);

}
