package upc.edu.pe.api_mobile_backend.rentalmanagement.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.api_mobile_backend.rentalmanagement.domain.model.User;
import upc.edu.pe.api_mobile_backend.rentalmanagement.infrastructure.persistance.jpa.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
