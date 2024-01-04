package com.example.biblio.Service;

import com.example.biblio.Model.Emprunts;
import com.example.biblio.Repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmpruntService  {

    @Autowired
    private EmpruntRepository emprunts;


    public List<Emprunts> getAllEmprunt() {
        return this.emprunts.findAll();
    }


    public Emprunts getOneEmpruntsById(int id) {
        return this.emprunts.findById( id).orElse(null);
    }


    public Emprunts updateEmprunts(Emprunts emp, int id) {
        Optional<Emprunts> existEmprunts = this.emprunts.findById(id);
        if (existEmprunts.isPresent()) {
            Emprunts emprunts1 = existEmprunts.get();
            emprunts1.setDate_debut(emp.getDate_debut());
            emprunts1.setDate_fin(emp.getDate_fin());
            return emprunts.save(emprunts1);

        }else {
            return null;
        }

    }
    public void deleteEmprunts(int id) {
        this.emprunts.deleteById(id);

    }

    public Emprunts saveEmprunts(Emprunts emprunts) {
        return this.emprunts.save(emprunts);
    }
}
