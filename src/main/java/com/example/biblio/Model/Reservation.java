package com.example.biblio.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Reservation")

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "livre")
    private  Book book;

    @NotNull
    @Column(nullable = false, name= "Date_retour")
    private LocalDate Date= LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "user")
    private  Users user;


}
