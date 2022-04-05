package com.weather.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonView
public class AverageDTO implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private BigDecimal daily;
    private BigDecimal nightly;
    private BigDecimal pressure;
    @JsonIgnore
    private BigDecimal totalDaily;
    @JsonIgnore
    private Integer quantDaily;
    @JsonIgnore
    private BigDecimal totalNightly;
    @JsonIgnore
    private Integer quantNightly;
    @JsonIgnore
    private BigDecimal totalPressure;
    @JsonIgnore
    private Integer quantPressure;

    public void plusMap(MapTimeDTO map) {
        if (map.isDaily()) {
            this.totalDaily = this.totalDaily.add(map.getMain().getTemp());
            this.quantDaily++;
        } else {
            this.totalNightly = this.totalNightly.add(map.getMain().getTemp());
            this.quantNightly++;
        }
        this.totalPressure = this.totalPressure.add(map.getMain().getTemp());
        this.quantPressure++;
    }

    public void totalize() {
        this.daily = (this.quantDaily > 0)
                ? this.totalDaily.divide(new BigDecimal(this.quantDaily.toString()), 2, RoundingMode.HALF_UP)
                : null;
        this.nightly = (this.quantNightly > 0)
                ? this.totalNightly.divide(new BigDecimal(this.quantNightly.toString()), 2, RoundingMode.HALF_UP)
                : null;
        this.pressure = (this.quantPressure > 0)
                ? this.totalPressure.divide(new BigDecimal(this.quantPressure.toString()), 2, RoundingMode.HALF_UP)
                : null;
    }
}