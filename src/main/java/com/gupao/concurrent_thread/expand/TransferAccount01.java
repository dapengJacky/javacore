package com.gupao.concurrent_thread.expand;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/11/28-20:14
 */
public class TransferAccount01 implements Runnable{
    private Account fromAccount; //转出账户
    private Account toAccount; //转入账户
    private int amount;
    Allocator allocator;

    public TransferAccount01(Account fromAccount, Account toAccount, int amount,Allocator allocator) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.allocator=allocator;
    }

    @Override
    public void run() {
        while(true){
            if(allocator.apply(fromAccount,toAccount)) { //都会在这个地方去获得临界资源
                try {
                    synchronized (fromAccount) {
                        synchronized (toAccount) {//申请不到资源，就已经阻塞
                            if (fromAccount.getBalance() >= amount) {
                                fromAccount.debit(amount);
                                toAccount.credbit(amount);
                            }
                        }
                        System.out.println(fromAccount.getAccountName() + "----" + fromAccount.getBalance());
                        System.out.println(toAccount.getAccountName() + "----" + toAccount.getBalance());
                    }
                }finally {
                    allocator.free(fromAccount,toAccount);
                }
            }
        }
    }
}
