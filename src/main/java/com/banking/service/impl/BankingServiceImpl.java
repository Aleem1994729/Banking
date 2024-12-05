package com.banking.service.impl;

import com.banking.dto.BankingDto;
import com.banking.mapper.BankingMapper;
import com.banking.model.Banking;
import com.banking.repo.BankingRepo;
import com.banking.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Service;

@Service
public class BankingServiceImpl implements BankingService {

    @Autowired
    private BankingRepo bankingRepository;


    @Override
    public BankingDto getBankingById(long id) {;
        Banking banking = bankingRepository.findById(id).orElseThrow(() ->  new RuntimeException ("Account does not exists"));
        return BankingMapper.mapToBankingDto(banking);
    }

    @Override
    public BankingDto deposit(long id, double depositAmount) {
        Banking yourAccount = bankingRepository.findById(id).orElseThrow(() ->  new RuntimeException ("Account does not exists"));
        double total= yourAccount.getBalance()+ depositAmount;
        yourAccount.setBalance(total);
        Banking updatedAccountInDB =  bankingRepository.save(yourAccount);
        return BankingMapper.mapToBankingDto(updatedAccountInDB);
    }

    @Override
    public BankingDto withdraw(long yourAccountNumber, double withdrawAmount) {
        Banking yourAccount = bankingRepository.findById(yourAccountNumber).orElseThrow(() ->  new RuntimeException ("Account does not exists"));
        double total = yourAccount.getBalance()- withdrawAmount;
        yourAccount.setBalance(total);
        Banking updatedAccountInDB = bankingRepository.save(yourAccount);
        return BankingMapper.mapToBankingDto(updatedAccountInDB);
    }

    @Override
    public BankingDto saveAccount(Banking account) {
        Banking yourSavedAccountInBD = bankingRepository.save(account);
        return BankingMapper.mapToBankingDto(yourSavedAccountInBD);
    }

    @Override
    public String deleteAccount(long id) {
        Banking yourAccount= bankingRepository.findById(id).orElseThrow(() ->  new RuntimeException ("Account does not exists"));
           bankingRepository.delete(yourAccount);
              return "Account is deleted";

    }
}

