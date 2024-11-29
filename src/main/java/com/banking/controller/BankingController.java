package com.banking.controller;

import com.banking.dto.BankingDto;
import com.banking.service.BankingService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/banking")

public class BankingController {

    private BankingService bankingService;


    public BankingController(BankingService bankingservice) {
        this.bankingService = bankingservice;
    }

    @GetMapping("/{id}")
        public ResponseEntity<BankingDto> getAccountById(long id){
            BankingDto bankingDto = bankingService.getBankingById(id);
            return ResponseEntity.ok(bankingDto);
        }

     @PutMapping("/{id}/withdraw")
     public ResponseEntity<BankingDto> deposit( @PathVariable long id, @RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        BankingDto bankingDto = bankingService.withdraw(id,amount);
        return ResponseEntity.ok(bankingDto);


    }

    }

