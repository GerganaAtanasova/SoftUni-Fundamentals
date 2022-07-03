package bg.softuni.battleships.controllers;

import bg.softuni.battleships.models.dto.CreateShipDto;
import bg.softuni.battleships.services.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ShipController {

    private ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @ModelAttribute("createShipDto")
    public CreateShipDto initShip(){
        return new CreateShipDto();
    }

    @GetMapping("/ships/add")
    public String ships(){
        return "ship-add";
    }

    @PostMapping("/ships/add")
    public String ships(@Valid CreateShipDto createShipDto,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors() || !this.shipService.create(createShipDto)){
            redirectAttributes.addFlashAttribute("createShipDto",createShipDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createShipDto", bindingResult);
            return "redirect:/ships/add";
        }

        return "redirect:/home";
    }
}
