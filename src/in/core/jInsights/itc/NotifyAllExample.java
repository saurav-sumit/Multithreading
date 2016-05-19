/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.core.jInsights.itc;

import static java.lang.Thread.currentThread;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sumit kumar saurav<sumitk@cdac.in>
 *
 */
class Calculator implements Runnable {

    private int total;

    @Override
    public void run() {

        synchronized (this) {
            for (int i = 1; i <= 100; i++) {
                total += i;
            }
            System.out.println(Thread.currentThread().getName() + " has completed computation and going to notify .....");
            notifyAll();
        }
    }

    public int getTotal() {
        return total;
    }

}

class Reader implements Runnable {

    Calculator c;

    public Reader(Calculator calc) {
        this.c = calc;
    }

    @Override
    public void run() {

        synchronized (c) {
            System.out.println(Thread.currentThread().getName() + "is waiting for notification");
            try {

                c.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Total is " + c.getTotal() + "by " + currentThread().getName());
        }

    }

}

public class NotifyAllExample {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Reader reader = new Reader(calc);
        Thread tA = new Thread(reader, "Reader-X");
        Thread tB = new Thread(reader, "Reader-Y");
        Thread tC = new Thread(reader, "Reader-Z");
        tA.start();
        tB.start();
        tC.start();

//        new Reader(calc).start();
//        new Reader(calc).start();
//        new Reader(calc).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(NotifyAllExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        Thread t = new Thread(calc, "calculator");
        t.start();
    }
}
