package com.gupao.concurrent_thread.expand;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/11/28-20:13
 */
public class Account {
    private String accountName;
    private int balance; //余额

    public Account(String accountName, int balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void debit(int amount){
        this.balance-=amount;
    }
    public void credbit(int amount){
        this.balance+=amount;
    }
}
