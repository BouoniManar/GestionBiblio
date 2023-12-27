package com.example.Bibliothequ.Service;

import com.example.Bibliothequ.Model.EmpEntity;

import java.util.List;

public interface EmpService {
    List<EmpEntity> getAll();
    EmpEntity getById(int id);
    EmpEntity update(EmpEntity empEntity, int id);
    void delete(int id);
    EmpEntity save(EmpEntity empEntity);


}
