package com.example.biblio.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
@Data
@Entity
@Getter
@Setter
@AllArgsConstructor

@RequiredArgsConstructor
@Table(name = "Emprunts")


public class Emprunts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotNull
    @Column(nullable = false, name= "date_debut")
    private LocalDate date_debut;

    @NotNull
    @Column(nullable = false, name= "date_fin")
    private LocalDate date_fin;

    @ManyToOne
    @JoinColumn(name = "livre_id_livre")
    @JsonIgnore
    private  Book book;

    @ManyToOne
    @JoinColumn(name = "user_id_user")
    @JsonIgnore
    private  Users user;

}
