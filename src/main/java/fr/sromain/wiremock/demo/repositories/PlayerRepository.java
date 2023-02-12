package fr.sromain.wiremock.demo.repositories;

import fr.sromain.wiremock.demo.entities.Player;
import fr.sromain.wiremock.demo.enums.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findAll();
    Player findById(long id);
    List<Player> findByLocation(Location location);
}
