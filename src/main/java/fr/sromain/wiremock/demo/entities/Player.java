package fr.sromain.wiremock.demo.entitites;


import fr.sromain.wiremock.demo.enums.Location;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String firstName;
    String lastName;
    Integer score;
    Location location;

    public Player(String firstName, String lastName, Integer score, Location location) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
        this.location = location;
    }
}
