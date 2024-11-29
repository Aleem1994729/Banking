package com.banking.mapper;

import com.banking.dto.BankingDto;
import com.banking.model.Banking;

public class BankingMapper {

    public static Banking mapToBanking(BankingDto bankingDto){
        Banking banking = new Banking (bankingDto.getId(), bankingDto.getAccountHolderName(), bankingDto.getBalance());
        return banking;
    }
    public static BankingDto mapToBankingDto(Banking banking){
        BankingDto bankingDto = new BankingDto(banking.getId(),banking.getAccountholdername(),banking.getBalance());
        return bankingDto;
    }

}
