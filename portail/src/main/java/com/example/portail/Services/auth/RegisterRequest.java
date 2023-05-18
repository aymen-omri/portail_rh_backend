package com.example.portail.Services.auth;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String password;
    private String email;
    private String matricule;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String cin;
    private String genre;
    private int status;
    private String phoneNumber;
    private String adresse;
}
