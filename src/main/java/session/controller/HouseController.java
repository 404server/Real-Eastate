package session.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import session.model.Apartments;
import session.service.HouseServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/houses")
public class HouseController {

    @Autowired
    private HouseServiceImpl houseService;


    @GetMapping("")
    public String housePage(Model model) {
        List<Apartments> list = houseService.listHouses();
        model.addAttribute("listHouse", list);
        return "houses";
    }

    @GetMapping("/{type}/{info}/{year}/{id_house}")
    public String houseDetails(@PathVariable("id_house") int id, Model model) {
        Apartments house = houseService.getHouseById(id);
        model.addAttribute("house", house);

        return "house-details";
    }


    @GetMapping(value = "", params = "keyword")
    public String searchHouse(@RequestParam("keyword") String keyword, Model model) {

        List<Apartments> search = houseService.searchApartments(keyword);

        model.addAttribute("listHouse", search);
        return "houses";
    }

    @GetMapping(value = "", params = {"low", "high"})
    public String searchHouseByPriceRange(@RequestParam("low") int low, @RequestParam("high") int high, Model model) {
        List<Apartments> searchHouse = houseService.searchHouseByPriceRange(low, high);

        model.addAttribute("listHouse", searchHouse);
        return "houses";
    }

}