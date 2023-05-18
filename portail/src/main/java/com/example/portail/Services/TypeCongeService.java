package com.example.portail.Services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.portail.Repositories.TypeCongeRepo;
import com.example.portail.models.TypeConge;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TypeCongeService {
    final TypeCongeRepo typeCongeRepo;

    public void insertTypeConge(TypeConge typeConge) {
        typeCongeRepo.save(typeConge);
    }

    public Collection<TypeConge> getAllTypes() {
        return this.typeCongeRepo.findAll();
    }
}
