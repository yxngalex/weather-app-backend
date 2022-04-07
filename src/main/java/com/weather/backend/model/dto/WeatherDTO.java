package com.weather.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDTO {
    public final String cod;
    public final long message;
    public final long cnt;
    public final List list[];
    public final City city;

    @JsonCreator
    public WeatherDTO(@JsonProperty("cod") String cod, @JsonProperty("message") long message, @JsonProperty("cnt") long cnt, @JsonProperty("list") List[] list, @JsonProperty("city") City city) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    public static final class List {
        public final long dt;
        public final Main main;
        public final Weather weather[];
        public final Clouds clouds;
        public final Wind wind;
        public final long visibility;
        public final long pop;
        public final Sys sys;
        public final String dt_txt;

        @JsonCreator
        public List(@JsonProperty("dt") long dt, @JsonProperty("main") Main main, @JsonProperty("weather") Weather[] weather, @JsonProperty("clouds") Clouds clouds, @JsonProperty("wind") Wind wind, @JsonProperty("visibility") long visibility, @JsonProperty("pop") long pop, @JsonProperty("sys") Sys sys, @JsonProperty("dt_txt") String dt_txt) {
            this.dt = dt;
            this.main = main;
            this.weather = weather;
            this.clouds = clouds;
            this.wind = wind;
            this.visibility = visibility;
            this.pop = pop;
            this.sys = sys;
            this.dt_txt = dt_txt;
        }

        public static final class Main {
            public final double temp;
            public final long feels_like;
            public final double temp_min;
            public final double temp_max;
            public final long pressure;
            public final long sea_level;
            public final long grnd_level;
            public final long humidity;
            public final long temp_kf;

            @JsonCreator
            public Main(@JsonProperty("temp") double temp, @JsonProperty("feels_like") long feels_like, @JsonProperty("temp_min") double temp_min, @JsonProperty("temp_max") double temp_max, @JsonProperty("pressure") long pressure, @JsonProperty("sea_level") long sea_level, @JsonProperty("grnd_level") long grnd_level, @JsonProperty("humidity") long humidity, @JsonProperty("temp_kf") long temp_kf) {
                this.temp = temp;
                this.feels_like = feels_like;
                this.temp_min = temp_min;
                this.temp_max = temp_max;
                this.pressure = pressure;
                this.sea_level = sea_level;
                this.grnd_level = grnd_level;
                this.humidity = humidity;
                this.temp_kf = temp_kf;
            }
        }

        public static final class Weather {
            public final long id;
            public final String main;
            public final String description;
            public final String icon;

            @JsonCreator
            public Weather(@JsonProperty("id") long id, @JsonProperty("main") String main, @JsonProperty("description") String description, @JsonProperty("icon") String icon) {
                this.id = id;
                this.main = main;
                this.description = description;
                this.icon = icon;
            }
        }

        public static final class Clouds {
            public final long all;

            @JsonCreator
            public Clouds(@JsonProperty("all") long all) {
                this.all = all;
            }
        }

        public static final class Wind {
            public final double speed;
            public final long deg;
            public final double gust;

            @JsonCreator
            public Wind(@JsonProperty("speed") double speed, @JsonProperty("deg") long deg, @JsonProperty("gust") double gust) {
                this.speed = speed;
                this.deg = deg;
                this.gust = gust;
            }
        }

        public static final class Sys {
            public final String pod;

            @JsonCreator
            public Sys(@JsonProperty("pod") String pod) {
                this.pod = pod;
            }
        }
    }

    public static final class City {
        public final long id;
        public final String name;
        public final Coord coord;
        public final String country;
        public final long population;
        public final long timezone;
        public final long sunrise;
        public final long sunset;

        @JsonCreator
        public City(@JsonProperty("id") long id, @JsonProperty("name") String name, @JsonProperty("coord") Coord coord, @JsonProperty("country") String country, @JsonProperty("population") long population, @JsonProperty("timezone") long timezone, @JsonProperty("sunrise") long sunrise, @JsonProperty("sunset") long sunset) {
            this.id = id;
            this.name = name;
            this.coord = coord;
            this.country = country;
            this.population = population;
            this.timezone = timezone;
            this.sunrise = sunrise;
            this.sunset = sunset;
        }

        public static final class Coord {
            public final double lat;
            public final double lon;

            @JsonCreator
            public Coord(@JsonProperty("lat") double lat, @JsonProperty("lon") double lon) {
                this.lat = lat;
                this.lon = lon;
            }
        }
    }
}
