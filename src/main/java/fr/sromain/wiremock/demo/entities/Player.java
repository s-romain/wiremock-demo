package fr.sromain.wiremock.demo.entities;


import fr.sromain.wiremock.demo.enums.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer score;
    private Location location;

    public Player(String firstName, String lastName, Integer score, Location location) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
        this.location = location;
    }
}
