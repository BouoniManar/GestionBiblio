package com.example.biblio.Repository;

import com.example.biblio.Model.Emprunts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpruntRepository extends JpaRepository<Emprunts, Integer > {


}
