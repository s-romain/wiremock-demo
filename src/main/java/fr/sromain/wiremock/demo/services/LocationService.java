package fr.sromain.wiremock.demo.services;

import fr.sromain.wiremock.demo.dto.LocationDto;
import fr.sromain.wiremock.demo.enums.Location;
import fr.sromain.wiremock.demo.jcdecaux.services.JcDecauxService;
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

    @Autowired
    JcDecauxService jcDecauxService;

    public List<LocationDto> findAll() {
        List<LocationDto> locations = new ArrayList<>();
        Arrays.stream(Location.values()).forEach(location ->
                locations.add(getLocationDto(location)));
        return locations;
    }

    public LocationDto findByName(String name) {
        Location location = Location.findByName(name);
        return getLocationDto(location);
    }

    private LocationDto getLocationDto(Location location) {
        return LocationDto
                .builder()
                .name(location.name())
                .city(location.getCity())
                .lat(location.getLat())
                .lon(location.getLon())
                .state(location.getState())
                .country(location.getCountry())
                .jcDecauxContractName(location.getJcDecauxContractName())
                .description(location.getDescription())
                .urlImg(location.getUrlImg())
                .players(playerRepository.findByLocation(location))
                .weather(openWeatherService.getCurrentWeatherByLocation(location))
                .stations(jcDecauxService.getBikeStationsByLocation(location))
                .build();
    }
}
