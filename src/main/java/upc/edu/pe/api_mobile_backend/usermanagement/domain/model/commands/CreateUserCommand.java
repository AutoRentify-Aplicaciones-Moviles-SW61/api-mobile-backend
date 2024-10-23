package upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands;

import jakarta.persistence.Column;
import lombok.Getter;

public record CreateUserCommand( String name, String email, String phoneNumber, Long dni, Long driverLicense) {
}
