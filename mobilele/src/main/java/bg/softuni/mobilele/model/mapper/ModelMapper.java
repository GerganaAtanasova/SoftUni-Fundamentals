package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.dto.ModelDto;
import bg.softuni.mobilele.model.entity.ModelEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelMapper {

    public ModelDto mapModel(ModelEntity model);
}
