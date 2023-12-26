package session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import session.model.Apartments;
import session.service.UserHouseService;
import session.service.UserHouseServiceImpl;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHouseController {

    @Autowired
    private UserHouseServiceImpl userHouseService;


    @GetMapping("/my-posted-houses")
    public String myPostedHousesPage(Model model) {
        List<Apartments> user = userHouseService.listUserHouse();

        model.addAttribute("userHouse", user);

        return "user/my-posted-house";
    }


    @GetMapping("/post-house")
    public String postHouse(Model model) {
        Apartments house = new Apartments();

        model.addAttribute("house", house);

        return "user/post-house";
    }

    @PostMapping("/postHouseProcess")
    public String postHouseProcess(@Valid @ModelAttribute("house") Apartments house, BindingResult bindingResult,
                                 @RequestParam("imageFile") MultipartFile file, Model model) {

        if (bindingResult.hasErrors()) {
            return "user/post-house";
        }

        if (file.isEmpty()) {
            model.addAttribute("fileError", "House Picture is required");
            return "user/post-house";
        }

        try {
            userHouseService.postHouse(file, house);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "redirect:/user/my-posted-house";
    }


    @GetMapping("/edit-posted-house")
    public String editPostedHouse(@RequestParam("id") int id, Model model) {
        List<Apartments> userHouses = userHouseService.listUserHouse();

        for (Apartments house : userHouses) {
            if (house.getIdHouse() == id) {
                model.addAttribute("house", house);
                return "user/edit-posted-house";
            }
        }

        return "redirect:/user/my-posted-houses";
    }

    @PostMapping("/editHouseProcess")
    public String saveEditHouse(@Valid @ModelAttribute("house") Apartments house, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/edit-posted-house";
        }

        userHouseService.editHouse(house);

        return "redirect:/houses/" + house.getType() + "/" + house.getInfo() + "/" + house.getYear() + "/" + house.getIdHouse();
    }


    @GetMapping("/activate/{idHouse}")
    public String activatePostedCar(@PathVariable("idHouse") int id) {

        userHouseService.activateHousePost(id);

        return "redirect:/user/my-posted-houses";
    }

    @GetMapping("/deactivate/{idHouse}")
    public String deactivatePostedHouse(@PathVariable("idHouse") int id) {

        userHouseService.deactivateHousePost(id);

        return "redirect:/user/my-posted-houses";
    }


    @GetMapping("/upload-house-picture")
    public String uploadPicture(@RequestParam("idHouse") int idHouse, HttpSession session) {
        session.setAttribute("idHouse", idHouse);

        return "user/upload-house-picture";
    }

    @PostMapping("/uploadHousePicture")
    public String uploadHouseImage(@RequestParam("imageFile") MultipartFile imageFile, Model model, HttpSession session) {
        String type = imageFile.getContentType();

        if (type != null && (type.equals("image/jpg") || type.equals("image/jpeg") || type.equals("image/png"))) {
            Apartments house = userHouseService.getHouseById((int) session.getAttribute("idHouse"));

            try {
                userHouseService.saveUploadPicture(imageFile, house);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "redirect:/houses";
        }

        model.addAttribute("message", "File type not suported");
        return "user/upload-house-picture";
    }

}
