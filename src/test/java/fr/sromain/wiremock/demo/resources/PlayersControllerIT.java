package fr.sromain.wiremock.demo.resources;

import fr.sromain.wiremock.demo.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PlayersControllerIT extends AbstractIntegrationTest {
    @Test
    public void testListPlayers() throws Exception {
        /* GIVEN */
        var urlListPlayers = "/players";

        /* WHEN */
        var r = this.mockMvc.perform(get(urlListPlayers));

        /* THEN */
        // HTTP return code = 200
        r.andExpect(status().isOk());
        // Result is a list
        r.andExpect(jsonPath("$").isArray());
        // Result contains 10 records
        r.andExpect(jsonPath("$.*", hasSize(10)));

        // Debug : log mockMvc request
        r.andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testGetPlayerOne() throws Exception {
        /* GIVEN */
        var urlPlayerOne = "/players/1";

        /* WHEN */
        this.mockMvc.perform(get(urlPlayerOne))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Shellie"))
                .andExpect(jsonPath("$.lastName").value("Lott"))
                .andExpect(jsonPath("$.score").value(8))
                .andDo(MockMvcResultHandlers.print());
    }
}
