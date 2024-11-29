package com.banking.dto;

public class BankingDto {

    private  Long id;
    private  String  accountHolderName;
    private double  balance;

    public BankingDto(Long id, String accountholdername, double balance) {
        this.id =id;
        this.accountHolderName= accountholdername;
        this.balance =balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }


}
