package upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetAllLocationsQuery;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetLocationByIdQuery;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.services.LocationCommandService;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.services.LocationQueryService;
import upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.resources.CreateLocationResource;
import upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.resources.LocationResource;
import upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.transform.CreateLocationCommandFromResourceAssembler;
import upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.transform.LocationResourceFromEntityAssembler;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/v1/locations", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Location")

public class LocationController {

    private final LocationQueryService locationQueryService;
    private final LocationCommandService locationCommandService;


    public LocationController(LocationQueryService locationQueryService, LocationCommandService locationCommandService) {
        this.locationQueryService = locationQueryService;
        this.locationCommandService = locationCommandService;
    }
    @GetMapping
    public ResponseEntity<List<LocationResource>> getAllLocations() {
        var getAllLocationsQuery = new GetAllLocationsQuery();
        var locations = locationQueryService.handle(getAllLocationsQuery);
        var locationsResources = locations.stream()
                .map(LocationResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(locationsResources);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<LocationResource> getLocationById(@PathVariable Long locationId) {
        var getLocationByIdQuery = new GetLocationByIdQuery(locationId);
        var location = locationQueryService.handle(getLocationByIdQuery);
        if (location.isEmpty()) return ResponseEntity.notFound().build();
        var locationResource = LocationResourceFromEntityAssembler.toResourceFromEntity(location.get());
        return ResponseEntity.ok(locationResource);
    }

    @PostMapping
    public ResponseEntity<LocationResource> createLocation(@RequestBody CreateLocationResource resource) {
        var createLocationCommand = CreateLocationCommandFromResourceAssembler.toCommandFromResource(resource);
        var location = locationCommandService.handle(createLocationCommand);
        if (location.isEmpty()) return ResponseEntity.badRequest().build();
        var locationResource = LocationResourceFromEntityAssembler.toResourceFromEntity(location.get());
        return ResponseEntity.ok(locationResource);
    }



}
