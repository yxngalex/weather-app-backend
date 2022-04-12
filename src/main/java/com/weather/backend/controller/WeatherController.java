package com.weather.backend.controller;

import com.weather.backend.model.dto.OneCall;
import com.weather.backend.model.dto.Weather;
import com.weather.backend.model.dto.WeatherDTO;
import com.weather.backend.services.WeatherService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/forecast")
@RequiredArgsConstructor

public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/lat/{lat}/lon/{lon}")
    @ApiOperation(value = "", nickname = "forecast")
    public ResponseEntity<OneCall> forecast(@PathVariable String lat, @PathVariable String lon) {
        return ResponseEntity.ok(weatherService.forecast(lat, lon));
    }

    @GetMapping("/country/{country}/city/{city}")
    @ApiOperation(value = "", nickname = "getWeather")
    public ResponseEntity<Weather> getWeather(@PathVariable String country, @PathVariable String city) {
        return ResponseEntity.ok(weatherService.weather(city, country));
    }

}
