package bg.softuni.shoppinglist.model.entity;

import bg.softuni.shoppinglist.model.entity.enums.CategoryName;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private CategoryName name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public CategoryEntity() {
    }

    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
