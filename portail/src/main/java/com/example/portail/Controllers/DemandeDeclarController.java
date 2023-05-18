package com.example.portail.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.portail.Services.DemandeDeclarService;
import com.example.portail.models.DemandeDeclar;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/demande_declar")
@RequiredArgsConstructor
public class DemandeDeclarController {

    final DemandeDeclarService demandeDeclarService;

    @PostMapping("add")
    public ResponseEntity<?> insertDemandeDeclar(@RequestBody DemandeDeclar demandeDeclar) {
        try {
            demandeDeclarService.insertDemandeDeclar(demandeDeclar);
            return ResponseEntity.ok("inserted successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDemandeDeclar() {
        return ResponseEntity.ok(demandeDeclarService.getAll());
    }

}
