package bg.softuni.battleships.mapper;

import bg.softuni.battleships.models.UserEntity;
import bg.softuni.battleships.models.dto.UserRegistrationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity userRegisterDtoToUserEntity(UserRegistrationDto userRegisterDto);
}
