package upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.transform;

import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.aggregates.User;
import upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        return new UserResource(entity.getId(), entity.getName(), entity.getEmail(), entity.getPhoneNumber(), entity.getDni(), entity.getDriverLicense());
    }
}
//Long id, String name, String email, String phoneNumber, Long dni, Long driverLicense