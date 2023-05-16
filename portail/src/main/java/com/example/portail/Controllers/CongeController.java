package com.example.portail.Controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portail.Services.CongeService;
import com.example.portail.models.Conge;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/v1/conge")
@RequiredArgsConstructor
public class CongeController {
    final CongeService congeService;

    @PostMapping("/employee/add_conge")
    public ResponseEntity<String> askForConge(@RequestBody Conge conge) {
        try {
            congeService.askForConge(conge);
            return ResponseEntity.ok("Votre demande de congé est en cours!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/admin/accept/{id}")
    public ResponseEntity<String> accept(@PathVariable("id") long id) {
        try {
            congeService.acceptConge(id);
            return ResponseEntity.ok("Votre demande à été acceptée!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/admin/decline/{id}")
    public ResponseEntity<String> decline(@PathVariable("id") long id) {
        try {
            congeService.declineConge(id);
            return ResponseEntity.ok("Votre demande à été rejetée!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/admin/all")
    public ResponseEntity<Collection<Conge>> congeList() {
        return ResponseEntity.ok(congeService.getAllConge());
    }
}
