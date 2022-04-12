package com.weather.backend.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Properties;

@Component
@RequiredArgsConstructor
public class WeatherUriFacade {
    @Resource(name = "weather")
    private Properties weatherProperty;


    private URI getUriFor(String lat, String lon) {
        return WeatherUriBuilder.instance(weatherProperty)
                .path(weatherProperty.getProperty("weather.url"))
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("appid", weatherProperty.getProperty("weather.apikey"))
                .queryParam("units", "metric")
                .queryParam("cnt", 7)
                .build()
                .encode()
                .toUri();
    }

    private URI getUriForCityAndCountry(String country, String city) {
        return WeatherUriBuilder.instance(weatherProperty)
                .path(weatherProperty.getProperty("weather.url.v2"))
                .queryParam("q", city + "," + country)
                .queryParam("appid", weatherProperty.getProperty("weather.apikey"))
                .build()
                .encode()
                .toUri();
    }

    public URI forOneCall(String lat, String lon) {
        return getUriFor(lat, lon);
    }

    public URI forWeather(String city, String country) {
        return getUriForCityAndCountry(country, city);
    }

//    UriComponents uriComponents = UriComponentsBuilder
//            .newInstance()
//            .scheme("http")
//            .host(weatherData.getUrl())
//            .path("")
//            .query("q={keyword},{keyword}&appid={appid}&units=metric&cnt=6")
//            .buildAndExpand(Double.parseDouble(lat), Double.parseDouble(lon), weatherData.getApiKey());
}
