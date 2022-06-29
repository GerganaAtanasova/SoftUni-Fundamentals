package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.dto.BrandDto;
import bg.softuni.mobilele.model.entity.BrandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    public BrandDto brandEntityToBrandDto(BrandEntity brand);
}
