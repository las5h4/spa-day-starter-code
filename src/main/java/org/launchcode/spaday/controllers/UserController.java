package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
<<<<<<< HEAD
        model.addAttribute("user", user);
        model.addAttribute("verify", verify);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        if (user.getPassword().equals(verify)) {
           return "user/index";
        }
        else {
            model.addAttribute("error", "Passwords do not match");
=======
        // add form submission handling code here
        if ((user.getPassword()).equals(verify)) {
            model.addAttribute("thisUser", user);
            model.addAttribute("users", UserData.getAll());
            UserData.add(user);
            return "user/index";
        }
        else {
            String passwordError = "Passwords did not match. Try again!";
            String prevUsername = user.getUsername();
            String prevEmail = user.getEmail();
            model.addAttribute("passwordError", passwordError);
            model.addAttribute("prevUsername", prevUsername);
            model.addAttribute("prevEmail", prevEmail);
>>>>>>> 208c7f6... Completed bonus missions - added data layer, id functionality, date functionality, user detail page
            return "user/add";
        }

    }

<<<<<<< HEAD

=======
    @GetMapping("{id}")
    public String displayUserDetail(Model model, @PathVariable int id){
        model.addAttribute("user", UserData.getById(id));
        return "user/detail";
    }
>>>>>>> 208c7f6... Completed bonus missions - added data layer, id functionality, date functionality, user detail page
}
