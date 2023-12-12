package com.chinabank;

import com.chinabank.Pojo.Bank;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Bank> banks = new BankDao().selectAll();
        for(Bank b: banks) {
            System.out.println(b.getActno());
        }
    }
}
