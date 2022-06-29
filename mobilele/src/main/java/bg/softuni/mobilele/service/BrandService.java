package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.BrandDto;
import bg.softuni.mobilele.model.dto.ModelDto;
import bg.softuni.mobilele.model.entity.BrandEntity;
import bg.softuni.mobilele.model.entity.ModelEntity;
import bg.softuni.mobilele.model.mapper.BrandMapper;
import bg.softuni.mobilele.model.mapper.ModelMapper;
import bg.softuni.mobilele.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private BrandRepository brandRepository;
    private BrandMapper brandMapper;
    private ModelMapper modelMapper;

    @Autowired
    public BrandService(BrandRepository brandRepository, BrandMapper brandMapper, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
        this.modelMapper = modelMapper;
    }

    public List<BrandDto> getAllBrands() {

        return brandRepository.findAll()
                .stream()
                .map(this::mapBrand)
                .collect(Collectors.toList());
    }

    public BrandDto mapBrand(BrandEntity brandEntity) {
        List<ModelDto> models = brandEntity
                .getModels()
                .stream()
                .map(this.modelMapper::mapModel)
                .toList();

        BrandDto brandDto = this.brandMapper.brandEntityToBrandDto(brandEntity);
        brandDto.setModels(models);
        return brandDto;
    }

}
