package upc.edu.pe.api_mobile_backend.usermanagement.domain.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import upc.edu.pe.api_mobile_backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands.CreateLocationCommand;

import java.text.DecimalFormat;


@Getter
@Entity
public class Location extends AuditableAbstractAggregateRoot<Location> {

    @Column
    @Getter
    private Long userid;


    @Column
    @Getter
    private String address;

    @Column
    @Getter
    private String city;

    @Column
    @Getter
    private String country;

    @Column
    @Getter
    private String locationStatus;

    @Column
    @Getter
    private DecimalFormat latitude;

    @Column
    @Getter
    private DecimalFormat longitude;



    public Location() {
    }

    public Location(Long userid,String address, String city, String country, String locationStatus, DecimalFormat latitude, DecimalFormat longitude) {
        this.userid = userid;
        this.address = address;
        this.city = city;
        this.country = country;
        this.locationStatus = locationStatus;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(CreateLocationCommand command) {
        this.userid = command.userid();
        this.address = command.address();
        this.city = command.city();
        this.country = command.country();
        this.locationStatus = command.locationStatus();
        this.latitude = command.latitude();
        this.longitude = command.longitude();
    }
}

