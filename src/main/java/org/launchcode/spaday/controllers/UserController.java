package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
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
            return "user/add";
        }
    }

    @GetMapping("{id}")
    public String displayUserDetail(Model model, @PathVariable int id){
        model.addAttribute("user", UserData.getById(id));
        return "user/detail";
    }
}
