package com.weather.backend.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonView
@JacksonXmlRootElement(localName = "weather")
public class MapDTO implements Serializable {
    private String cod;
    private BigDecimal message;
    private Integer cnt;
    @JacksonXmlProperty(localName = "list")
    @JacksonXmlElementWrapper(localName = "list", useWrapping = false)
    private List<MapTimeDTO> list;
}
