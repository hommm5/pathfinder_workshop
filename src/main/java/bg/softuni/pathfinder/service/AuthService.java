package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.UserRegistrationDTO;
import bg.softuni.pathfinder.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(UserRegistrationDTO userRegistrationDTO){
        if (!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())){
            throw new RuntimeException("passwords.match");
        }

        Optional<User> userByEmail = this.userRepository.findByEmail(userRegistrationDTO.getEmail());

        if (userByEmail.isPresent()){
            throw new RuntimeException("email.used");
        }
    }
}
