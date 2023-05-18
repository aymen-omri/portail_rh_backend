package com.example.portail.Services;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.portail.Repositories.DemandeDeclarRepo;
import com.example.portail.Repositories.PdfFileRepo;
import com.example.portail.models.DemandeDeclar;
import com.example.portail.models.PdfFile;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PdfService {

    final PdfFileRepo pdfFileRepo;
    final DemandeDeclarRepo demandeDeclarRepo;

    public void insertFile(MultipartFile file, long id_demande_declar) throws IOException {
        DemandeDeclar demandeDeclar = demandeDeclarRepo.findById(id_demande_declar).get();
        var fileToSave = PdfFile.builder()
                .type(file.getContentType())
                .name(file.getName())
                .file(file.getBytes())
                .demandeDeclar(demandeDeclar)
                .src("data:" + file.getContentType() + ";base64," + Base64.getEncoder().encodeToString(file.getBytes()))
                .build();
        pdfFileRepo.save(fileToSave);
    }

}
