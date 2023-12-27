package com.example.Bibliothequ.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpController {

    @GetMapping("/Acceuil")
    public String home(Model model) {
        return "Acceuil";

    }
}
