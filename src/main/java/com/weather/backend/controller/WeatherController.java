package com.weather.backend.controller;

import com.weather.backend.model.FormCity;
import com.weather.backend.model.FormCountry;
import com.weather.backend.model.Weather;
import com.weather.backend.model.domain.CityType;
import com.weather.backend.model.domain.CountryType;
import com.weather.backend.services.WeatherService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/forecast")
    @ApiOperation(value = "", nickname = "forecast")
    public ResponseEntity<Weather> forecast(@RequestBody FormCity city) {
        return ResponseEntity.ok(weatherService.forecast(city));
    }

    @GetMapping("/average")
    @ApiOperation(value = "", nickname = "sortCitiesByAverageTemp")
    public ResponseEntity<List<CityType>> sortCitiesByAverageTemp(@RequestBody FormCountry country) {
        return ResponseEntity.ok(weatherService.sortCities(country));
    }

}
