package com.weather.backend.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonView
public class MapTimeMainDTO {
    private BigDecimal temp;
    private BigDecimal temp_min;
    private BigDecimal temp_max;
    private BigDecimal pressure;
    private BigDecimal sea_level;
    private BigDecimal grnd_level;
    private BigDecimal humidity;
    private BigDecimal temp_kf;
}
