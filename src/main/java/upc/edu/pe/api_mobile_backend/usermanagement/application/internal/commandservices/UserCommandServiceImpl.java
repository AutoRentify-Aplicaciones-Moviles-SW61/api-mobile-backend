package upc.edu.pe.api_mobile_backend.usermanagement.application.internal.commandservices;

import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.aggregates.User;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands.CreateUserCommand;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands.DeleteUserCommand;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.services.UserCommandService;
import upc.edu.pe.api_mobile_backend.usermanagement.infrastructure.persistence.jpa.repositories.UserRepository;

import java.util.Optional;

public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(CreateUserCommand command) {
        var user = new User(command);
        userRepository.save(user);
        return Optional.of(user);
    }

    @Override
    public void handle(DeleteUserCommand command) {

        if (!userRepository.existsById(command.userId())) {
            throw new IllegalArgumentException("User does not exist");
        }
        try {
            userRepository.deleteById(command.userId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting User: " + e.getMessage());
        }
    }
}
