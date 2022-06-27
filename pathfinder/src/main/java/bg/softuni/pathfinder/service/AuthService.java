package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.UserRegistrationDto;
import bg.softuni.pathfinder.model.entities.UserEntity;
import bg.softuni.pathfinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(UserRegistrationDto registrationDto){
        if (!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())){
            throw new RuntimeException("passwords.match");
        }

        Optional<UserEntity> byEmail =
                this.userRepository.findByEmail(registrationDto.getEmail());

        if (byEmail.isPresent()){
            throw new RuntimeException("email.used");
        }

        UserEntity user = new UserEntity(
                registrationDto.getUsername(),
                registrationDto.getPassword(),
                registrationDto.getEmail(),
                registrationDto.getFullname(),
                registrationDto.getAge()
        );
        this.userRepository.save(user);
    }
}
