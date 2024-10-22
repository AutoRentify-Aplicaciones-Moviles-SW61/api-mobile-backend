package upc.edu.pe.api_mobile_backend.rentalmanagement.infrastructure.persistance.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.api_mobile_backend.rentalmanagement.domain.model.Rent;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findByVehicleId(Long vehicleId);
}