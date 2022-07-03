package bg.softuni.battleships.services;

import bg.softuni.battleships.models.User;
import bg.softuni.battleships.mapper.UserMapper;
import bg.softuni.battleships.models.dto.UserLoginDto;
import bg.softuni.battleships.models.dto.UserRegistrationDto;
import bg.softuni.battleships.repositories.UserRepository;
import bg.softuni.battleships.session.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private LoggedUser userSession;

    @Autowired
    public AuthService(UserRepository userRepository, UserMapper userMapper, LoggedUser userSession) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userSession = userSession;
    }

    public boolean register(UserRegistrationDto registrationDto){
        if (!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())){
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(registrationDto.getEmail());
        if (byEmail.isPresent()){
            return false;
        }

        Optional<User> byUsername = this.userRepository.findByUsername(registrationDto.getUsername());
        if (byUsername.isPresent()){
            return false;
        }

        User user = userMapper.userRegisterDtoToUserEntity(registrationDto);
        this.userRepository.save(user);
        return true;
    }

    public boolean login(UserLoginDto userLoginDto) {
        Optional<User> user = this.userRepository.findByUsernameAndPassword(userLoginDto.getUsername(), userLoginDto.getPassword());
        if (user.isEmpty()){
            return false;
        }

        this.userSession.login(user.get());

        return true;
    }

//    public boolean login(UserLoginDto userLoginDto) {
//
//    }
}
