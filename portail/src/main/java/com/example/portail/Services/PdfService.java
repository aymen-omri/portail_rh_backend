package com.example.portail.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.portail.Repositories.FeeRepo;
import com.example.portail.Repositories.PdfFileRepo;
import com.example.portail.models.Fee;
import com.example.portail.models.PdfFile;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PdfService {
    final PdfFileRepo pdfFileRepo;
    final FeeRepo feeRepo;

    public void AddPdf(Collection<MultipartFile> files, long id_fee) {
        Fee fee = feeRepo.findById(id_fee).orElse(null);
        if (fee != null) {
            List<PdfFile> pdfFiles = new ArrayList<>();
            files.forEach(file -> {
                try {
                    var pdf = PdfFile.builder()
                            .name(file.getOriginalFilename())
                            .type(file.getContentType())
                            .file(file.getBytes())
                            .fee(fee) // Set the Fee entity using the setter method
                            .build();
                    pdfFiles.add(pdf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            pdfFileRepo.saveAll(pdfFiles);
        }
    }

}
