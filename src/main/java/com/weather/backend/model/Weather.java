package com.weather.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable {
    private static final long serialVersionUID = 8407310731452442542L;
    private List<Map<String, Object>> weatherList;

    @JsonProperty("list")
    public void setList(List<Map<String, Object>> weatherEntries) {
        setWeatherList(weatherEntries.stream().limit(6).collect(Collectors.toList()));
    }
}
