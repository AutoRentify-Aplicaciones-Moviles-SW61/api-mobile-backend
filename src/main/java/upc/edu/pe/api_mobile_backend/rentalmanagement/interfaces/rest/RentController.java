package upc.edu.pe.api_mobile_backend.rentalmanagement.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.api_mobile_backend.rentalmanagement.domain.model.Rent;
import upc.edu.pe.api_mobile_backend.rentalmanagement.domain.services.RentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rents")
public class RentController {

    @Autowired
    private RentService rentService;

    @PostMapping
    public Rent createRent(@RequestBody Rent rent) {
        return rentService.createRent(rent);
    }

    @GetMapping
    public List<Rent> getAllRents() {
        return rentService.getAllRents();
    }

    @DeleteMapping("/{id}")
    public void deleteRent(@PathVariable Long id) {
        rentService.deleteRent(id);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<Rent> getRentsByVehicleId(@PathVariable Long vehicleId) {
        return rentService.getRentsByVehicleId(vehicleId);
    }
}
