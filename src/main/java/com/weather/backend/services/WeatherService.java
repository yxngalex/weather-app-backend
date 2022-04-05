package com.weather.backend.services;

import com.weather.backend.model.FormCity;
import com.weather.backend.model.Weather;

import java.util.List;

public interface WeatherService {
    Weather forecast(FormCity city);
}
