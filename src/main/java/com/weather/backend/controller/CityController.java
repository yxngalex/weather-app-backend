package com.weather.backend.controller;

import com.weather.backend.model.domain.CityType;
import com.weather.backend.services.CityService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
@CrossOrigin
public class CityController {
    private final CityService cityService;

    @GetMapping()
    @ApiOperation(value = "", nickname = "getAvailableCities")
    public ResponseEntity<List<CityType>> getAvailableCities() {
        return ResponseEntity.ok(Arrays.asList(CityType.values()));
    }

    @GetMapping("/{countryType}")
    @ApiOperation(value = "", nickname = "getAvailableCitiesByCountry")
    public ResponseEntity<List<CityType>> getAvailableCitiesByCountry(@PathVariable String countryType) {
        return ResponseEntity.ok(CityType.getValueByCountry(countryType));
    }

    @GetMapping("/autocomplete/country/{country}/city/{cityName}")
    @ApiOperation(value = "We  use this to simulate query for auto complete on front", nickname = "getCityAutocomplete")
    public ResponseEntity<List<CityType>> getCityAutocomplete(@PathVariable String country, @PathVariable String cityName) {
        return ResponseEntity.ok(cityService.getCityAutoComplete(country,cityName));
    }
}
