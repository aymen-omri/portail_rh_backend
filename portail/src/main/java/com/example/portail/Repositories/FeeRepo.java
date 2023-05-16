package com.example.portail.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portail.models.Fee;

public interface FeeRepo extends JpaRepository<Fee , Long> {
    
}
