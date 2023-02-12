package fr.sromain.wiremock.demo.services;

import fr.sromain.wiremock.demo.dto.LocationDto;
import fr.sromain.wiremock.demo.enums.Location;
import fr.sromain.wiremock.demo.openweathermap.services.OpenWeatherMapService;
import fr.sromain.wiremock.demo.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LocationService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    OpenWeatherMapService openWeatherService;

    public List<LocationDto> findAll() {
        List<LocationDto> locations = new ArrayList<>();
        Arrays.stream(Location.values()).forEach(location ->
                locations.add(LocationDto
                        .builder()
                        .location(location)
                        .players(playerRepository.findByLocation(location))
                        .weather(openWeatherService.getCurrentWeatherByLocation(location))
                        .build()));
        return locations;
    }
}
