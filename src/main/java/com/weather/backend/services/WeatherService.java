package com.weather.backend.services;

import com.weather.backend.model.dto.Weather;


public interface WeatherService {
    Weather forecast(String lat, String lon);

    Weather weather(String city, String country);
}
