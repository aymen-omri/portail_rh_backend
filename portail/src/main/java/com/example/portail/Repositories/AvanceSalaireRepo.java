package com.example.portail.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.portail.models.AvanceSalaire;

public interface AvanceSalaireRepo extends JpaRepository<AvanceSalaire, Long> {
    @Query("select a from AvanceSalaire a where a.user.matricule=?1")
    List<AvanceSalaire> getAvanceSalaireByMatricule(String matricule);
}
