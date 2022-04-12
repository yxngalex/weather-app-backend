package com.weather.backend.services.impl;

import com.weather.backend.controller.CityController;
import com.weather.backend.model.dto.OneCall;
import com.weather.backend.model.dto.Weather;
import com.weather.backend.services.WeatherService;
import com.weather.backend.util.WeatherUriFacade;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class WeatherServiceImpl implements WeatherService {
    private final RestTemplate restTemplate;
    private final WeatherUriFacade weatherUriFacade;
    private final CityController cityController;


    @Override
    public OneCall forecast(String lat, String lon) {
        return restTemplate.exchange(weatherUriFacade.forOneCall(lat, lon),
                HttpMethod.POST, getHttpEntity(OneCall.class), OneCall.class).getBody();
    }

    @Override
    public Weather weather(String city, String country) {
        return restTemplate.exchange(weatherUriFacade.forWeather(city, country),
                HttpMethod.POST, getHttpEntity(Weather.class), Weather.class).getBody();
    }

    private <T> HttpEntity<T> getHttpEntity(T object) {
        return new HttpEntity<>(object);
    }
}
