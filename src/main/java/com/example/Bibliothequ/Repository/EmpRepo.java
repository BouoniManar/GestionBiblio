package com.example.Bibliothequ.Repository;

import com.example.Bibliothequ.Model.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<EmpEntity, Integer> {
}
