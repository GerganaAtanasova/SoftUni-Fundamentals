
package bg.softuni.pathfinder.model.entities;

import bg.softuni.pathfinder.model.enums.Level;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes",uniqueConstraints = {@UniqueConstraint(columnNames = {"name","author_id"})})
public class Route extends BaseEntity{

    @Column(columnDefinition = "TEXT")
    private String description;

    @Lob
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private Level level;

    private String name;

    @ManyToOne
    private UserEntity author;

    @Column(name = "video_url")
    private String videoUrl;

    @OneToMany(targetEntity = Comment.class,
    mappedBy = "route",cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "route",fetch = FetchType.EAGER)
    private Set<Picture> pictures;

    @ManyToMany
    private Set<Category> categories;

    public Route(){
        this.comments = new HashSet<>();
        this.pictures = new HashSet<>();
        this.categories = new HashSet<>();
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}

