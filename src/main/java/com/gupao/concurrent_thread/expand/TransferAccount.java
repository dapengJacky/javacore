package com.gupao.concurrent_thread.expand;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/11/28-20:14
 */
public class TransferAccount implements Runnable{
    private Account fromAccount; //转出账户
    private Account toAccount; //转入账户
    private int amount;

    public TransferAccount(Account fromAccount, Account toAccount, int amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        while(true){
            synchronized (fromAccount){
                synchronized (toAccount){
                    if(fromAccount.getBalance()>=amount){
                        fromAccount.debit(amount);
                        toAccount.credbit(amount);
                    }
                }
                System.out.println(fromAccount.getAccountName()+"----"+fromAccount.getBalance());
                System.out.println(toAccount.getAccountName()+"----"+toAccount.getBalance());
            }
        }
    }
}
