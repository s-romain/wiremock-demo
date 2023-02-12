package fr.sromain.wiremock.demo.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import fr.sromain.wiremock.demo.AbstractIntegrationTest;
import fr.sromain.wiremock.demo.enums.Location;
import fr.sromain.wiremock.demo.openweathermap.entities.Coord;
import fr.sromain.wiremock.demo.openweathermap.entities.CurrentWeather;
import fr.sromain.wiremock.demo.openweathermap.entities.Weather;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.givenThat;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static fr.sromain.wiremock.demo.enums.Location.LONDON;
import static fr.sromain.wiremock.demo.enums.Location.NANTES;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LocationsControllerIT extends AbstractIntegrationTest {

    @Autowired
    ObjectMapper objectMapper;

    @Value("${api.openweathermap.apiKey}")
    String apiKey;

    @Test
    public void testListLocations() throws Exception {
        /* GIVEN */
        var urlListLocations = "/locations";

        // Mock call API WeatherMap for Nantes
        mockOpenWeatherMapApiForLocation(NANTES, 1L, "Clear", "clear sky");

        // Mock call API WeatherMap for London
        mockOpenWeatherMapApiForLocation(LONDON, 2L, "Clouds", "overcast clouds");

        /* WHEN */
        this.mockMvc.perform(get(urlListLocations))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$.[0].location").value("NANTES"))
                .andExpect(jsonPath("$.[0].weather.weather.*", hasSize(1)))
                .andExpect(jsonPath("$.[0].weather.weather.[0].main").value("Clear"))
                .andExpect(jsonPath("$.[0].weather.weather[0].description").value("clear sky"))
                .andExpect(jsonPath("$.[0].players.*", hasSize(7)))
                .andExpect(jsonPath("$.[1].location").value("LONDON"))
                .andExpect(jsonPath("$.[1].players.*", hasSize(3)))
                .andExpect(jsonPath("$.[1].weather.weather.*", hasSize(1)))
                .andExpect(jsonPath("$.[1].weather.weather[0].main").value("Clouds"))
                .andExpect(jsonPath("$.[1].weather.weather[0].description").value("overcast clouds"))
                .andDo(MockMvcResultHandlers.print());
    }

    private void mockOpenWeatherMapApiForLocation(Location location, long id, String main, String description) throws JsonProcessingException {
        givenThat(WireMock.get(urlPathEqualTo("/data/2.5/weather"))
                .withQueryParam("lat", equalTo(location.getLat().toString()))
                .withQueryParam("lon", equalTo(location.getLon().toString()))
                .withQueryParam("apiKey", equalTo(apiKey))
                .willReturn(
                        aResponse().withStatus(200)
                                .withHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                                .withBody(objectMapper.writeValueAsString(
                                        getMockedCurrentWeather(location, id, main, description)))));
    }

    private static CurrentWeather getMockedCurrentWeather(Location location, Long id, String main, String description) {
        return CurrentWeather.builder()
                .coord(
                        Coord.builder()
                                .lat(location.getLat())
                                .lon(location.getLon())
                                .build())
                .weather(
                        List.of(
                                Weather.builder()
                                        .id(id)
                                        .main(main)
                                        .description(description)
                                        .build()))
                .build();
    }
}
