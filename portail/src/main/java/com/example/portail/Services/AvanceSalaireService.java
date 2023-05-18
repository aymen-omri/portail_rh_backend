package com.example.portail.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.portail.Repositories.AvanceSalaireRepo;
import com.example.portail.models.AvanceSalaire;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvanceSalaireService {

    final AvanceSalaireRepo avanceSalaireRepo;

    public void addDemandeSalaire(AvanceSalaire avanceSalaire) {
        avanceSalaire.setStatus(1);
        avanceSalaireRepo.save(avanceSalaire);
    }

    @Transactional
    public void acceptAvanceSalaire(long id) {
        AvanceSalaire avanceSalaire = avanceSalaireRepo.findById(id).get();
        avanceSalaire.setStatus(2);
    }

    @Transactional
    public void rejectAvanceSalaire(long id) {
        AvanceSalaire avanceSalaire = avanceSalaireRepo.findById(id).get();
        avanceSalaire.setStatus(3);
    }

    public List<AvanceSalaire> getAllAvanceSalaire() {
        return avanceSalaireRepo.findAll();
    }

    public AvanceSalaire getAvanceSalaireById(long id) {
        return avanceSalaireRepo.findById(id).get();
    }

    public List<AvanceSalaire> getAvanceSalaireByUserMatricule(String matricule) {
        return avanceSalaireRepo.getAvanceSalaireByMatricule(matricule);
    }

    public ResponseEntity<String> deleteAvanceSalaire(long id) {
        AvanceSalaire avanceSalaire = avanceSalaireRepo.findById(id).get();
        if (avanceSalaire.getStatus() == 1) {
            avanceSalaireRepo.deleteById(id);
            return ResponseEntity.ok("deleted!");
        }
        return ResponseEntity.status(404).body("Avance salaire a été validé par l'admin!");
    }
    
    @Transactional
    public ResponseEntity<String> updateAvanceSalaire(long id , AvanceSalaire updatedAvance) {
        AvanceSalaire avanceSalaire = avanceSalaireRepo.findById(id).get();
        if (avanceSalaire.getStatus() == 1) {
            avanceSalaire.setDate_avance(LocalDate.now());
            avanceSalaire.setDescription(updatedAvance.getDescription());
            avanceSalaire.setMontant(updatedAvance.getMontant());
            return ResponseEntity.ok("updated!");
        }
        return ResponseEntity.status(404).body("Avance salaire a été mis a jour!");
    }




}
