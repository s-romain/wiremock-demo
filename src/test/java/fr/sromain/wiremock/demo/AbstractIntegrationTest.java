package fr.sromain.wiremock.demo;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@AutoConfigureWireMock(port = 0)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class AbstractIntegrationTest {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    private WireMockServer wireMockServer;

    @BeforeEach
    public void setUp() {
        wireMockServer.resetAll();
    }
}
