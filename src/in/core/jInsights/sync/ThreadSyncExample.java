/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.core.jInsights.sync;

/**
 *
 * @author sumit kumar saurav<sumitk@cdac.in>
 *
 */
class CustAccount {

    private int balance = 7000;

    public synchronized void withdraw(int amount) {
        balance = balance - amount;
    }

    public int getBalance() {
        return balance;
    }

    public synchronized void deposite(int amount) {
        balance = balance - amount;

    }

}

class Transcation implements Runnable {

    final CustAccount acc;

    public Transcation(CustAccount acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            makewithdrwal(1000);
        }
    }

    private synchronized void makewithdrwal(int amount) {

        if (acc.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName()
                    + " is going to with draw and balance : " + acc.getBalance());
            acc.withdraw(amount);
            System.out.println(Thread.currentThread().getName()
                    + " is completed transaction and  balance  : " + acc.getBalance());

        } else {
            System.out.println(Thread.currentThread().getName() + " Overdrawn ");
        }
    }

}

public class ThreadSyncExample {

    public static void main(String[] args) {
        CustAccount acc = new CustAccount();
        Transcation tranc = new Transcation(acc);
        Thread tA = new Thread(tranc);
        Thread tB = new Thread(tranc);
        tA.start();
        tB.start();
    }
}
