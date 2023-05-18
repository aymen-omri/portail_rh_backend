package com.example.portail.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DemandeDeclar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_demandeDeclar ; 
    private double montant ; 
    private LocalDate date ; 
    private String description ;
    private int status ; 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "demandeDeclar")
    Collection<PdfFile> pdfFiles = new ArrayList<PdfFile>();
}
