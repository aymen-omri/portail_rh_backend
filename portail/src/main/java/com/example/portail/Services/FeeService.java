package com.example.portail.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.portail.Repositories.FeeRepo;
import com.example.portail.models.Fee;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeeService {
     final FeeRepo feeRepo;

     public void insertFee(Fee fee){
        feeRepo.save(fee);
     }

     public List<Fee> getAllFees(){
        return feeRepo.findAll();
     }

    
}
