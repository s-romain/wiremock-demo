package fr.sromain.wiremock.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.sromain.wiremock.demo.entities.Player;
import fr.sromain.wiremock.demo.enums.Location;
import fr.sromain.wiremock.demo.openweathermap.entities.CurrentWeather;
import lombok.Builder;

import java.util.List;

@Builder
public class LocationDto {
    @JsonSerialize
    Location location;
    @JsonSerialize
    CurrentWeather weather;
    @JsonSerialize
    List<Player> players;
}
