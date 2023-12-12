package com.chinabank.Pojo;

public class Bank {
    private int id;
    private String actno;
    private Long balance;

    public Bank() {
    }

    public Bank(int id, String actno, Long balance) {
        this.id = id;
        this.actno = actno;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
