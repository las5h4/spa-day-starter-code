package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
            model.addAttribute(user);
            return "user/index";
        }
        else {
            String passwordError;
            String prevUsername;
            String prevEmail;
            prevUsername = user.getUsername();
            prevEmail = user.getEmail();
            passwordError = "Passwords did not match. Try again!";
            model.addAttribute("passwordError", passwordError);
            model.addAttribute("prevUsername", prevUsername);
            model.addAttribute("prevEmail", prevEmail);
            return "user/add";
        }
    }
}
