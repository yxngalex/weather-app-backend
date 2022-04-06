package com.weather.backend.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.backend.controller.CityController;
import com.weather.backend.model.FormCity;
import com.weather.backend.model.FormCountry;
import com.weather.backend.model.Weather;
import com.weather.backend.model.WeatherUrl;
import com.weather.backend.model.domain.CityType;
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
    private final CityController cityController;

    @Override
    public Weather forecast(FormCity city) {
        try {
            UriComponents uriComponents = UriComponentsBuilder
                    .newInstance()
                    .scheme("http")
                    .host(weatherData.getUrl())
                    .path("")
                    .query("q={keyword}&appid={appid}&units=metric")
                    .buildAndExpand(city.getCity(), weatherData.getApiKey());

            String uri = uriComponents.toUriString();

            ResponseEntity<String> resp = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(resp.getBody(), Weather.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<CityType> sortCities(FormCountry country) {
//        List<CityType> cities = cityController.getAvailableCitiesByCountry(country.getCode()).getBody();
//        FormCity c = new FormCity();
//        List<Weather> weatherList = new ArrayList<>();
//
//        for (CityType city : cities) {
//            c.setCity(city.getValue());
//
//            weatherList.add(forecast(c));
//        }
//
//        System.out.println(weatherList);
//
//        return weatherList;
        return null;
    }
}
