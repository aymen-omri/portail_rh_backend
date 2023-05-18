package com.example.portail.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.portail.Repositories.DemandeDeclarRepo;
import com.example.portail.models.DemandeDeclar;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DemandeDeclarService {
    final DemandeDeclarRepo demandeDeclarRepo;

    public void insertDemandeDeclar(DemandeDeclar demandeDeclar) {
        demandeDeclar.setStatus(1);
        demandeDeclarRepo.save(demandeDeclar);
    }

    public List<DemandeDeclar> getAll() {
        return demandeDeclarRepo.findAll();
    }
}
