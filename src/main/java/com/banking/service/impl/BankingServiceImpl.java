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
    public BankingDto deposit(long id, double amount) {
        Banking banking = bankingRepository.findById(id).orElseThrow(() ->  new RuntimeException ("Account does not exists"));
        double total= banking.getBalance()+ amount;
        banking.setBalance(total);
        Banking savedBanking = bankingRepository.save(banking);
        return BankingMapper.mapToBankingDto(savedBanking);

    }

    @Override
    public BankingDto withdraw(long id, double amount) {
        Banking banking = bankingRepository.findById(id).orElseThrow(() ->  new RuntimeException ("Account does not exists"));
        double total= banking.getBalance()- amount;
        banking.setBalance(total);
        Banking savedBanking = bankingRepository.save(banking);
        return BankingMapper.mapToBankingDto(savedBanking);
    }
}

