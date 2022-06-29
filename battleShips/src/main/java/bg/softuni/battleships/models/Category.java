package bg.softuni.battleships.models;

import bg.softuni.battleships.models.enums.ShipType;
import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.ORDINAL)
    @Column(unique = true,nullable = false)
    private ShipType name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category(ShipType name){
        this.name = name;
    }

    public Category(){}

    public ShipType getName() {
        return name;
    }

    public void setName(ShipType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
