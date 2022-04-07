package com.weather.backend.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.backend.controller.CityController;
import com.weather.backend.model.dto.Weather;
import com.weather.backend.model.WeatherUrl;
import com.weather.backend.model.dto.WeatherDTO;
import com.weather.backend.services.WeatherService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class WeatherServiceImpl implements WeatherService {
    private WeatherUrl weatherData;
    private RestTemplate restTemplate;
    private final CityController cityController;

    @Autowired
    public void setWeatherData(WeatherUrl weatherData) {
        this.weatherData = weatherData;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Weather forecast(String city, String country) {
        try {
            UriComponents uriComponents = UriComponentsBuilder
                    .newInstance()
                    .scheme("http")
                    .host(weatherData.getUrl())
                    .path("")
                    .query("q={keyword},{keyword}&appid={appid}&units=metric")
                    .buildAndExpand(city, country, weatherData.getApiKey());

            String uri = uriComponents.toUriString();

            ResponseEntity<String> resp = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(resp.getBody(), Weather.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Not working!");
        }
    }
}
