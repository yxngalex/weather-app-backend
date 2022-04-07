package com.weather.backend.services.impl;

import com.weather.backend.model.domain.CityType;
import com.weather.backend.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    @Override
    public List<CityType> getCityAutoComplete(String country,String cityName) {
        List<CityType> list = CityType.getValueByCountry(country);
        return list.stream()
                .filter(e -> e.name().toLowerCase(Locale.ROOT).startsWith(cityName.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }
}
