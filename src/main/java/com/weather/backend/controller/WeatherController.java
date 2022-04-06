package com.weather.backend.controller;

import com.weather.backend.model.FormCity;
import com.weather.backend.model.Weather;
import com.weather.backend.services.WeatherService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping(value = "/forecast")
    @ApiOperation(value = "", nickname = "forecast")
    public ResponseEntity<Weather> forecast(@RequestBody FormCity city) {
        return ResponseEntity.ok(weatherService.forecast(city));
    }

}
