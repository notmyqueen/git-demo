package com.example.bank.practice.pojo;

import org.springframework.stereotype.Component;

@Component
public class BankAccount {
    private String actno;
    private Double balance;

    public BankAccount() {
    }

    public BankAccount(String actno, Double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "actno='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }
}
