package com.example.biblio.Controller;

import com.example.biblio.Model.Users;
import com.example.biblio.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

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
