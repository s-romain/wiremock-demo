package fr.sromain.wiremock.demo.config;

import fr.sromain.wiremock.demo.entities.Player;
import fr.sromain.wiremock.demo.repositories.PlayerRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static fr.sromain.wiremock.demo.enums.Location.LONDON;
import static fr.sromain.wiremock.demo.enums.Location.NANTES;

@Configuration
public class DatasourceConfiguration {
    @Autowired
    PlayerRepository playerRepository;

    @Bean
    InitializingBean sendDatabase() {
        return this::afterPropertiesSet;
    }

    private void afterPropertiesSet() {
        List<Player> players = new ArrayList<>() {{
            add(new Player("Shellie", "Lott", 8, NANTES));
            add(new Player("Veronica", "Pierce", 5, NANTES));
            add(new Player("Elvis", "Russell", 9, NANTES));
            add(new Player("Dana", "Trevino", 4, NANTES));
            add(new Player("Amery", "Gibbs", 2, LONDON));
            add(new Player("Jaden", "Guzman", 0, LONDON));
            add(new Player("Hop", "Dominguez", 9, NANTES));
            add(new Player("Rebecca", "Harrell", 5, NANTES));
            add(new Player("Hanae", "Dawson", 7, NANTES));
            add(new Player("Aristotle", "Bullock", 3, LONDON));
        }};
        playerRepository.saveAll(players);
    }
}
