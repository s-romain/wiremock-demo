package fr.sromain.wiremock.demo.openweathermap.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentWeather {
    Coord coord;
    List<Weather> weather;
}
