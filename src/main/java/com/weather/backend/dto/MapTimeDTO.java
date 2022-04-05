package com.weather.backend.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonView
public class MapTimeDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @JsonProperty("dateTime_txt")
    private LocalDateTime dateTime;

    private MapTimeMainDTO main;

    @JsonIgnore
    public Boolean isDaily() {
        return (this.dateTime.getHour() >= 6 && this.dateTime.getHour() < 18);
    }

}
