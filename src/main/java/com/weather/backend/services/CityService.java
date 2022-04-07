package com.weather.backend.services;

import com.weather.backend.model.domain.CityType;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CityService {

    List<CityType> getCityAutoComplete(String country,String cityName);
}
