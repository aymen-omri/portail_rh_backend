package com.example.portail.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portail.models.DemandeModifInf;

public interface DemandeModifInfRepo extends JpaRepository<DemandeModifInf , Long> {
    
}
