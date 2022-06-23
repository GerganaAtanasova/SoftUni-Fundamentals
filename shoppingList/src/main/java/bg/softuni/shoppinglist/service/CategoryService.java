package bg.softuni.shoppinglist.service;

import bg.softuni.shoppinglist.model.entity.CategoryEntity;
import bg.softuni.shoppinglist.model.entity.enums.CategoryName;
import bg.softuni.shoppinglist.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void initCategory() {
        if (categoryRepository.count() == 0) {
            CategoryName[] values = CategoryName.values();
            Arrays.stream(values).forEach(categoryName -> {
                CategoryEntity category = new CategoryEntity();
                category.setName(categoryName);
                category.setDescription("Description for category " + categoryName.name());
                this.categoryRepository.save(category);
            });
        }
    }
}
