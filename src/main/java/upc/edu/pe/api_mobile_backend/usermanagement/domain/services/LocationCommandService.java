package upc.edu.pe.api_mobile_backend.usermanagement.domain.services;

import org.springframework.stereotype.Service;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.aggregates.Location;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands.CreateLocationCommand;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands.DeleteLocationCommand;

import java.util.Optional;
@Service
public interface LocationCommandService {
    Optional<Location> handle(CreateLocationCommand command);
    void handle(DeleteLocationCommand command);
}
