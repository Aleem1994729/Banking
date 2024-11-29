package com.banking.model;

import jakarta.persistence.*;

@Entity
@Table(name="banking")

public class Banking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountholdername;
    private  double balance;

    public Banking(long id,String accountholdername,double balance){
        this.id = id;
        this.accountholdername = accountholdername;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccountholdername(String accountholdername) {
        this.accountholdername = accountholdername;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountholdername() {
        return accountholdername;
    }

    public double getBalance() {
        return balance;
    }
}
