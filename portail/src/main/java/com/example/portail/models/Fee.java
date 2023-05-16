package com.example.portail.models;

import java.util.ArrayList;
import java.util.List;
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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_fee;
    private String description;
    private double price;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "fee")
    List<PdfFile> pdfFiles = new ArrayList<PdfFile>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_user")
    private User user;
    
}
