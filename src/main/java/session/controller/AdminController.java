package session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import session.model.Apartments;
import session.model.UserAccount;
import session.model.UserProfile;
import session.service.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private UserHouseServiceImpl userHouseService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("")
    public String admin() {

        return "redirect:/admin/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        List<UserAccount> listUser = adminService.listUser();
        List<UserAccount> listAdmin = adminService.listAdmin();

        model.addAttribute("listUser", listUser);
        model.addAttribute("listAdmin", listAdmin);

        UserAccount user = userService.getUserLogin();
        UserProfile profile = user.getProfile();
        session.setAttribute("profileLog", profile);

        return "admin/dashboard";
    }


    @GetMapping("/edit-user")
    public String editUser(@RequestParam("id") int id, Model model) {
        UserProfile profile = adminService.getProfileById(id);

        model.addAttribute("profile", profile);

        return "admin/edit-user";
    }

    @PostMapping("/editProfileProcess")
    public String saveEditUser(@Valid @ModelAttribute("profile") UserProfile profile, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "admin/edit-user";
        }

        adminService.editUser(profile);

        return "redirect:/admin/dashboard";
    }


    @GetMapping("/mark-admin/{idUser}")
    public String markAdmin(@PathVariable("idUser") int id) {
        adminService.markAsAdmin(id);

        return "redirect:/admin/dashboard";
    }


    @GetMapping("/house-management")
    public String houseManagement(Model model) {
        List<Apartments> listHouse = adminService.listHouses();
        model.addAttribute("listHouse", listHouse);
        return "admin/house-management";
    }

    @GetMapping("/deactivate/{idHouse}")
    public String deactivateCarPost(@PathVariable("idHouse") int id) {
        userHouseService.deactivateHousePost(id);

        return "redirect:/admin/house-management";
    }

    @GetMapping("/activate/{idHouse}")
    public String activateCarPost(@PathVariable("idHouse") int id) {
        userHouseService.activateHousePost(id);

        return "redirect:/admin/house-management";
    }

}
