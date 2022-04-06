package com.weather.backend.services;

import com.weather.backend.model.FormCity;
import com.weather.backend.model.Weather;


public interface WeatherService {
    Weather forecast(FormCity city);
}
