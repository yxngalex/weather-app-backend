package com.weather.backend.util;

import lombok.NoArgsConstructor;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Properties;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class WeatherUriBuilder {
    private Properties properties;
    private UriComponentsBuilder uriComponentsBuilder;

    public static WeatherUriBuilder instance(Properties properties, String basePath) {
        WeatherUriBuilder builder = new WeatherUriBuilder();
        if (basePath == null)
            builder.uriComponentsBuilder = UriComponentsBuilder.fromUriString(properties.getProperty("base-url"));
        else
            builder.uriComponentsBuilder = UriComponentsBuilder.fromUriString(basePath);
        builder.properties = properties;
        return builder;
    }

    public static WeatherUriBuilder instance(Properties properties) {
        return instance(properties, null);
    }

    public WeatherUriBuilder propertyPath(String path) {
        uriComponentsBuilder.path(properties.getProperty(path));
        return this;
    }

    public WeatherUriBuilder path(String... path) {
        uriComponentsBuilder.pathSegment(path);
        return this;
    }

    public WeatherUriBuilder queryParam(String name, Object value) {
        uriComponentsBuilder.queryParam(name, value);
        return this;
    }

    public UriComponents build() {
        UriComponents build = uriComponentsBuilder.cloneBuilder().build();
        this.uriComponentsBuilder = UriComponentsBuilder.newInstance();
        return build;
    }

}
