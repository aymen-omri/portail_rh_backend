package com.example.portail.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portail.models.PdfFile;

public interface PdfFileRepo extends JpaRepository<PdfFile , Long> {
    
}
