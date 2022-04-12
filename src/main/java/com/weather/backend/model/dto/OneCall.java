package com.weather.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OneCall implements Serializable {

    private static final long serialVersionUID = 2434910628945834202L;

    private List<Map<String, Object>> daily;

    @Bean
    public OneCall oneCall() {
        return new OneCall();
    }

    public OneCall() {
        super();
        // TODO Auto-generated constructor stub
    }

    public OneCall(Weather weather) {
        // TODO Auto-generated constructor stub
    }

    public List<Map<String, Object>> getDaily() {
        return daily;
    }

    public void setDaily(List<Map<String, Object>> daily) {
        this.daily = daily;
    }

    @JsonProperty("daily")
    public void setList(List<Map<String, Object>> weatherEntries) {
        setDaily(weatherEntries);
    }
}
