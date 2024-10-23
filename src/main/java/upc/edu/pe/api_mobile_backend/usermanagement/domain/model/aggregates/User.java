package upc.edu.pe.api_mobile_backend.usermanagement.domain.model.aggregates;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import upc.edu.pe.api_mobile_backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands.CreateLocationCommand;
import upc.edu.pe.api_mobile_backend.usermanagement.domain.model.commands.CreateUserCommand;

@Getter
@Entity
public class User extends AuditableAbstractAggregateRoot<User> {

    @Column
    @Getter
    private String name;

    @Column
    @Getter
    private String email;

    @Column
    @Getter
    private String phoneNumber;

    @Column
    @Getter
    private Long dni;

    @Column
    @Getter
    private Long driverLicense;


    public User() {
    }

    public User(String name, String email, String phoneNumber, Long dni, Long driverLicense) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dni = dni;
        this.driverLicense = driverLicense;
    }

    public User(CreateUserCommand command) {
        this.name = command.name();
        this.email = command.email();
        this.phoneNumber = command.phoneNumber();
        this.dni = command.dni();
        this.driverLicense = command.driverLicense();
    }


}
