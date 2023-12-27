package com.example.Bibliothequ.Service;

import com.example.Bibliothequ.Model.ReservationEntity;

import java.util.List;

public interface ReservationService {
    List<ReservationEntity> getAll();
    ReservationEntity getById(int id);
    ReservationEntity update(ReservationEntity reservationEntity);
    void delete(int id);
    ReservationEntity save(ReservationEntity reservationEntity);
}
