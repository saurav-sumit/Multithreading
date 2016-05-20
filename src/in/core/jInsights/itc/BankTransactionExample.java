/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.core.jInsights.itc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sumit kumar saurav<sumitk@cdac.in>
 *
 */
class Account {

    private int balance = 5000;

    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is going to withdraw  : " + amount);
        if (balance < amount) {
            System.out.println(Thread.currentThread().getName() +"  is waiting for deposite [ Insufficient balance ] "+balance);
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
            }
            balance = balance - amount;
            System.out.println(Thread.currentThread().getName() + " withdrawn and avilable balance : " + balance);

        } else {
            balance = balance - amount;
            System.out.println(Thread.currentThread().getName() + " withdrawn and avilable balance : " + balance);
        }

    }

    public synchronized void deposite(int amount) {

        balance = balance + amount;
        System.out.println(Thread.currentThread().getName() + " deposited and balance : " + balance);
        notify();
    }

}

public class BankTransactionExample {

    public static void main(String[] args) {

        final Account ac = new Account();

        new Thread() {

            @Override
            public void run() {
                ac.withdraw(10000);
            }

        }.start();

        new Thread() {

            @Override
            public void run() {
                ac.deposite(10000);
            }

        }.start();
    }
}
