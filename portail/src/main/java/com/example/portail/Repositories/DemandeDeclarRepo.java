package com.example.portail.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portail.models.DemandeDeclar;

public interface DemandeDeclarRepo extends JpaRepository<DemandeDeclar , Long> {
    
}
