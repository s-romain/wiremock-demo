package fr.sromain.wiremock.demo.resources;

import fr.sromain.wiremock.demo.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LocationsControllerIT extends AbstractIntegrationTest {
    @Test
    public void testListLocations() throws Exception {
        /* GIVEN */
        var urlListLocations = "/locations";

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
}
