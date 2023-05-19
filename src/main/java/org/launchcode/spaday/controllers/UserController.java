package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors, Model model, String verify) {
        model.addAttribute("user", user);
        model.addAttribute("errors", errors);
        model.addAttribute("verify", verify);


        if(errors.hasErrors() || !user.getPassword().equals(verify)) {
            return "user/add";
        } else {
            return "redirect:";
        }

    }


}
