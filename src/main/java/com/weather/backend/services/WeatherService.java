package com.weather.backend.services;

import org.springframework.http.ResponseEntity;

public interface WeatherService {
    ResponseEntity<?> forecastAverage(String lat, String lon);
}
