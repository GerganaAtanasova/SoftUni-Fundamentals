<<<<<<< HEAD
package bg.softuni.pathfinder.model.entities;

import bg.softuni.pathfinder.model.enums.RouteCategory;
import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private RouteCategory name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category(){}

    public RouteCategory getName() {
        return name;
    }

    public void setName(RouteCategory name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
=======
package bg.softuni.pathfinder.model.entities;

import bg.softuni.pathfinder.model.enums.RouteCategory;
import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private RouteCategory name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category(){}

    public RouteCategory getName() {
        return name;
    }

    public void setName(RouteCategory name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
>>>>>>> 81eedb3f94b2d167f45183164e688554829dce24
