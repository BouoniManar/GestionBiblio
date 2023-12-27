package com.example.Bibliothequ.Repository;

import com.example.Bibliothequ.Model.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<ReservationEntity, Integer> {
}
