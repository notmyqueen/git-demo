package com.example.servlet3;

public class CreditAccount extends Account{
    @Override
    public void withdraw() {
        System.out.println("You withdraw money.");
    }
}
