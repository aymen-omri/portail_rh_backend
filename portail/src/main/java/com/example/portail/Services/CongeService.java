package com.example.portail.Services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.portail.Repositories.CongeRepo;
import com.example.portail.models.Conge;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CongeService {
    final CongeRepo congeRepo;

    public void askForConge(Conge conge) {
        conge.setStatus(1);
        congeRepo.save(conge);
    }

    public void acceptConge(long id_conge) {
        congeRepo.findById(id_conge).get().setStatus(3);
    }

    public void declineConge(long id_conge) {
        congeRepo.findById(id_conge).get().setStatus(2);
    }

    public Collection<Conge> getAllConge() {
        return congeRepo.findAll();
    }

}
