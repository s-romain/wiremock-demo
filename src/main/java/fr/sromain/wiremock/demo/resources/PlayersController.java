package fr.sromain.wiremock.demo.resources;

import fr.sromain.wiremock.demo.entities.Player;
import fr.sromain.wiremock.demo.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayersController {
    @Autowired
    PlayerRepository playerRepository;

    @GetMapping
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable("id") long id) {
        return Optional.ofNullable(playerRepository.findById(id)).
                orElseThrow(NullPointerException::new);
    }
}
