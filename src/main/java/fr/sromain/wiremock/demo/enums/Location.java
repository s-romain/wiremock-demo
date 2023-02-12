package fr.sromain.wiremock.demo.enums;

import lombok.Getter;

@Getter
public enum Location {
    NANTES("Nantes", "FR", "Pays de la Loire", 47.2186371, -1.5541362),
    LONDON("London", "GB", "England", 51.5073219, -0.1276474);

    final String city;
    final String country;
    final String state;
    final Double lat;
    final Double lon;

    Location(
            String city,
            String country,
            String state,
            Double lat,
            Double lon
    ) {

        this.city = city;
        this.country = country;
        this.state = state;
        this.lat = lat;
        this.lon = lon;
    }
}
