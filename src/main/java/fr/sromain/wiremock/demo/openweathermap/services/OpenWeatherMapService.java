package fr.sromain.wiremock.demo.openweathermap.services;

import fr.sromain.wiremock.demo.enums.Location;
import fr.sromain.wiremock.demo.openweathermap.entities.CurrentWeather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
public class OpenWeatherMapService {
    public static final String PATH = "/data/2.5/weather";
    @Value("${api.openweathermap.url}")
    String openWeatherMapUrl;
    @Value("${api.openweathermap.apiKey}")
    String openWeatherMapApiKey;

    public CurrentWeather getCurrentWeatherByLocation(Location location) {
        return WebClient.builder()
                .baseUrl(openWeatherMapUrl)
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path(PATH)
                        .queryParam("lat", location.getLat())
                        .queryParam("lon", location.getLon())
                        .queryParam("apiKey", openWeatherMapApiKey)
                        .build())
                .accept(APPLICATION_JSON)
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(CurrentWeather.class)
                .block();
    }
}
