package upc.edu.pe.api_mobile_backend.usermanagement.domain.services;

import org.springframework.stereotype.Service;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.aggregates.User;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands.CreateUserCommand;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands.DeleteUserCommand;

import java.util.Optional;

@Service
public interface UserCommandService {
    Optional<User> handle(CreateUserCommand command);
    void handle(DeleteUserCommand command);
}
