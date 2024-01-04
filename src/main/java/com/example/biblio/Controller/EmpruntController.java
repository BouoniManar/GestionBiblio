package com.example.biblio.Controller;

import com.example.biblio.Model.Book;
import com.example.biblio.Model.Emprunts;

import com.example.biblio.Model.Users;
import com.example.biblio.Service.BookService;
import com.example.biblio.Service.EmpruntService;
import com.example.biblio.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller


public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;
    @Autowired
    private BookService service;
    @Autowired
    private  UsersService usersService;

    @GetMapping("/oneEmprunts/{id}")
    public Emprunts GetOneEmprunts(@PathVariable("id") int id){
        return this.empruntService.getOneEmpruntsById( id);

    }

    @GetMapping("/listeLivre")
    public String listeLivre(Model model) {
        List <Book> allBook = service.getAlllivre();
        model.addAttribute("allListLivre" , allBook);
        return "listeLivre";
    }

    @GetMapping("/emprunt")
    public String emprunt(Model model) {
        List <Emprunts> allEmprunt = empruntService.getAllEmprunt();
        model.addAttribute("allListEmprunt" , allEmprunt);
        return "emprunt";
    }

    @GetMapping("/formEmprunt/{livre}/{user}")
    public String showforum(Model model , @PathVariable("livre") int livreId, @PathVariable("user") int userId) {
        model.addAttribute("livre", livreId);
        System.out.println(livreId);
        System.out.println(userId);
        model.addAttribute("user", userId);
        model.addAttribute("addemprunt", new Emprunts());
        return "create";
    }

    @PostMapping("/addEmprunt/{livre}/{user}")
    public String addEmprunt(@ModelAttribute("addemprunt") Emprunts addemprunt, @PathVariable("livre") int livre ) {
        Book exitbook = service.getOneLivreById(livre);
        Users exitusers = usersService.getOneUserById(1);
        addemprunt.setBook(exitbook);
        addemprunt.setUser(exitusers);

        empruntService.saveEmprunts(addemprunt);
        return "redirect:/emprunt";
    }

    @GetMapping("/updateEmprunt/{id}")
    public String showPageUpdate(@PathVariable("id") int empruntid,Model model) {
        Emprunts existeemprunt = empruntService.getOneEmpruntsById(empruntid);
        model.addAttribute("updemprunt", existeemprunt);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("updemprunt") Emprunts updemprunt ,@PathVariable ("id") int id) {
        Emprunts empruntupdated = empruntService.getOneEmpruntsById(id);

        if (empruntupdated.getDate_debut() != null) {
            updemprunt.setDate_debut(empruntupdated.getDate_debut());
        }
        if (empruntupdated.getUser() != null) {
            updemprunt.setUser(empruntupdated.getUser());
        }
        if (empruntupdated.getBook() != null) {
            updemprunt.setBook(empruntupdated.getBook());
        }
        this.empruntService.updateEmprunts(updemprunt, id);
        return "redirect:/emprunt";
    }
    @GetMapping(value = "/deleteEmprunts/{id}")
    public String DeleteEmprunts(@PathVariable ("id") int id){

            this.empruntService.deleteEmprunts(id);
            return "redirect:/emprunt";


    }

}
