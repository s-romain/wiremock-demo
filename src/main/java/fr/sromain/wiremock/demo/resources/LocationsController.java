package fr.sromain.wiremock.demo.resources;

import fr.sromain.wiremock.demo.dto.LocationDto;
import fr.sromain.wiremock.demo.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
@CrossOrigin(origins = "http://localhost:4200")
public class LocationsController {
    @Autowired
    LocationService locationService;

    @GetMapping
    public List<LocationDto> getLocations() {
        return locationService.findAll();
    }

    @GetMapping("/{name}")
    public LocationDto getLocationByName(@PathVariable("name") String name) {
        return locationService.findByName(name);
    }
}
