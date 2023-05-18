package com.example.portail.Controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.portail.Services.TypeCongeService;
import com.example.portail.models.TypeConge;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/type_conge")
@RequiredArgsConstructor
public class TypeCongeController {
    final TypeCongeService typeCongeService;

    @PostMapping
    public ResponseEntity<?> insertTypeConge(@RequestBody TypeConge typeConge) {
        try {
            typeCongeService.insertTypeConge(typeConge);
            return ResponseEntity.ok("ok!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("something went wrong!");
        }
    }

    @GetMapping("all")
    public ResponseEntity<Collection<TypeConge>> getAll() {
        return ResponseEntity.ok(typeCongeService.getAllTypes());
    }

}
