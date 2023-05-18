package com.example.portail.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.portail.Services.auth.AuthenticationRequest;
import com.example.portail.Services.auth.AuthenticationService;
import com.example.portail.Services.auth.RegisterRequest;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/add_admin")
    public ResponseEntity<?> addAdmin(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.addAdmin(request));
    }

    @PostMapping("/accept/{id}")
    public ResponseEntity<?> acceptEmployee(@PathVariable("id") long id) throws AddressException, MessagingException {
        return ResponseEntity.ok(service.acceptEmployee(id));
    }

    @PostMapping("/decline/{id}")
    public ResponseEntity<?> declineEmployee(@PathVariable("id") long id) throws AddressException, MessagingException {
        return ResponseEntity.ok(service.declineEmployee(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @GetMapping("/bymat/{matricule}")
    public ResponseEntity<?> getByMatricule(@PathVariable("matricule") String matricule) {
        return ResponseEntity.ok(service.getUserByMatricule(matricule));
    }

}
