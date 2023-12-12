package net.bank.execeptions;

/*
    余额不足的异常
 */
public class MoneyNotEnoughException extends Exception {
    public MoneyNotEnoughException() {
    }

    public MoneyNotEnoughException(String msg) {
        super(msg);
    }

}
