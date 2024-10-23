package upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.transform;

import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands.CreateLocationCommand;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands.CreateUserCommand;
import upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.resources.CreateLocationResource;
import upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.resources.CreateUserResource;

public class CreateLocationCommandFromResourceAssembler {
    public static CreateLocationCommand toCommandFromResource(CreateLocationResource resource) {
        return new CreateLocationCommand( resource.userid(), resource.address(), resource.city(), resource.country(), resource.locationStatus(), resource.latitude(), resource.longitude());
    }
}
