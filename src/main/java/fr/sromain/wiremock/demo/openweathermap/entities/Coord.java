package fr.sromain.wiremock.demo.openweathermap.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coord {
    Double lon;
    Double lat;
}
