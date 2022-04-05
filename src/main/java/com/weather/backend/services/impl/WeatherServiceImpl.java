package com.weather.backend.services.impl;

import com.weather.backend.dto.AverageDTO;
import com.weather.backend.dto.MapDTO;
import com.weather.backend.dto.MapTimeDTO;
import com.weather.backend.services.WeatherService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class WeatherServiceImpl implements WeatherService {
    private final String URI = "api.openweathermap.org/data/2.5/forecast";
    private final String API_KEY = "03efd5d8476a0f5be9ed912e37718985";
    private final RestTemplate restTemplate;

    @Override
    public ResponseEntity<?> forecastAverage(String lat, String lon) {
        List<AverageDTO> result = new ArrayList<>();
        try {
            MapDTO weatherMap = this.restTemplate.getForObject(this.url(lat, lon), MapDTO.class);

            for (LocalDate reference = LocalDate.now();
                 reference.isBefore(LocalDate.now().plusDays(4));
                 reference = reference.plusDays(1)) {
                final LocalDate ref = reference;
                List<MapTimeDTO> collect = weatherMap.getList().stream()
                        .filter(x -> x.getDateTime().toLocalDate().equals(ref)).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(collect)) {
                    result.add(this.average(collect));
                }

            }
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(new Json(e.getResponseBodyAsString()), e.getStatusCode());
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private AverageDTO average(List<MapTimeDTO> list) {
        AverageDTO result = new AverageDTO();

        for (MapTimeDTO item : list) {
            result.setDate(item.getDateTime().toLocalDate());
            result.plusMap(item);
        }

        result.totalize();

        return result;
    }

    private String url(String lat, String lon) {
        return String.format(URI.concat("?lat=%s").concat("&lon=%s").concat("&appid=%s").concat("&units=metric"), lat, lon, API_KEY);
    }
}
