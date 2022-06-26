package bg.softuni.pathfinder.model.entities;

import bg.softuni.pathfinder.model.enums.UserRoles;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private UserRoles role;

    public Role(){}

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }
}

