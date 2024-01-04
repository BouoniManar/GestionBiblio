package com.example.biblio.Model;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.List;
@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Book")

public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private String price;
    private Date datePublication;
    private Long copiesDisponibles;

    public Book(Integer id, String name, String author, String price, Date datePublication,Long copiesDisponibles) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.datePublication = datePublication;
        this.copiesDisponibles = copiesDisponibles;
    }
    public Book() {
        super();
        // TODO Auto-generated constructor stub
    }
    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    @OneToMany(mappedBy ="book",cascade = CascadeType.ALL,fetch = FetchType.LAZY)

    private List<Reservation> reservation;

    @OneToMany(mappedBy ="book",cascade = CascadeType.ALL,fetch = FetchType.LAZY)

    private List<Emprunts> emprunt;

}


