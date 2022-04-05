package com.weather.backend.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weather.backend.model.FormCity;
import com.weather.backend.model.Weather;

import java.util.List;

public interface WeatherService {
    List<Weather> forecast(FormCity city);
}
