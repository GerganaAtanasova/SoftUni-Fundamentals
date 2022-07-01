package bg.softuni.battleships.services;

import bg.softuni.battleships.models.UserEntity;
import bg.softuni.battleships.mapper.UserMapper;
import bg.softuni.battleships.models.dto.UserLoginDto;
import bg.softuni.battleships.models.dto.UserRegistrationDto;
import bg.softuni.battleships.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public AuthService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;

    }

    public boolean register(UserRegistrationDto registrationDto){
        if (!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())){
            return false;
        }

        Optional<UserEntity> byEmail = this.userRepository.findByEmail(registrationDto.getEmail());
        if (byEmail.isPresent()){
            return false;
        }

        Optional<UserEntity> byUsername = this.userRepository.findByUsername(registrationDto.getUsername());
        if (byUsername.isPresent()){
            return false;
        }

        UserEntity userEntity = userMapper.userRegisterDtoToUserEntity(registrationDto);
        this.userRepository.save(userEntity);
        return true;
    }

//    public boolean login(UserLoginDto userLoginDto) {
//
//    }
}
