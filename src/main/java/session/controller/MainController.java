package session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import session.model.Apartments;
import session.model.UserProfile;
import session.service.HouseServiceImpl;
import session.service.UserServiceImpl;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private HouseServiceImpl houseService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public String homePage(Model model) {
        List<Apartments> listHouse = houseService.featuredHouses();

        model.addAttribute("listHouse", listHouse);
        return "home";
    }


    @GetMapping("/view-user/{firstName}/{idProfile}")
    public String viewUser(@PathVariable("idProfile") int idProfile, Model model) {
        UserProfile profile = userService.getProfile(idProfile);
        List<Apartments> listHouse = houseService.listHouses();

        listHouse.removeIf(car -> car.getUser().getProfile().getIdProfile() != idProfile);
        listHouse.removeIf(car -> car.getStatus().equals("DEACTIVE"));

        model.addAttribute("listHouse", listHouse);

        model.addAttribute("profile", profile);

        return "view-user";
    }
}