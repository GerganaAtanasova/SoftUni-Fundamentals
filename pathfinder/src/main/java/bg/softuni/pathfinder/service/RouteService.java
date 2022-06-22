<<<<<<< HEAD
package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.entities.Route;
import bg.softuni.pathfinder.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {


    private RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<Route> getMostCommented() {
        return routeRepository.findMostCommented();
    }
}
=======
package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.entities.Route;
import bg.softuni.pathfinder.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {


    private RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<Route> getMostCommented() {
        return routeRepository.findMostCommented();
    }
}
>>>>>>> 81eedb3f94b2d167f45183164e688554829dce24
