package upc.edu.pe.api_mobile_backend.usermanagement.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.aggregates.Location;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByUserId(Long userId);


}
