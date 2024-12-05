package com.banking.service;

import com.banking.dto.BankingDto;
import com.banking.model.Banking;

public interface BankingService {

     BankingDto getBankingById(long id);
     BankingDto deposit(long id,double amount);

     BankingDto withdraw(long id, double amount);

     BankingDto saveAccount(Banking account);

      String deleteAccount( long id);

}
