package com.example.portail.Controllers;

import java.util.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.portail.Repositories.FeeRepo;
import com.example.portail.Services.PdfService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/pdf")
@RestController
@RequiredArgsConstructor
public class PdfController {
    final PdfService pdfService;
    final FeeRepo feeRepo ; 

    @PostMapping("/add_pdf/{id_fee}")
    public ResponseEntity<String> addPdf(@RequestParam("files") Collection<MultipartFile> files,
            @PathVariable("id_fee") long id) {
        pdfService.AddPdf(files, id);
        return ResponseEntity.ok("added successfully!");
    }

   
}
