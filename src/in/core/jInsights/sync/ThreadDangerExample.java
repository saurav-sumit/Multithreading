/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.core.jInsights.sync;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sumit kumar saurav<sumitk@cdac.in>
 *
 */
class Incrementer implements Runnable {

    int counter = 0;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            increment();
        }
    }

    public void increment() {
    // public synchronized void increment() {
        try {

            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Incrementer.class.getName()).log(Level.SEVERE, null, ex);
        }
        ++counter;
        System.out.println(Thread.currentThread().getName() + " : counter : " + counter);
    }
}

public class ThreadDangerExample {

    public static void main(String[] args) {

        Incrementer incr = new Incrementer();
        Thread tA = new Thread(incr);
        Thread tB = new Thread(incr);
        tA.start();
        tB.start();

    }
}
