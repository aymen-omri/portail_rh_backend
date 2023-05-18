package com.example.portail.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Justificatif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_just;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_conge")
    Conge conge;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_demandeDeclar")
    DemandeDeclar demandeDeclar;

}
