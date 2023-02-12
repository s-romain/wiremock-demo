package fr.sromain.wiremock.demo.jcdecaux.services;

import fr.sromain.wiremock.demo.enums.Location;
import fr.sromain.wiremock.demo.jcdecaux.entities.Station;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
public class JcDecauxService {
    public static final String PATH = "/stations";
    @Value("${api.jcdecaux.url}")
    String jcDecauxUrl;
    @Value("${api.jcdecaux.apiKey}")
    String jcDecauxApiKey;

    public List<Station> getBikeStationsByLocation(Location location) {
        return location.getJcDecauxContractName() == null ? new ArrayList<>() :
                WebClient.builder()
                        .baseUrl(jcDecauxUrl)
                        .build()
                        .get()
                        .uri(uriBuilder -> uriBuilder.path(PATH)
                                .queryParam("contract", location.getJcDecauxContractName())
                                .queryParam("apiKey", jcDecauxApiKey)
                                .build())
                        .accept(APPLICATION_JSON)
                        .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                        .retrieve()
                        .bodyToFlux(Station.class).toStream().collect(Collectors.toList());
    }
}
