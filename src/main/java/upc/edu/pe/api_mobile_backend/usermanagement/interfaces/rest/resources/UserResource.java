package upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.resources;

public record UserResource(Long id, String name, String email, String phoneNumber, Long dni, Long driverLicense) {
}
