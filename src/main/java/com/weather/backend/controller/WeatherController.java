package com.weather.backend.controller;

import com.weather.backend.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping(value = "/forecast-average")
    public ResponseEntity<?> forecastAverage(@RequestParam String lat, @RequestParam String lon) {
       return weatherService.forecastAverage(lat, lon);
    }

}
