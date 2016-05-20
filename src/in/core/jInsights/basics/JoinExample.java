/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.core.jInsights.basics;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sumit kumar saurav<sumitk@cdac.in>
 *
 */
class XTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }

}

public class JoinExample {

    public static void main(String[] args) {
        XTask xTask = new XTask();
        Thread tA = new Thread(xTask);
        Thread tB = new Thread(xTask);
        tA.start();

        try {
            // other thread join tA after it completes its execution 
            // tA.join();
            // other thread join tA after 1000 millisecond
            tA.join(1000);

        } catch (InterruptedException ex) {
            Logger.getLogger(JoinExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        tB.start();
        System.out.println(Thread.currentThread().getName() + ".... is completed");
    }
}
