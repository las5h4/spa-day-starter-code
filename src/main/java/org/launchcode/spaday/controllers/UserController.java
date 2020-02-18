package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors, Model model) {
        // add form submission handling code here
        if (user.getPassword() != user.getVerify() || errors.hasErrors()) {
//            model.addAttribute("thisUser", user);
//            model.addAttribute("users", UserData.getAll());
            String passwordError = "Errors!";
            String prevUsername = user.getUsername();
            String prevEmail = user.getEmail();
            model.addAttribute("passwordError", passwordError);
            model.addAttribute("prevUsername", prevUsername);
            model.addAttribute("prevEmail", prevEmail);
            return "user/add";
        } else {
            UserData.add(user);
            return "user/index";
        }

    }

    @GetMapping("{id}")
    public String displayUserDetail(Model model, @PathVariable int id){
        model.addAttribute("user", UserData.getById(id));
        return "user/detail";
    }
}
