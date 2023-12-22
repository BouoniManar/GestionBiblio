package com.simpleform.repository;

import com.simpleform.model.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryCardRepository extends JpaRepository<LibraryCard, Integer> {
}
