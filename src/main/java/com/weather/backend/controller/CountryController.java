package com.weather.backend.controller;

import com.weather.backend.model.domain.CountryType;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {

    @GetMapping()
    @ApiOperation(value = "", nickname = "getAllCountries")
    public ResponseEntity<List<CountryType>> getAllCountries() {
        return ResponseEntity.ok(Arrays.asList(CountryType.values()));
    }

}
