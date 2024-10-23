package upc.edu.pe.api_mobile_backend.usermanagement.application.internal.queryservices;

import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.aggregates.Location;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetAllLocationsQuery;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetLocationByIdQuery;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetLocationByUserIdQuery;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.services.LocationQueryService;
import upc.edu.pe.api_mobile_backend.usermanagement.infrastructure.persistence.jpa.repositories.LocationRepository;

import java.util.List;
import java.util.Optional;

public class LocationQueryServiceImpl implements LocationQueryService {

    private final LocationRepository locationRepository;


    public LocationQueryServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findByUserId(Long userId) {
        return locationRepository.findByUserId(userId);
    }

    @Override
    public List<Location> handle(GetAllLocationsQuery query) {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> handle(GetLocationByIdQuery query) {
        return locationRepository.findById(query.locationId());
    }

    @Override
    public List<Location> handle(GetLocationByUserIdQuery query) {
        return locationRepository.findByUserId(query.userId());
    }
}