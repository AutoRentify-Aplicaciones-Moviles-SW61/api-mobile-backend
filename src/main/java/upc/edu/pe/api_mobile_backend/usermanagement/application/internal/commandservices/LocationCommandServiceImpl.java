package upc.edu.pe.api_mobile_backend.usermanagement.application.internal.commandservices;

import org.springframework.stereotype.Service;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.aggregates.Location;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands.CreateLocationCommand;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands.DeleteLocationCommand;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.services.LocationCommandService;
import upc.edu.pe.api_mobile_backend.usermanagement.infrastructure.persistence.jpa.repositories.LocationRepository;

import java.util.Optional;

@Service
public class LocationCommandServiceImpl implements LocationCommandService {

    private final LocationRepository locationRepository;

    public LocationCommandServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Optional<Location> handle(CreateLocationCommand command) {
        var location = new Location(command);
        locationRepository.save(location);
        return Optional.of(location);
    }

    @Override
    public void handle(DeleteLocationCommand command) {
        if (!locationRepository.existsById(command.locationId())) {
            throw new IllegalArgumentException("Location does not exist");
        }
    }
}
