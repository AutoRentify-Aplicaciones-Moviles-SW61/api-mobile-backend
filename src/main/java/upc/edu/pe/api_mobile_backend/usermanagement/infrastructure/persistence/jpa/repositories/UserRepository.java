package upc.edu.pe.api_mobile_backend.usermanagement.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.aggregates.User;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.queries.GetUserByIdQuery;

import java.util.List;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);
    List<User> findByUserId(GetUserByIdQuery id);


}
