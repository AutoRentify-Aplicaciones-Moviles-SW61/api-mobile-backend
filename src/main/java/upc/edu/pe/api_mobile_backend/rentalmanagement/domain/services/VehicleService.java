package upc.edu.pe.api_mobile_backend.rentalmanagement.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.api_mobile_backend.rentalmanagement.domain.model.Vehicle;
import upc.edu.pe.api_mobile_backend.rentalmanagement.infrastructure.persistance.jpa.repositories.VehicleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public Optional<Vehicle> findById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId);
    }

    public List<Vehicle> findAvailableVehicles() {
        return vehicleRepository.findByAvailable(true);
    }

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteById(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }
}
