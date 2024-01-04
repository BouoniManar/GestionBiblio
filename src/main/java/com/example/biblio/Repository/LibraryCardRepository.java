package com.example.biblio.Repository;


import com.example.biblio.Model.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryCardRepository extends JpaRepository<LibraryCard, Integer> {
}
