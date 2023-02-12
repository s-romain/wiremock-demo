package fr.sromain.wiremock.demo.jcdecaux.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Station {
    private Integer number;
    private String contract_name;
    private String name;
    private String address;
    private Position position;
    private Boolean banking;
    private Boolean bonus;
    private Integer bike_stands;
    private Integer available_bike_stands;
    private Integer available_bikes;
    private String status;
    private Long last_update;
}
