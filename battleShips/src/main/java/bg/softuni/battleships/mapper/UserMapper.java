package bg.softuni.battleships.mapper;

import bg.softuni.battleships.models.User;
import bg.softuni.battleships.models.dto.UserRegistrationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userRegisterDtoToUserEntity(UserRegistrationDto userRegisterDto);
}
