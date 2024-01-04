package com.example.biblio.Service;

import com.example.biblio.Model.Reservation;
import com.example.biblio.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservation;


    public List<Reservation> getAllReservation() {

        return this.reservation.findAll();
    }


    public Reservation getOneReservationById(int id) {

        return this.reservation.findById(id).orElse(null);
    }


    public Reservation updateReservation(Reservation res, int id) {
        Optional<Reservation> existReservation = this.reservation.findById( id);

        return res;
    }


    public void deleteReservation(int id) {
        this.reservation.deleteById(id);

    }


    public Reservation saveReservation(Reservation reservation) {
        return this.reservation.save(reservation);
    }

}
