package com.weather.backend.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.backend.model.FormCity;
import com.weather.backend.model.Weather;
import com.weather.backend.model.WeatherUrl;
import com.weather.backend.services.WeatherService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private WeatherUrl weatherData;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Weather> forecast(FormCity city) {
        List<Weather> weathers = new ArrayList<>();
        try {
            UriComponents uriComponents = UriComponentsBuilder
                    .newInstance()
                    .scheme("http")
                    .host(weatherData.getUrl())
                    .path("")
                    .query("q={keyword}&appid={appid}")
                    .buildAndExpand(city.getCity(), weatherData.getApiKey());

            String uri = uriComponents.toUriString();

            ResponseEntity<String> resp = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);

            ObjectMapper mapper = new ObjectMapper();
            Weather weather = null;
            weather = mapper.readValue(resp.getBody(), Weather.class);

            weathers.add(weather);

            return weathers;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return weathers;
    }
}
