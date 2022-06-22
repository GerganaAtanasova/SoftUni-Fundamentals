<<<<<<< HEAD
package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query("SELECT r FROM Route r ORDER BY size(r.comments) DESC")
    List<Route> findMostCommented();
}
=======
package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query("SELECT r FROM Route r ORDER BY size(r.comments) DESC")
    List<Route> findMostCommented();
}
>>>>>>> 81eedb3f94b2d167f45183164e688554829dce24
