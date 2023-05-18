package com.example.portail.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portail.models.TypeConge;

public interface TypeCongeRepo extends JpaRepository<TypeConge , Long> {
    
}
