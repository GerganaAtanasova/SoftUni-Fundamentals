<<<<<<< HEAD
package bg.softuni.pathfinder.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{

    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String url;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private Route route;

    public Picture(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
=======
package bg.softuni.pathfinder.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{

    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String url;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private Route route;

    public Picture(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
>>>>>>> 81eedb3f94b2d167f45183164e688554829dce24
