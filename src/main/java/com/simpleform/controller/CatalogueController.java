package com.simpleform.controller;


import com.simpleform.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
    public class CatalogueController {
        private List<Book> books; // Liste des livres dans le catalogue

        public CatalogueController() {
            // Initialisation du catalogue avec des livres
            books = new ArrayList<>();
            books.add(new Book("Les Misérables", "Umberto Eco", "Roman historique", true));
            books.add(new Book("Le Nom de la Rose", "Roman policier", "Roman policier", false));
            books.add(new Book("Le Seigneur des Anneaux", "J.R.R. Tolkien", "Fantasy, Aventure", true));
            books.add(new Book("Le Petit Prince", "Antoine de Saint-Exupéry", "Conte philosophique, Jeunesse", true));
            books.add(new Book("Guerre et Paix", "Léon Tolstoï", "Roman historique, Littérature classique", false));
            books.add(new Book("Le Comte de Monte-Cristo", "Alexandre Dumas", "Roman d'aventure, Littérature classique", false));
            books.add(new Book("Romeo et Juliette", "William Shakespeare", "Théâtre, Romance", true));

        }

        @GetMapping("/catalogue")
        public String showCatalogue(Model model) {
            model.addAttribute("books", books);
            return "catalogue";
        }

        @PostMapping("/search")
        public String searchBooks(@RequestParam("searchTerm") String searchTerm, Model model) {
            List<Book> searchResults = books.stream()
                    .filter(book -> book.getTitle().contains(searchTerm)
                            || book.getAuthor().contains(searchTerm)
                            || book.getCategory().contains(searchTerm))
                    .collect(Collectors.toList());

            model.addAttribute("books", searchResults);
            return "catalogue";
        }
    }
