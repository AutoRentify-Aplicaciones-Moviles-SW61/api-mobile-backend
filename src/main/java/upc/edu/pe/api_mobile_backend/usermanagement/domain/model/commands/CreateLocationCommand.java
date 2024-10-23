package upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands;

import jakarta.persistence.Column;
import lombok.Getter;

import java.text.DecimalFormat;

public record CreateLocationCommand(Long userid, String address, String city, String country, String locationStatus, DecimalFormat latitude, DecimalFormat longitude) {
}
