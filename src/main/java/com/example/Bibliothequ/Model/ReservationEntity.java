package com.example.Bibliothequ.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Reservation")

public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
