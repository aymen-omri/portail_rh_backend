package com.example.portail.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.portail.Services.PdfService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/pdf")
@RestController
@RequiredArgsConstructor
public class PdfController {

    final PdfService pdfService;

    @PostMapping("/add/{id}")
    public ResponseEntity<?> insertPdf(@RequestParam("file") MultipartFile file, @PathVariable("id") long id) {
        try {
            pdfService.insertFile(file, id);
            return ResponseEntity.ok("inserted!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
