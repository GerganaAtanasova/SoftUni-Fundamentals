package bg.softuni.shoppinglist.init;

import bg.softuni.shoppinglist.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInitializer implements CommandLineRunner {

    private final CategoryService categoryService;

    @Autowired
    public DataBaseInitializer(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.initCategory();
    }
}
