package com.example.biblio.Controller;


import com.example.biblio.Model.Book;
import com.example.biblio.Model.Reservation;
import com.example.biblio.Model.Users;
import com.example.biblio.Service.BookService;

import com.example.biblio.Service.ReservationService;
import com.example.biblio.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller

public class ReservationController {

    @Autowired
    private BookService service;
    @Autowired
    private UsersService usersService;
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/allReservation")
    public String GetAllReservation(Model model){
        List <Reservation> allreservation = reservationService.getAllReservation();
        model.addAttribute("allListreservation" , allreservation);
        return "Reservation";
    }
    @PostMapping( "/saveReservation")
    public Reservation PostAllReservation(@RequestBody Reservation reservation){
        return this.reservationService.saveReservation(reservation);
    }
    @GetMapping("/oneReservation/{id}")
    public Reservation GetOneReservation(@PathVariable("id") int id){
        return this.reservationService.getOneReservationById( id);
    }
    @PutMapping("/update/{id}")
    public Reservation PostAllReservation(@RequestBody Reservation reservation ,@PathVariable ("id") int id){
        return this.reservationService.updateReservation(reservation , id);
    }

    @GetMapping(value = "/deletereservation/{id}")
    public String DeleteReservation(@PathVariable ("id") int id){

        this.reservationService.deleteReservation(id);
        return "redirect:/allReservation";


    }
    @GetMapping("/addreservation/{livre}/{user}")
    public String addEmprunt(@ModelAttribute("addreservation") Reservation addreservation, @PathVariable("livre") int livre ) {
        Book exitbook = service.getOneLivreById(livre);
        Users exitusers = usersService.getOneUserById(1);
        addreservation.setBook(exitbook);
        addreservation.setUser(exitusers);

        reservationService.saveReservation(addreservation);
        return "redirect:/allReservation";
    }
}
