package com.weather.backend.controller;

import com.weather.backend.model.domain.CityType;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

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
}
