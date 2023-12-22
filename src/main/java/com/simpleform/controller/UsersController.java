package com.simpleform.controller;

import org.springframework.ui.Model;
import com.simpleform.model.Users;
import com.simpleform.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new Users());
        return "register_page";
    }


    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new Users());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Users users) {
        System.out.println("register request: " + users);
        Users registeredUser = usersService.registerUser(users.getLogin(), users.getPassword(), users.getEmail());
        return registeredUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Users users, Model model) {
        System.out.println("login request: " + users);
        Users authenticated = usersService.authenticate(users.getLogin(), users.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getLogin());
            return "personal_page";

        } else {
            return "error_page";
        }

    }
}
