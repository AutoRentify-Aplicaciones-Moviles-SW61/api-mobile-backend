package upc.edu.pe.api_mobile_backend.usermanagement.domain.services;

import org.springframework.stereotype.Service;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.aggregates.Location;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetAllLocationsQuery;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetLocationByIdQuery;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetLocationByUserIdQuery;

import java.util.List;
import java.util.Optional;
@Service
public interface LocationQueryService {

    List<Location> findByUserId(Long userId);

    List<Location> handle(GetAllLocationsQuery query);
    Optional<Location> handle(GetLocationByIdQuery query);
    List<Location> handle(GetLocationByUserIdQuery query);
}
