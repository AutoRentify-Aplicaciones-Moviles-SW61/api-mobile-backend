package upc.edu.pe.api_mobile_backend.usermanagement.domain.services;

import org.springframework.stereotype.Service;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.aggregates.User;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetAllUsersQuery;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetUserByEmailQuery;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;


@Service
public interface UserQueryService {

    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);

    Optional<User> handle(GetUserByEmailQuery query);

}
