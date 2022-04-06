package com.weather.backend.controller;

import com.weather.backend.model.FormCity;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    @GetMapping()
    @ApiOperation(value = "", nickname = "getAvailableCities")
    public ResponseEntity<List<FormCity>> getAvailableCities() {
//        return ResponseEntity.ok(cityService.getAll());
        return null;
    }
}
