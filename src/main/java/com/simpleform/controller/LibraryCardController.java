package com.simpleform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibraryCardController {

    @GetMapping("/assign-card")
    public String showAssignCardForm() {
        return "assign-card"; // Retourne le nom de la vue HTML pour afficher le formulaire
    }

    @PostMapping("/assign-card")
    public String assignCard(@RequestParam("cardNumber") String cardNumber,
                             @RequestParam("expirationDate") String expirationDate,
                             @RequestParam("cvv") String cvv,
                             Model model) {



        model.addAttribute("cardNumber", cardNumber);
        model.addAttribute("expirationDate", expirationDate);

        return "success";
    }
}