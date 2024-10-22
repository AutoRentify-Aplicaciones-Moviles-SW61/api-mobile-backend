package upc.edu.pe.api_mobile_backend.rentalmanagement.domain.model;

import jakarta.persistence.*;

@Entity
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long vehicleId; // ID del vehículo asociado
    private Long userId;    // ID del usuario que alquila
    private String startDate;
    private String endDate;

    // Getters and Setters
}
