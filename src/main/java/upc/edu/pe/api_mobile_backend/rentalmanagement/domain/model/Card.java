package upc.edu.pe.api_mobile_backend.rentalmanagement.domain.model;

import jakarta.persistence.*;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId; // ID del usuario asociado
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;

    // Getters and Setters
}
