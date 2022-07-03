package bg.softuni.battleships.services;

import bg.softuni.battleships.models.Category;
import bg.softuni.battleships.models.Ship;
import bg.softuni.battleships.models.User;
import bg.softuni.battleships.models.dto.CreateShipDto;
import bg.softuni.battleships.models.enums.ShipType;
import bg.softuni.battleships.repositories.CategoryRepository;
import bg.softuni.battleships.repositories.ShipRepository;
import bg.softuni.battleships.repositories.UserRepository;
import bg.softuni.battleships.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipService {

    private ShipRepository shipRepository;
    private CategoryRepository categoryRepository;
    private LoggedUser loggedUser;
    private UserRepository userRepository;

    public ShipService(ShipRepository shipRepository, CategoryRepository categoryRepository,
                       LoggedUser loggedUser, UserRepository userRepository) {
        this.shipRepository = shipRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    public boolean create(CreateShipDto createShipDto) {

        Optional<Ship> byName =
                this.shipRepository.findByName(createShipDto.getName());

        if (byName.isPresent()) {
            return false;
        }

        ShipType type = switch (createShipDto.getCategory()) {
            case 0 -> ShipType.BATTLE;
            case 1 -> ShipType.CARGO;
            case 2 -> ShipType.PATROL;
            default -> ShipType.BATTLE;
        };

        Category category = this.categoryRepository.findByName(type);
        Optional<User> owner = this.userRepository.findById(this.loggedUser.getId());

        Ship ship = new Ship();
        ship.setName(createShipDto.getName());
        ship.setPower(createShipDto.getPower());
        ship.setHealth(createShipDto.getHealth());
        ship.setCreated(createShipDto.getCreated());
        ship.setCategory(category);
        ship.setUser(owner.get());

        this.shipRepository.save(ship);

        return true;
    }
}
