package upc.edu.pe.api_mobile_backend.usermanagement.application.internal.queryservices;

import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.aggregates.User;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetAllUsersQuery;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetUserByEmailQuery;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetUserByIdQuery;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.services.UserQueryService;
import upc.edu.pe.api_mobile_backend.usermanagement.infrastructure.persistence.jpa.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.userId());
    }

    @Override
    public Optional<User> handle(GetUserByEmailQuery query) {
        return userRepository.findByEmail(query.email()).stream().findFirst();
    }

}
