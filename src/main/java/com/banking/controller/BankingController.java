package com.banking.controller;

import com.banking.dto.BankingDto;
import com.banking.model.Banking;
import com.banking.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/banking")
public class BankingController {

    @Autowired
    private BankingService bankingService;


    @GetMapping("/{id}")
    public ResponseEntity<BankingDto> getAccountById(@PathVariable("id") long id) {
        BankingDto bankingDto = bankingService.getBankingById(id);
        return ResponseEntity.ok(bankingDto);
    }


    @PutMapping("/{id}/withdraw")
    public ResponseEntity<BankingDto> withdraw(@PathVariable("id") long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        BankingDto bankingDto = bankingService.withdraw(id, amount);
        return ResponseEntity.ok(bankingDto);

    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<BankingDto> deposit(@PathVariable("id") long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        BankingDto bankingDto = bankingService.deposit(id, amount);
        return ResponseEntity.ok(bankingDto);
    }

    @DeleteMapping("/{id}/deleteAccount")
    public ResponseEntity <String> deleteAccount(@PathVariable ("id") long id) {
          String message = bankingService.deleteAccount(id);
           return ResponseEntity .ok(message);

    }

    @PostMapping( "/createAccount")
    public ResponseEntity<BankingDto> createAccount(@RequestBody Banking account) {
        BankingDto bankingDto = new BankingDto();
        try {
            bankingDto = bankingService.saveAccount(account);
            return new ResponseEntity<>(bankingDto, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(bankingDto, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}

