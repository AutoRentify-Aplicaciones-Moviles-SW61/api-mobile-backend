package upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.transform;

import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands.CreateUserCommand;
import upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(resource.name(), resource.email(), resource.phoneNumber(), resource.dni(), resource.driverLicense());
    }
}
