package com.simpleform.service;

import com.simpleform.model.LibraryCard;
import com.simpleform.repository.LibraryCardRepository;
import org.springframework.stereotype.Service;


@Service
public class LibraryCardService {
    private final LibraryCardRepository libraryCardRepository;

    public LibraryCardService(LibraryCardRepository libraryCardRepository) {
        this.libraryCardRepository = libraryCardRepository;
    }

    public LibraryCard createLibraryCard(String cardNumber) {
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNumber(cardNumber);

        // Autres opérations éventuelles sur la carte de bibliothèque
        return libraryCardRepository.save(libraryCard);
    }

    public LibraryCard getLibraryCardById(Integer cardId) {
        return libraryCardRepository.findById(cardId).orElse(null);
    }

    // Ajoutez d'autres méthodes pour les fonctionnalités supplémentaires

}