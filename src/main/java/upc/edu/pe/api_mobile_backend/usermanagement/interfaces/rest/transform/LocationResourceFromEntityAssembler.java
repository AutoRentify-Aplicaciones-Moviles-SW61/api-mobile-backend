package upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.transform;

import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.aggregates.Location;
import upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.resources.LocationResource;

public class LocationResourceFromEntityAssembler {
    public static LocationResource toResourceFromEntity(Location entity) {
        return new LocationResource(entity.getId(), entity.getUserid(), entity.getAddress(), entity.getCity(), entity.getCountry(), entity.getLocationStatus(), entity.getLatitude(), entity.getLongitude());
    }
}
