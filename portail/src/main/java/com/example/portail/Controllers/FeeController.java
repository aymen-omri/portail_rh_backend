package com.example.portail.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.portail.Services.FeeService;
import com.example.portail.models.Fee;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/fee")
@RestController
@RequiredArgsConstructor
public class FeeController {

    final FeeService feeService;

    @PostMapping("/add_fee")
    public ResponseEntity<String> addFee(@RequestBody Fee fee) {
        feeService.insertFee(fee);
        return ResponseEntity.ok("Fee inserted successfully!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Fee>> getAll() {
        return ResponseEntity.ok(feeService.getAllFees());
    }

}
