package fr.sromain.wiremock.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.sromain.wiremock.demo.entities.Player;
import fr.sromain.wiremock.demo.enums.Location;
import fr.sromain.wiremock.demo.jcdecaux.entities.Station;
import fr.sromain.wiremock.demo.openweathermap.entities.CurrentWeather;
import lombok.Builder;

import java.util.List;

@Builder
public class LocationDto {
    @JsonSerialize
    String name;
    @JsonSerialize
    String city;
    @JsonSerialize
    String country;
    @JsonSerialize
    String state;
    @JsonSerialize
    Double lat;
    @JsonSerialize
    Double lon;
    @JsonSerialize
    String jcDecauxContractName;
    @JsonSerialize
    String description;
    @JsonSerialize
    String urlImg;
    @JsonSerialize
    CurrentWeather weather;
    @JsonSerialize
    List<Station> stations;
    @JsonSerialize
    List<Player> players;
}
