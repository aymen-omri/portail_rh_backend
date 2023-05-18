package com.example.portail.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portail.models.Justificatif;

public interface JustificatifRepo extends JpaRepository<Justificatif , Long> {
    
}
