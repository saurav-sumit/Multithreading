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
class Counter implements Runnable {

    private int count;

    @Override
    public void run() {
        // Try this with and without synchronized 
       // synchronized (this) {
            for (int i = 0; i < 50; i++) {
                
                count++;

                System.out.println(Thread.currentThread().getName() + " is incremented counter :" + count);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       // }
    }

    public int getCount() {
        return count;
    }

}

public class SynchronizedBlockExample {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread tA = new Thread(counter);
        Thread tB = new Thread(counter);
        Thread tC = new Thread(counter);
        tA.start();
        tB.start();
        tC.start();
        try {
            tA.join();
            tB.join();
            tC.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(SynchronizedBlockExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Final Count : " + counter.getCount());
    }

}
